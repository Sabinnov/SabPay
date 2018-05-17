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
        return userRepository.findByEmail(email);
    }
    public boolean isUserExist(User user) {
        return findByEmail(user.getEmail())!= null;
    }
    
    
    /* public int isUserLogin(User user) {
        //return userRepository.isUserVerify(user.getEmail(),user.getPassword())!= null;
         return VerificationLogin(user.getEmail(), user.getPassword());
     }*/
     public int checkLogin(String email, String password){
         return userRepository.isUserVerify(email,password);
     }
     
     
     
    
   /*  public int Connecter(User user){
        
        // userRepository.Connecter(user.getEmail()); 
         return Activer(user.getEmail());
    }*/
      
     public int Activer(String email){
         
         return userRepository.Connecter(email);
     }
   

}