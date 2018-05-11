package com.sabinnov.sabpay.controller;


import com.sabinnov.sabpay.models.User;
import com.sabinnov.sabpay.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.sabinnov.sabpay.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;


//@ComponentScan("com.sabinnov.sabpay.controller")
@RestController
@RequestMapping("/sab")
public class UserController {
	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Create user",response = User.class)
    @RequestMapping(value = "/api/registration/",method = RequestMethod.POST, produces = "application/json")
    @ResponseBody

    public ResponseEntity< ?> addNewUser(@RequestBody User user,  UriComponentsBuilder ucBuilder) {
        //Nous loggons la requete
        LOGGER.info("Creating User : {}", user);
        //Nous verifions s'il existe
        /*if (userService.isUserExist(user)){
            // ici avant de personaliser nos execption
            return new ResponseEntity(new IllegalAccessError("Unable to create. A User with email " +
                    user.getEmail() + " already exist."),HttpStatus.CONFLICT);
        }*/
        //ici tu va verifier si le user est deja dans la BD
        // si il existe tu renvoi existe sinon tu le cree

        //nous catchons au cas ou BD nest pas accessible
        try {
            userService.addUser(user);
        }catch (Exception e ){
            LOGGER.error("Internal error : " + e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //Nous retournon le HTTP status correspondant
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }


}