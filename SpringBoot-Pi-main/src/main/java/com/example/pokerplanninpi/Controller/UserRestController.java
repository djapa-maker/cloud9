package com.example.pokerplanninpi.Controller;

import com.example.pokerplanninpi.GlobalService.IUserServices;
import com.example.pokerplanninpi.entity.ChangePasswordRequest;
import com.example.pokerplanninpi.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

//@Tag(name = "\uD83D\uDC69\u200D\uD83C\uDFEB User Management")
@RestController
@RequestMapping("/api/v1/Users")
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
