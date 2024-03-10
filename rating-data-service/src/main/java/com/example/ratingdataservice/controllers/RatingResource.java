package com.example.ratingdataservice.controllers;

import com.example.ratingdataservice.dto.RatingDTO;
import com.example.ratingdataservice.models.UserRating;
import com.example.ratingdataservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

	@Autowired
	private RatingService ratingService;

	@GetMapping("/{movieId}")
	public ResponseEntity<?> getRating(@PathVariable("movieId") String movieId) {
		try {
			RatingDTO ratingDTO = ratingService.getRating(Long.parseLong(movieId));
			if (ratingDTO != null) {
				return ResponseEntity.ok(ratingDTO);
			} else {
				// Rating not found for the given movieId
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rating not found for movieId: " + movieId);
			}
		} catch (NumberFormatException e) {
			// Invalid movieId provided
			return ResponseEntity.badRequest().body("Invalid movieId: " + movieId);
		} catch (Exception e) {
			// Unexpected error occurred
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error fetching rating for movieId: " + movieId);
		}
	}

	//TODO: add userID to rating table to implement this method correctly
	@GetMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		return new UserRating(ratingService.getAllRatings());
	}

	@PostMapping("/rating/add")
	public RatingDTO addRating(@RequestBody RatingDTO ratingDTO) {
		return ratingService.saveRating(ratingDTO);
	}
}
