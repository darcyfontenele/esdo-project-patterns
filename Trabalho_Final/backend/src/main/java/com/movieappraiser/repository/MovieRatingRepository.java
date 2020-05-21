package com.movieappraiser.repository;

import com.movieappraiser.entity.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRating, Long> {

    List<MovieRating> findMovieRatingByMovieId(Long movieId);

}
