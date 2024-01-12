package com.example.expenseTrackerApi.controller;

import com.example.expenseTrackerApi.entity.User;
import com.example.expenseTrackerApi.entity.UserModel;
import com.example.expenseTrackerApi.service.interfaces.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    @GetMapping("/profile")
    public ResponseEntity<User> readUser(){
        return new ResponseEntity<User>(userService.readUser(), HttpStatus.OK);

    }

    @PutMapping("/profile")
    public ResponseEntity<User> updateUser(@RequestBody UserModel user){
        return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);

    }

    @DeleteMapping("/deactivate")
    public ResponseEntity<HttpStatus> deleteUser(){
        userService.deleteUser();
        return new ResponseEntity<HttpStatus>( HttpStatus.NO_CONTENT);

    }

}
