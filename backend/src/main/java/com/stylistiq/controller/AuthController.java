package com.stylistiq.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stylistiq.config.security.CustomUserDetailsService;
import com.stylistiq.config.security.JwtTokenProvider;
import com.stylistiq.exception.UserException;
import com.stylistiq.model.dto.request.LoginRequest;
import com.stylistiq.model.entity.User;
import com.stylistiq.model.response.AuthResponse;
import com.stylistiq.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	private JwtTokenProvider jwtProvider;
	private CustomUserDetailsService customUserService;

	public AuthController(UserRepository userRepo, PasswordEncoder passwordEncoder, JwtTokenProvider jwtProvider,
			CustomUserDetailsService customUserService) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.jwtProvider = jwtProvider;
		this.customUserService = customUserService;
	}

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {

		System.out.println("Post Mapping Callled....");
		String username = user.getUsername();
		String password = user.getPassword();

		String fullName = user.getFullName();

		User isuserExist = userRepo.findByUsername(username);

		if (isuserExist != null) {
			throw new UserException("Email Already Used with Another account");
		}

		User createdUser = new User();
		createdUser.setUsername(username);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setFullName(fullName);
		createdUser.setCreatedAt(LocalDateTime.now());

		User saveUser = userRepo.save(createdUser);

		UserDetails userDetails = customUserService.loadUserByUsername(saveUser.getUsername());

		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtProvider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(token);
		authResponse.setMessage("Signin Success");

		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest) throws UserException {

		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();

		System.out.println("*********Requested Details: " + username + " " + password + "************");

		Authentication authentication = authenticate(username, password);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtProvider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse(token, "Signin Success");
		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
	}

	public Authentication authenticate(String username, String password) {
		UserDetails userDetails = customUserService.loadUserByUsername(username);

		if (userDetails == null)
			throw new BadCredentialsException("Invalid Username or Password");

		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

	}

}
