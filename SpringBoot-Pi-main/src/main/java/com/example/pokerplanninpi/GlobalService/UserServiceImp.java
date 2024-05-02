package com.example.pokerplanninpi.GlobalService;

import com.example.pokerplanninpi.Repository.UserRepository;
import com.example.pokerplanninpi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private  final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();    }
}
