package com.example.expenseTrackerApi.service.interfaces;


import com.example.expenseTrackerApi.entity.User;
import com.example.expenseTrackerApi.entity.UserModel;

public interface UserService {

    User createUser(UserModel userModel);

    User readUser();

    User updateUser(UserModel userModel);

    void deleteUser();

    User getLoggedInUser();

}
