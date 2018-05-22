/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.service;



import com.sabinnov.sabpay.models.User_Role;
import com.sabinnov.sabpay.repository.RoleRepository;
import com.sabinnov.sabpay.repository.User_RoleRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author karimata
 */
@Service
public class User_RoleService {
    private User_RoleRepository role_userRepository;
    private UserService userService;
    private RoleRepository roleRepository;

    public User_Role addRoleUser(Integer user, Integer role) {        
          
         return role_userRepository.mySave(user, role);
    }
    
    
   
}
