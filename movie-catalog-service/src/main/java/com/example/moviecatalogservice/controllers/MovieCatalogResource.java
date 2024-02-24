package com.example.moviecatalogservice.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		// get all rated movie IDs
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId,
				UserRating.class);

		//get movie info from movie info service by using RestTemplate
		// for each movie ID, call movie info service and get details
		return ratings.getUserRating().stream()
				.map(rating -> {
					Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
					// put them all together
					return new CatalogItem(movie.getName(), "Desc", rating.getRating());
				}).collect(Collectors.toList());

	}

}
