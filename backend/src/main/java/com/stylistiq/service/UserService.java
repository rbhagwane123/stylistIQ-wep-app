package com.stylistiq.service;

import com.stylistiq.exception.UserException;
import com.stylistiq.model.entity.User;

public interface UserService {

	public User findUserById(Long userId) throws UserException;

	public User findUserProfileByJwt(String jwt) throws UserException;

}
