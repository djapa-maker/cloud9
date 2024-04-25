package tn.esprit.spring.auth;


import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<?> register( //? reponse peut changer
      @RequestBody RegisterRequest request
  ) throws MessagingException {
    var response=service.register(request);
    if(request.isMfaEnabled()){
      return ResponseEntity.ok(response);
    }
    return ResponseEntity.accepted().build();
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }
  @PostMapping("/verify")
  public ResponseEntity<?> verifyCode(
          @RequestBody VerificationRequest verificationRequest
  )
  {
    return ResponseEntity.ok(service.verifyCode(verificationRequest));
  }
  @GetMapping("/activate-account")
  public void confirm(
          @RequestParam String emailtoken
  ) throws MessagingException {
    service.activateAccount(emailtoken);
  }
}
