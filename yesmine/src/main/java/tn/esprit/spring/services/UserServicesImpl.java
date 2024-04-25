package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.ChangePasswordRequest;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.IUserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
@RequiredArgsConstructor
public class UserServicesImpl implements IUserServices {

    private IUserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User addUser(User instructor) {
        return userRepository.save(instructor);
    }

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User instructor) {
        return userRepository.save(instructor);
    }

    @Override
    public User retrieveUser(Long IdUser) {
        return userRepository.findById(IdUser).orElse(null);
    }
    @Override
    public void removeUser(Long IdUser) {
        userRepository.deleteById(IdUser);
    }

    @Override
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        userRepository.save(user);
    }

}
