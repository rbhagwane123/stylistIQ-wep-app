package com.stylistiq.exception;

import java.util.MissingResourceException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stylistiq.model.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(io.jsonwebtoken.ExpiredJwtException.class)
	public ResponseEntity<?> handleExpiredToken() {

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body(new ErrorResponse(401, "Token expired. Please login again."));
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<?> handleInvalidToken() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(401, "Invalid token"));
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<?> handleInvalidUserName() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(401, "Invalid User or Password"));
	}
	
	@ExceptionHandler(MissingResourceException.class)
    public ResponseEntity<?> handleNotFound(MissingResourceException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(404, ex.getMessage()));
    }
	
	
}
