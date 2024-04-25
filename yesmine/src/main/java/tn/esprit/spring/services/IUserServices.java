package tn.esprit.spring.services;

import tn.esprit.spring.entities.ChangePasswordRequest;
import tn.esprit.spring.entities.User;

import java.security.Principal;
import java.util.List;

public interface IUserServices {

    User addUser(User user);

    List<User> retrieveAllUsers();

    User updateUser(User user);

    User retrieveUser(Long IdUser);
    void removeUser (Long IdUser);
    void changePassword(ChangePasswordRequest request, Principal connectedUser);
    //User addInstructorAndAssignToCourse(User instructor, Long numCourse);

}
