package com.example.expenseTrackerApi.service.interfaces;


import com.example.expenseTrackerApi.domain.entity.PasswordChangeRequest;
import com.example.expenseTrackerApi.domain.entity.User;
import com.example.expenseTrackerApi.domain.entity.dto.UserDto;

public interface UserService {

//    User createUser(UserModel userModel);

    UserDto getUserById();

    UserDto updateUser(UserDto userDto);

    void deleteUser();

    User getLoggedInUser();

    void updatePasswordForUser(PasswordChangeRequest passwordChangeRequest);

}
