package com.sabinnov.sabpay.controller;


import com.sabinnov.sabpay.models.User;
import com.sabinnov.sabpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List<User> getUsers(){
        return userService.getAllUsers();
    }


    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(@RequestParam("user") long user){
        return userService.getItemByUserId(user);
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addItem(@RequestParam("userId") long userId,
                          @RequestParam("name") String name,
                          @RequestParam("email") String email){
        if(userService.addUser(userId,name,email) != null){
            // ici a gerer avec des loggers
            return "User Added Successfully";
        }else{
            return "Something went wrong ! :(";
        }
    }
    @RequestMapping("/deteteUser")
    @ResponseBody
    public String deteteUser(@RequestParam("userId") int userId){
        if(userService.deleteUser(userId) == 1){
            return "User Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}
