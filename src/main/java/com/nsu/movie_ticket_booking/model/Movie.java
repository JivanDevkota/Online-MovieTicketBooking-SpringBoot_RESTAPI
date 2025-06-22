package com.nsu.movie_ticket_booking.model;

import com.nsu.movie_ticket_booking.dto.MovieDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieTitle;
    private String movieDescription;
    private int length;
    private String posterPath;
    private String director;
    private String actor;
    private String actress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    private Language language;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    public MovieDto toMovieDto(){
        MovieDto movieDto=new MovieDto();
        movieDto.setId(id);
        movieDto.setMovieTitle(movieTitle);
        movieDto.setMovieDescription(movieDescription);
        movieDto.setLength(length);
        movieDto.setPosterPath(posterPath);

        if (language!=null){
            movieDto.setLanguageId(language.getId());
            movieDto.setLanguageName(language.getName());
        }

        if (category!=null){
            movieDto.setCategoryId(category.getId());
            movieDto.setCategoryName(category.getName());
        }
        return movieDto;
    }
}
