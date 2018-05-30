package com.sabinnov.sabpay.service;

import com.sabinnov.sabpay.models.User;
import com.sabinnov.sabpay.models.User_Role;
import com.sabinnov.sabpay.repository.UserRepository;
import com.sabinnov.sabpay.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class UserService {

    private UserRepository userRepository;

     @Autowired
    private UserRoleRepository roleuserRepository;
 
    
    public void addRoleUser(User user) {       
        int userId = userRepository.findByTelephoneId(user.getTelephone());
        
         User_Role user_role =new User_Role(1,userId);
        
         roleuserRepository.save(user_role);            
         
   }
    
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
     
     public int logoutActive(Integer id){
         
         return  userRepository.Logout(id);
     }

   
   

}