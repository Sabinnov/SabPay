package com.sabinnov.sabpay.controller;


import com.sabinnov.sabpay.models.User;
import com.sabinnov.sabpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class UserController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String active
			, @RequestParam String email, @RequestParam String lastname, @RequestParam String name,
                        @RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setActive(active);
		n.setEmail(email);
                n.setLastname(lastname);
                n.setName(name);
                n.setPassword(password);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}