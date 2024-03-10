package com.example.ratingdataservice.exceptions;

public class MovieIdAlreadyExistsException extends RuntimeException {
	public MovieIdAlreadyExistsException(String message) {
		super(message);
	}

}
