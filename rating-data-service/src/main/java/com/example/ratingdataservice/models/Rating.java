package com.example.ratingdataservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ratings")
public class Rating {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "movie_id", nullable = false)
	private Long movieId;
	private int rating;
}
