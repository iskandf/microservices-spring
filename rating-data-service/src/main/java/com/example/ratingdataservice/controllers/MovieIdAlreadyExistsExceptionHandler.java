package com.example.ratingdataservice.controllers;

import com.example.ratingdataservice.exceptions.MovieIdAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieIdAlreadyExistsExceptionHandler {

	@ExceptionHandler(MovieIdAlreadyExistsException.class)
	public ResponseEntity<Object> handleMovieIdAlreadyExistsException(MovieIdAlreadyExistsException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	// Add more exception handlers as needed

}
