package com.sabinnov.sabpay.controller;


import com.sabinnov.sabpay.models.User;
import com.sabinnov.sabpay.service.UserService;
import com.sabinnov.sabpay.exceptions.UserNotFoundException;
import com.sabinnov.sabpay.models.Role;
import com.sabinnov.sabpay.models.User_Role;
import com.sabinnov.sabpay.repository.User_RoleRepository;
import com.sabinnov.sabpay.service.User_RoleService;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/sab")
public class UserController {
	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    private  User_RoleService user_roleService;
    private  User_RoleRepository user_roleRepository;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/api/registration/",method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(
            value = "Create user in sab application",
            notes = "Adds a user, specified name, last name, telephone, password",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity< ?> addNewUser(@Valid User user) {
         HashMap<String, String> map = new HashMap<>();
         
        LOGGER.info("Creating User : {}", user.toString());
        /*if (userService.isUserExist(user) != 0){
            
            throw new UserNotFoundException(user.getTelephone());
        }*/

       // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        try {
            userService.addUser(user); 
           
           //user_roleService.addRoleUser(1, 1);  
            
            
        }catch (Exception e ){
            LOGGER.error("Internal error : " + e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
           map.put("Response","User Added Successfully");
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

// *********************Login*************************************
    
    @RequestMapping(value = "/api/login/",method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(
            value = "Login user in sab application",
            notes = "Login user, specified  email and password",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity< ?> login(@RequestParam(value = "telephone", required = true) String telephone, @RequestParam(value = "password", required = true) String password) {
         HashMap<String, String> map = new HashMap<>();
        if (userService.checkLogin(telephone,password) == 0){
            
            throw new UserNotFoundException( telephone,password);
        }else{
        
          // user.getPassword(bCryptPasswordEncoder.decode(user.getPassword()));
        try {
            userService.updateActive(telephone);
        }catch (Exception e ){
            LOGGER.error("Internal error : " + e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("Response", "connecté");

        return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }


}