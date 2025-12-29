package com.stylistiq.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.stylistiq.repository.UserRepository;
import com.stylistiq.exception.UserException;
import com.stylistiq.model.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {

		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Use not found with username - " + username);
		}
		List<GrantedAuthority> authroties = new ArrayList<>();

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authroties);
	}

}
