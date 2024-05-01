package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.IUserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserServicesImpl implements IUserServices {

    private IUserRepository userRepository;

    @Override
    public User addUser(User instructor) {
       return userRepository.save(instructor);
    }

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long IdUser,User instructor) {
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



}
