package com.movieBooking.movie.service;

import com.movieBooking.movie.dto.MovieDTO;

import java.util.List;

public interface IMovieService {
    MovieDTO createMovie(MovieDTO movieDTO);
    MovieDTO getMovieById(Long id);
    List<MovieDTO> getAllMovies();
    MovieDTO updateMovie(Long id, MovieDTO movieDTO);
    void deleteMovie(Long id);
}
