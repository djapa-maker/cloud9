package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.ChangePasswordRequest;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserServices;

import java.security.Principal;
import java.util.List;

//@Tag(name = "\uD83D\uDC69\u200D\uD83C\uDFEB User Management")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserServices UserServices;
    @GetMapping("/show")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @Operation(description = "Add User")
    @PostMapping("/add")
    public User addUser(@RequestBody User User){
        return  UserServices.addUser(User);
    }
    
    /*@Operation(description = "Add User and Assign To Course")
    @PutMapping("/addAndAssignToCourse/{numCourse}")
    public User addAndAssignToUser(@RequestBody User User, @PathVariable("numCourse")Long numCourse){
        return  UserServices.addUserAndAssignToCourse(User,numCourse);
    }*/
    @Operation(description = "Retrieve all Users")
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return UserServices.retrieveAllUsers();
    }

    @Operation(description = "Update User ")
    @PutMapping("/update")
    public User updateUser(@RequestBody User User){
        return  UserServices.updateUser(User);
    }

    @Operation(description = "Retrieve User by Id")
    @GetMapping("/get/{id-User}")
    public User getById(@PathVariable("id-User") Long numUser){
        return UserServices.retrieveUser(numUser);
    }
    @Operation(description = "Delete User by Id")
    @DeleteMapping("/delete/{id-User}")
    public void deleteById(@PathVariable("id-User") Long numUser){
        UserServices.removeUser(numUser);
    }

    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
           Principal connectedUser
    ) {
        UserServices.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
}
