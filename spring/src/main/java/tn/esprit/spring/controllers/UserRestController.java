package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserServices;

import java.util.List;

@Tag(name = "\uD83D\uDC69\u200D\uD83C\uDFEB User Management")
@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserServices UserServices;

    @Operation(description = "Add User")
    @PostMapping("/add")
    public User addUser(@RequestBody User User){
        return UserServices.addUser(User);
    }

    @Operation(description = "Retrieve all Users")
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return UserServices.retrieveAllUsers();
    }

    @Operation(description = "Update User ")
    @PutMapping("/update/{id-User}")
    public User updateUser(@PathVariable("id-User") Long numUser,@RequestBody User User){
        return  UserServices.updateUser(numUser,User);
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


}
