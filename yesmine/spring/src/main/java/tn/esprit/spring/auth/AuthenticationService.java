package tn.esprit.spring.auth;


import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.spring.configs.JwtService;
import tn.esprit.spring.email.EmailService;
import tn.esprit.spring.email.EmailTemplateName;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repositories.EmailTokenRepository;
import tn.esprit.spring.repositories.IUserRepository;
import tn.esprit.spring.repositories.TokenRepository;
import tn.esprit.spring.tfa.TwoFactorAuthenticationService;
import java.security.SecureRandom;
import javax.mail.MessagingException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final IUserRepository repository;
  private final TokenRepository tokenRepository;
    private final EmailTokenRepository emailtokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
    private final EmailService emailService;
  private final AuthenticationManager authenticationManager;
  private final TwoFactorAuthenticationService tfaService;

    @Value("http://localhost:4200/activate-account")
    private  String activationUrl;

  public AuthenticationResponse register(RegisterRequest request) throws MessagingException {
 var user=User.builder()
         .firstname(request.getFirstname())
         .lastname(request.getLastname())
         .email(request.getEmail())
         .password(passwordEncoder.encode(request.getPassword()))
         .role(Role.User)
         .mfaEnabled(request.isMfaEnabled())
         .build();
 //if mfa enabled--> generate secret
      if(request.isMfaEnabled()){
          user.setSecret(tfaService.generateNewSecret());
      }
     /* var savedUser= repository.save(user);
      sendValidationEmail(savedUser);
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    saveUserToken(savedUser, jwtToken);*/

    return AuthenticationResponse.builder()
            .secretImageUri(tfaService.generateQrCodeImageUri(user.getSecret()))
           /*.accessToken(jwtToken)
            .refreshToken(refreshToken)
            .mfaEnabled(user.isMfaEnabled())*/
            .build();
  }

    /*private void sendValidationEmail(User user) throws MessagingException {
      var newToken= generateAndSaveActivationToken(user);

        emailService.sendEmail(user.getEmail(), user.getfullNname(), EmailTemplateName.ACTIVATE_ACCOUNT,activationUrl,newToken,"Account activation");
    }

    private String generateAndSaveActivationToken(User user) {
      String generatedToken=generateActivationCode(6);
        LocalDateTime createdAt = LocalDateTime.now();
 var emailtoken= EmailToken.builder()
         .emailtoken(generatedToken)
         .createdAt(LocalDateTime.now())
         .expiresAt(LocalDateTime.now().plusMinutes(15))
         .user(user)
         .build();
 emailtokenRepository.save(emailtoken);
      return generatedToken;
    }

    private String generateActivationCode(int length) {
      String characters="0123456789";
      StringBuilder codeBuilder=new StringBuilder();
        SecureRandom secureRandom=new SecureRandom();
        for (int i=0;i<length;i++){
            int randomIndex=secureRandom.nextInt(characters.length()); //0..9
            codeBuilder.append(characters.charAt(randomIndex));
        }
      return codeBuilder.toString();
    }

    private void saveUserToken(User user, String jwtToken) {
    var token = Token.builder()
            .user(user)
            .token(jwtToken)
            .tokenType(TokenType.BEARER)
            .expired(false)
            .revoked(false)
            .build();
    tokenRepository.save(token);
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail()).orElseThrow(() -> new NoSuchElementException("No user with the provided email"));

if(user.isMfaEnabled()){
    return AuthenticationResponse.builder()
            .accessToken("")
            .refreshToken("")
            .mfaEnabled(true)
            .build();
}
      
    var jwtToken = jwtService.generateToken(user);
      var refreshToken = jwtService.generateRefreshToken(user);
      revokeAllUserTokens(user);
   saveUserToken(user,jwtToken);

    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
            .refreshToken(refreshToken)
            .mfaEnabled(false)
        .build();
  }



  private void revokeAllUserTokens(User user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
   if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }

  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    userEmail = jwtService.extractUsername(refreshToken);
    if (userEmail != null) {

      var user = this.repository.findByEmail(userEmail)
              .orElseThrow(() -> new NoSuchElementException("No user with the provided email"));

      if (jwtService.isTokenValid(refreshToken, user)) {
        var accessToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);
        var authResponse = AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .mfaEnabled(false)
                .build();
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }
    public AuthenticationResponse verifyCode(
            VerificationRequest verificationRequest
    ) {
        User user = repository
                .findByEmail(verificationRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("No user found with %S", verificationRequest.getEmail()))
                );
        if (tfaService.isOtpNotValid(user.getSecret(), verificationRequest.getCode())) {

            throw new BadCredentialsException("Code is not correct");
        }
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .mfaEnabled(user.isMfaEnabled())
                .build();
    }

    //@Transactional
    public void activateAccount(String token) throws MessagingException {
        EmailToken savedToken = emailtokenRepository.findByEmailtoken(token)
                // todo exception has to be defined
                .orElseThrow(() -> new RuntimeException("Invalid token"));
        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            sendValidationEmail(savedToken.getUser());
            throw new RuntimeException("Activation token has expired. A new token has been send to the same email address");
        }

        var user = repository.findById(savedToken.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setEnabled(true);
        repository.save(user);

        savedToken.setValidatedAt(LocalDateTime.now());
        emailtokenRepository.save(savedToken);
    }*/
}
