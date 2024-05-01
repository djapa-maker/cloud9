package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.ChangePasswordRequest;
import tn.esprit.spring.entities.User2;
import tn.esprit.spring.repositories.IUserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import tn.esprit.spring.repositories.IUserRepository;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
@RequiredArgsConstructor
public class UserServicesImpl implements IUserServices {

    private IUserRepository UserRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User2 addUser2(User2 instructor) {
        return UserRepository.save(instructor);
    }

    @Override
    public List<User2> retrieveAllUser2s() {
        return UserRepository.findAll();
    }

    @Override
    public User2 updateUser2(User2 instructor) {
        return UserRepository.save(instructor);
    }

    @Override
    public User2 retrieveUser2(Long IdUser2) {
        return UserRepository.findById(IdUser2).orElse(null);
    }

    @Override
    public void removeUser2(Long IdUser2) {
        UserRepository.deleteById(IdUser2);
    }

    @Override
    public void changePassword(ChangePasswordRequest request, Principal connectedUser2) {

        /*var User2 = (User2) ((UsernamePasswordAuthenticationToken) connectedUser2).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), User2.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        User2.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        User2Repository.save(User2);
    }
*/
    }
}
