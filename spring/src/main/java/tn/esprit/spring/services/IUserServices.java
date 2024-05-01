package tn.esprit.spring.services;

import tn.esprit.spring.entities.User;

import java.util.List;

public interface IUserServices {

    User addUser(User user);

    List<User> retrieveAllUsers();

    User updateUser(Long IdUser,User user);

    User retrieveUser(Long IdUser);
    void removeUser (Long IdUser);

    //User addInstructorAndAssignToCourse(User instructor, Long numCourse);

}
