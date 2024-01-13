package com.example.expenseTrackerApi.controller;

import com.example.expenseTrackerApi.domain.entity.dto.UserDto;
import com.example.expenseTrackerApi.service.interfaces.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(){
        return userService.getUserById();
    }

    @PatchMapping("/profile")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);

    }

    @DeleteMapping("/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(){
        userService.deleteUser();
    }

}
