package com.movieBooking.movie.movieServiceImpl;

import com.movieBooking.movie.dto.MovieDTO;
import com.movieBooking.movie.globalExceptionHandler.ResourceNotFoundException;
import com.movieBooking.movie.mapper.MovieMapper;
import com.movieBooking.movie.model.MovieModel;
import com.movieBooking.movie.repository.MovieRepository;
import com.movieBooking.movie.service.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        MovieModel movie = MovieMapper.toEntity(movieDTO);
        movie = movieRepository.save(movie);
        return MovieMapper.toDTO(movie);
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        MovieModel movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with ID: " + id));
        return MovieMapper.toDTO(movie);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(MovieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO updateMovie(Long id, MovieDTO movieDTO) {
        MovieModel movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with ID: " + id));
//        MovieMapper.updateEntity(movie, movieDTO);
//        movie = movieRepository.save(movie);
        return MovieMapper.toDTO(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Movie not found with ID: " + id);
        }
        movieRepository.deleteById(id);
    }
}
