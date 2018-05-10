package com.sabinnov.sabpay.controller;


import com.sabinnov.sabpay.models.User;
import com.sabinnov.sabpay.repository.UserRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping("/sab")
public class UserController {
	@Autowired
	private UserRepository userRepository;


	@RequestMapping(value = "/api/registration/", method = RequestMethod.POST)
    public ResponseEntity< ?> persistPerson(@RequestBody User user,  UriComponentsBuilder ucBuilder) {
		System.out.println("Create user : {} "+ user.toString());

		//ici tu va verifier si le user est deja dans la BD
		// si il existe tu renvoi existe sinon tu le cree
		userRepository.save(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

}