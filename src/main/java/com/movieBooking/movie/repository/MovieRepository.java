package com.movieBooking.movie.repository;

import com.movieBooking.movie.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long> {
}
