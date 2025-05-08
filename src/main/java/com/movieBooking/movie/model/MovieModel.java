package com.movieBooking.movie.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long movieID;

        @Column(nullable = false)
        private String title;

        @Column(length = 1000)
        private String description;

        private int duration; // in minutes

        private String genre;

        private String language;

        private LocalDate releaseDate;


}
