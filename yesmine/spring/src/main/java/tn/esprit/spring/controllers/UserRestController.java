package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.ChangePasswordRequest;
import tn.esprit.spring.entities.User2;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserServices;

import java.security.Principal;
import java.util.List;

//@Tag(name = "\uD83D\uDC69\u200D\uD83C\uDFEB User2 Management")
@RestController
@RequestMapping("/api/v1/User2s")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserServices User2Services;
    @GetMapping("/show")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @Operation(description = "Add User2")
    @PostMapping("/add")
    public User2 addUser2(@RequestBody User2 User2){
        return  User2Services.addUser2(User2);
    }
    
    /*@Operation(description = "Add User2 and Assign To Course")
    @PutMapping("/addAndAssignToCourse/{numCourse}")
    public User2 addAndAssignToUser2(@RequestBody User2 User2, @PathVariable("numCourse")Long numCourse){
        return  User2Services.addUser2AndAssignToCourse(User2,numCourse);
    }*/
    @Operation(description = "Retrieve all User2s")
    @GetMapping("/all")
    public List<User2> getAllUser2s(){
        return User2Services.retrieveAllUser2s();
    }

    @Operation(description = "Update User2 ")
    @PutMapping("/update")
    public User2 updateUser2(@RequestBody User2 User2){
        return  User2Services.updateUser2(User2);
    }

    @Operation(description = "Retrieve User2 by Id")
    @GetMapping("/get/{id-User2}")
    public User2 getById(@PathVariable("id-User2") Long numUser2){
        return User2Services.retrieveUser2(numUser2);
    }
    @Operation(description = "Delete User2 by Id")
    @DeleteMapping("/delete/{id-User2}")
    public void deleteById(@PathVariable("id-User2") Long numUser2){
        User2Services.removeUser2(numUser2);
    }

    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
           Principal connectedUser2
    ) {
        User2Services.changePassword(request, connectedUser2);
        return ResponseEntity.ok().build();
    }
}
