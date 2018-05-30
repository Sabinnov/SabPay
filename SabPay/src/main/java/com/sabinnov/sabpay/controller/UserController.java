package com.sabinnov.sabpay.controller;


import com.sabinnov.sabpay.models.User;
import com.sabinnov.sabpay.service.UserService;
import com.sabinnov.sabpay.exceptions.UserNotFoundException;
import com.sabinnov.sabpay.models.DetailUser;
import com.sabinnov.sabpay.repository.UserRoleRepository;
import com.sabinnov.sabpay.service.UserRoleService;
import com.sabinnov.sabpay.service.detailUserService;
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
    private  UserRoleService userRoleService;
    private  UserRoleRepository userRoleRepository;
    private detailUserService detailUserService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
     @Autowired
    public void setdetailService(detailUserService detailUserService) {
        this.detailUserService = detailUserService;
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
        if (userService.isUserExist(user) != 0){
            
            throw new UserNotFoundException(user.getTelephone());
        }

       // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        try {
            userService.addUser(user);          
           userService.addRoleUser(user);
           
            
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
    
    // *********************logout*************************************
    
    @RequestMapping(value = "/api/logout/",method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(
            value = "Logout user in sab application",
            notes = "logout user, specified  id",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity< ?> logout(@RequestParam(value = "id", required = true) Integer id) {
         HashMap<String, String> map = new HashMap<>();
               
         
        try {
            userService.logoutActive(id);
        }catch (Exception e ){
            LOGGER.error("Internal error : " + e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("Response", "déconnecté");

        return new ResponseEntity<>(map,HttpStatus.OK);
        
    }
    
     // *********************Add Detail User*************************************
    
    @RequestMapping(value = "/api/detailuser/",method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(
            value = "add user detail in sab application",
            notes = "detail user, specified  User detail and telephone",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity< ?> detailuser(@Valid DetailUser detailUser,@RequestParam(value = "telephone", required = true) String telephone) {
         HashMap<String, String> map = new HashMap<>();
               LOGGER.info("Creating User : {}", detailUser.toString());
         
        try {
            detailUserService.addDetailUser(detailUser,telephone);
        }catch (Exception e ){
            LOGGER.error("Internal error : " + e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("Response", "save");

        return new ResponseEntity<>(map,HttpStatus.OK);
        
    }
    
    
    
    


}