package com.movieBooking.movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private String title;
    private String description;
    private int duration;
    private String genre;
    private String language;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

}
