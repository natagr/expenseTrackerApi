package com.example.expenseTrackerApi.service;

import com.example.expenseTrackerApi.entity.User;
import com.example.expenseTrackerApi.entity.UserModel;
import com.example.expenseTrackerApi.exceptions.ItemAlreadyExistsException;
import com.example.expenseTrackerApi.exceptions.ResourceNotFoundException;
import com.example.expenseTrackerApi.repository.UserRepository;
import com.example.expenseTrackerApi.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder bcryptEncoder;
    private final UserRepository userRepository;

    @Override
    public User createUser(UserModel userModel) {
        if(userRepository.existsByEmail(userModel.getEmail())){
            throw new ItemAlreadyExistsException("User is already register with email: "+userModel.getEmail());
        }

        User newUser = new User();
        BeanUtils.copyProperties(userModel, newUser);
        newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    @Override
    public User readUser() {
        Long userId = getLoggedInUser().getId();
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user nor found for id: "+userId));
    }

    @Override
    public User updateUser(UserModel userModel) {
        User existingUser = readUser();
        existingUser.setName(userModel.getName() != null ? userModel.getName() : existingUser.getName());
        existingUser.setEmail(userModel.getEmail() != null ? userModel.getEmail() : existingUser.getEmail());
        existingUser.setPassword(userModel.getPassword() != null ? bcryptEncoder.encode(userModel.getPassword()) : existingUser.getPassword());
        existingUser.setAge(userModel.getAge() != null ? userModel.getAge() : existingUser.getAge());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser() {
        User existingUser=readUser();
        userRepository.delete(existingUser);
    }

    @Override
    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found for the email"+email));
    }


}
