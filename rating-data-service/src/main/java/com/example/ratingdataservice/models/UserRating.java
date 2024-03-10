package com.example.ratingdataservice.models;

import java.util.List;

import com.example.ratingdataservice.dto.RatingDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRating {
	List<RatingDTO> userRatingEntity;
}
