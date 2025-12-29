package com.stylistiq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stylistiq.exception.UserException;
import com.stylistiq.model.entity.User;
import com.stylistiq.service.UserServiceImplementation;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserServiceImplementation userService;

	@GetMapping("/profile")
	public ResponseEntity<User> getUserProfileByJwt(@RequestHeader("Authorization") String jwt) throws UserException {
		User user = userService.findUserProfileByJwt(jwt);
		if(user == null)
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
