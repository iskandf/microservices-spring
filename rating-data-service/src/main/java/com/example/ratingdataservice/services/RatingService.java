package com.example.ratingdataservice.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.ratingdataservice.dto.RatingDTO;
import com.example.ratingdataservice.exceptions.MovieIdAlreadyExistsException;
import com.example.ratingdataservice.mapper.RatingMapper;
import com.example.ratingdataservice.models.RatingEntity;
import com.example.ratingdataservice.repositories.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RatingService {
	@Autowired
	private RatingRepository ratingRepository;
	@Autowired
	private RatingMapper ratingMapper;

	public RatingDTO getRating(Long movieId) {
		RatingEntity ratingEntity = ratingRepository.findByMovieId(movieId).orElse(null);
		return ratingMapper.toRatingDTO(ratingEntity);
	}

	public RatingDTO saveRating(RatingDTO ratingDTO) {
		RatingEntity ratingEntity = ratingMapper.toRatingEntity(ratingDTO);
		if (ratingRepository.existsByMovieId(ratingEntity.getMovieId())) {
			throw new MovieIdAlreadyExistsException("MovieId already exists: " + ratingEntity.getMovieId());
		}
		RatingEntity savedRating = ratingRepository.save(ratingEntity);
		return ratingMapper.toRatingDTO(savedRating);
	}

	public void deleteRating(Long movieId) {
		ratingRepository.deleteByMovieId(movieId);
	}

	public RatingDTO updateRating(Long movieId, RatingDTO ratingDTO) {
		RatingEntity ratingEntity = ratingMapper.toRatingEntity(ratingDTO);
		if (ratingRepository.existsById(movieId)) {
			ratingEntity.setId(movieId);
			RatingEntity savedRating = ratingRepository.save(ratingEntity);
			return ratingMapper.toRatingDTO(savedRating);
		} else {
			return null;
		}
	}

	public List<RatingDTO> getAllRatings() {
		List<RatingEntity> all = ratingRepository.findAll();
		return all.stream()
				.map(ratingMapper::toRatingDTO)
				.collect(Collectors.toList());
	}
}
