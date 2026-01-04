package com.stylistiq.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylistiq.config.security.JwtTokenProvider;
import com.stylistiq.exception.UserException;
import com.stylistiq.model.entity.User;
import com.stylistiq.repository.UserRepository;
import com.stylistiq.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	JwtTokenProvider jwtProvider;

	public UserServiceImplementation(UserRepository userRepository, JwtTokenProvider jwtProvider) {
		super();
		this.userRepository = userRepository;
		this.jwtProvider = jwtProvider;
	}

	@Override
	public User findUserById(Long userId) throws UserException {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent())
			return user.get();

		return null;
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		// TODO Auto-generated method stub
		String username = jwtProvider.getUsernameFromToken(jwt);

		User user = userRepository.findByUsername(username);
		if (user != null)
			return user;

		return null;

	}

}
