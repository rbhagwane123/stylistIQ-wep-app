package com.stylistiq.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stylistiq.exception.UserException;
import com.stylistiq.model.entity.User;

import com.stylistiq.model.response.WardrobeResponse;
import com.stylistiq.service.impl.UserServiceImplementation;
import com.stylistiq.service.impl.WardrobeServiceImpl;

@RestController
@RequestMapping("/api/wardrobe")
public class WardrobeController {

	private final WardrobeServiceImpl wardrobeService;
	private final UserServiceImplementation userService;

	public WardrobeController(WardrobeServiceImpl wardrobeService, UserServiceImplementation userService) {
		super();
		this.wardrobeService = wardrobeService;
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<WardrobeResponse>> getUerWardrobe(@RequestHeader("Authorization") String jwt)
			throws UserException {
		User user = userService.findUserProfileByJwt(jwt);
		if (user == null)
			throw new BadCredentialsException("Invalid Username or Password");

		return new ResponseEntity<List<WardrobeResponse>>(wardrobeService.getUserWardrobe(user.getUserId()),
				HttpStatus.OK);
	}

}
