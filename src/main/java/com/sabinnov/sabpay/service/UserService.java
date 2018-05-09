package com.sabinnov.sabpay.service;

import com.sabinnov.sabpay.models.User;
import com.sabinnov.sabpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();

    }


    public User getItemByUserId(long userId){
        User user = userRepository.findByUserId(userId);
        return user;
    }


    public User addUser(long id, String name,String email) {
        User user = new User();

        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    public int deleteUser(long userId){
        User user = userRepository.findByUserId(userId);
        if(user != null){
            userRepository.delete(user);
            return 1;
        }
        return -1;
    }
}
