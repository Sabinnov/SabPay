package com.sabinnov.sabpay.service;

import com.sabinnov.sabpay.models.User;
import com.sabinnov.sabpay.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser (User user){
        return userRepository.save(user);
    }

   

    public void removeUser( Long userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("User not existing in DB"));
        userRepository.delete(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException("This email ["+email+" ] not exist in DB"));
    }
    public boolean isUserExist(User user) {
        return userRepository.findByEmail(user.getEmail())!= null;
    }

}