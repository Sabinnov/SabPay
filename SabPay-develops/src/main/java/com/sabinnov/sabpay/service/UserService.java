package com.sabinnov.sabpay.service;

import com.sabinnov.sabpay.models.User;
import com.sabinnov.sabpay.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    UserRepository userRepository;

    public User addUser (User user){
        return userRepository.save(user);
    }

    public List<User>getAllUsers(){
        return userRepository.findAllUsers();
    }

    public void removeUser( Long userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("User not existing in DB"));
        userRepository.delete(user);
    }

    public boolean isUserExist(User user) {
        return userRepository.findByEmail(user.getEmail())!= null;
    }

}