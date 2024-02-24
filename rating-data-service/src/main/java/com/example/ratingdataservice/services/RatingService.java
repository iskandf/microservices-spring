package com.example.ratingdataservice.services;

import java.util.List;

import com.example.ratingdataservice.models.Rating;
import com.example.ratingdataservice.repositories.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RatingService {
	@Autowired
	private RatingRepository ratingRepository;

	public Rating getRating(Long movieId) {
		return ratingRepository.findById(movieId).orElse(null);
	}

	public Rating saveRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	public void deleteRating(Long movieId) {
		ratingRepository.deleteById(movieId);
	}

	public Rating updateRating(Long movieId, Rating rating) {
		if (ratingRepository.existsById(movieId)) {
			rating.setId(movieId);
			return ratingRepository.save(rating);
		} else {
			return null;
		}
	}

	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}
}
