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

    public int findByTelephone(String telephone){
        return userRepository.findByTelephone(telephone);
    }
    public int isUserExist(User user) {
        return findByTelephone(user.getTelephone());
    }
    
    
    /* public int isUserLogin(User user) {
        //return userRepository.isUserVerify(user.getEmail(),user.getPassword())!= null;
         return VerificationLogin(user.getEmail(), user.getPassword());
     }*/
     public int checkLogin(String telephone, String password){
         return userRepository.isUserVerify(telephone,password);
     }
     
     
     
    
   /*  public int Connecter(User user){
        
        // userRepository.Connecter(user.getEmail()); 
         return Activer(user.getEmail());
    }*/
      
     public int updateActive(String telephone){
         
         return  userRepository.Connecter(telephone);
     }
   

}