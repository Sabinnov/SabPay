/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.service;

import com.sabinnov.sabpay.models.DetailUser;
import com.sabinnov.sabpay.repository.UserRepository;
import com.sabinnov.sabpay.repository.detailUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class detailUserService {
    
     private detailUserRepository detailuserRepository;
        
     @Autowired
     private UserRepository userRepository;
     
    public void addDetailUser(DetailUser DetailUser, String telephone) {       
        int userId = userRepository.findByTelephoneId(telephone);
        
         DetailUser.setUser_id(userId);
        
         detailuserRepository.save(DetailUser);            
         
   }
    
     public detailUserService(detailUserRepository detailuserRepository) {
        this.detailuserRepository = detailuserRepository;
    }
}
