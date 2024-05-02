package com.example.pokerplanninpi.GlobalService;

import com.example.pokerplanninpi.entity.ChangePasswordRequest;
import com.example.pokerplanninpi.entity.User;

import java.security.Principal;
import java.util.List;

public interface IUserServices {

    User addUser(User User);

    List<User> retrieveAllUsers();

    User updateUser(User User);

    User retrieveUser(Long IdUser);
    void removeUser (Long IdUser);
    void changePassword(ChangePasswordRequest request, Principal connectedUser);

}
