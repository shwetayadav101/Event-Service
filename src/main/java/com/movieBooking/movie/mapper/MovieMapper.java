package com.movieBooking.movie.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieBooking.movie.dto.MovieDTO;
import com.movieBooking.movie.model.MovieModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class MovieMapper {
    static ModelMapper modelMapper = new ModelMapper();

    public static MovieModel toEntity(MovieDTO dto) {
        MovieModel dao =  modelMapper.map(dto, MovieModel.class);
        return dao;
    }

    public static MovieDTO toDTO(MovieModel movie) {
        return modelMapper.map(movie, MovieDTO.class);
    }

    // Optional: Update an existing entity with values from request DTO (for PATCH/PUT)
    public static void updateEntity(MovieModel movie, MovieDTO dto) {
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setDuration(dto.getDuration());
        movie.setGenre(dto.getGenre());
        movie.setLanguage(dto.getLanguage());
        movie.setReleaseDate(dto.getReleaseDate());
    }
}
