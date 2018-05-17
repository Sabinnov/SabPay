package com.sabinnov.sabpay.controller;


import com.sabinnov.sabpay.models.User;
import com.sabinnov.sabpay.service.UserService;
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
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/api/registration/",method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(
            value = "Create user in sab application",
            notes = "Adds a user, specified name, last name, email, password",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity< ?> addNewUser(@Valid User user) {
        LOGGER.info("Creating User : {}", user.toString());
        if (userService.isUserExist(user)){
            return new ResponseEntity(new IllegalAccessError("Unable to create. A User with email " +
                    user.getEmail() + " already exist."),HttpStatus.CONFLICT);
        }

       // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        try {
            userService.addUser(user);
        }catch (Exception e ){
            LOGGER.error("Internal error : " + e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("User Added Successfully",HttpStatus.OK);
    }

// *********************Login*************************************
    
    @RequestMapping(value = "/api/login/",method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(
            value = "Login user in sab application",
            notes = "Login user, specified  email and password",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity< ?> login(@RequestParam(value = "email", required = true) String email, @RequestParam(value = "password", required = true) String password) {
         HashMap<String, String> map = new HashMap<>();
        if (userService.VerificationLogin(email,password) == 0){
            return new ResponseEntity(new IllegalAccessError("Unable to login. A User with email " +
                    email + " is not exist."),HttpStatus.CONFLICT);
        }else{
        
          // user.getPassword(bCryptPasswordEncoder.decode(user.getPassword()));
        try {
            userService.Activer(email);
        }catch (Exception e ){
            LOGGER.error("Internal error : " + e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("Response", "connecté");

        return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }


}