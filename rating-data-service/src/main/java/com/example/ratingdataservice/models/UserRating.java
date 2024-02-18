package com.example.ratingdataservice.models;

import java.util.List;

public class UserRating {

	List<Rating> userRating;

	public UserRating() {
	}

	public UserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
}
