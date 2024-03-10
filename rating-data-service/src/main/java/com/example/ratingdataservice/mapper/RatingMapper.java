package com.example.ratingdataservice.mapper;

import com.example.ratingdataservice.dto.RatingDTO;
import com.example.ratingdataservice.models.RatingEntity;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
	public RatingDTO toRatingDTO(RatingEntity ratingEntity) {
		RatingDTO ratingDTO = new RatingDTO();
		ratingDTO.setMovieId(ratingEntity.getMovieId());
		ratingDTO.setRating(ratingEntity.getRating());
		return ratingDTO;
	}

	public RatingEntity toRatingEntity(RatingDTO ratingDTO) {
		RatingEntity ratingEntity = new RatingEntity();
		ratingEntity.setMovieId(ratingDTO.getMovieId());
		ratingEntity.setRating(ratingDTO.getRating());
		return ratingEntity;
	}
}
