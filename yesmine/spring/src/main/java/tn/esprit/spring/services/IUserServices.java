package tn.esprit.spring.services;

import tn.esprit.spring.entities.ChangePasswordRequest;
import tn.esprit.spring.entities.User2;
import tn.esprit.spring.entities.User;

import java.security.Principal;
import java.util.List;

public interface IUserServices {

    User2 addUser2(User2 User2);

    List<User2> retrieveAllUser2s();

    User2 updateUser2(User2 User2);

    User2 retrieveUser2(Long IdUser2);
    void removeUser2 (Long IdUser2);
    void changePassword(ChangePasswordRequest request, Principal connectedUser2);
    //User2 addInstructorAndAssignToCourse(User2 instructor, Long numCourse);

}
