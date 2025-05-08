package com.movieBooking.movie.controller;

import com.movieBooking.movie.dto.MovieDTO;
import com.movieBooking.movie.service.IMovieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieRequestDTO) {
        MovieDTO createdMovie = movieService.createMovie(movieRequestDTO);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    // READ - get one
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        MovieDTO movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    // READ - get all
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovie(
            @PathVariable Long id,
            @RequestBody MovieDTO movieDTO) {
        MovieDTO updatedMovie = movieService.updateMovie(id, movieDTO);
        return ResponseEntity.ok(updatedMovie);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
