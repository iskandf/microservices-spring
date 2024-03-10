package com.example.ratingdataservice.repositories;

import java.util.Optional;

import com.example.ratingdataservice.models.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
	boolean existsByMovieId(Long movieId);
	// find by movieID
	Optional<RatingEntity> findByMovieId(Long movieId);
	Optional<RatingEntity> deleteByMovieId(Long movieId);
}
