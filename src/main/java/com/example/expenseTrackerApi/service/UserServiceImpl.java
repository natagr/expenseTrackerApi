package com.example.expenseTrackerApi.service;

import com.example.expenseTrackerApi.domain.entity.PasswordChangeRequest;
import com.example.expenseTrackerApi.domain.entity.User;
import com.example.expenseTrackerApi.domain.entity.dto.UserDto;

import com.example.expenseTrackerApi.domain.mapper.UserMapper;
import com.example.expenseTrackerApi.repository.UserRepository;
import com.example.expenseTrackerApi.service.interfaces.UserService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

//    @Override
//    public User createUser(UserModel userModel) {
//        if(userRepository.existsByEmail(userModel.getEmail())){
//            throw new ItemAlreadyExistsException("User is already register with email: "+userModel.getEmail());
//        }
//
//        User newUser = new User();
//        BeanUtils.copyProperties(userModel, newUser);
//        newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
//        return userRepository.save(newUser);
//    }
    @Transactional(readOnly = true)
    @Override
    public UserDto getUserById() {
        return userRepository.findById(getLoggedInUser().getId()).map(userMapper::toDto).orElseThrow(()->new EntityExistsException("user nor found for id: "+getLoggedInUser().getId()));
    }
    @Transactional
    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = getLoggedInUser();
        userMapper.updateUser(userDto, existingUser);
        return userMapper.toDto(existingUser);
    }
    @Transactional
    @Override
    public void deleteUser() {
        User existingUser=getLoggedInUser();
        userRepository.delete(existingUser);
    }
    @Transactional(readOnly = true)
    @Override
    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = (User)authentication.getPrincipal();

        return userRepository.findById(user.getId()).orElseThrow(() -> new UsernameNotFoundException("User not found for the id"+user.getId()));
    }

    @Transactional
    public void updatePasswordForUser( PasswordChangeRequest passwordChangeRequest) {
        User user=getLoggedInUser();
        user.setPassword(passwordEncoder.encode(passwordChangeRequest.getNewPassword()));
    }

}
