package com.nsu.movie_ticket_booking.model;

import com.nsu.movie_ticket_booking.dto.MovieShowDto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate showDate;
    private LocalTime startTime;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @OneToMany(mappedBy = "movieShow")
    private List<Ticket> tickets = new ArrayList<>();


    public MovieShowDto toMovieShowDto() {
        MovieShowDto movieShowDto = new MovieShowDto();
        movieShowDto.setId(id);
        movieShowDto.setShowDate(showDate);
        movieShowDto.setStartTime(startTime);

        if (movie != null) {
            movieShowDto.setMovieId(movie.getId());
            movieShowDto.setMovieName(movie.getMovieTitle());
            movieShowDto.setMovieDescription(movie.getMovieDescription());
            movieShowDto.setPosterPath(movie.getPosterPath());
            movieShowDto.setLength(movie.getLength());
            movieShowDto.setActor(movie.getActor());
            movieShowDto.setActress(movie.getActress());
            movieShowDto.setDirector(movie.getDirector());
        }

        if (screen != null) {
            movieShowDto.setScreenId(screen.getId());
            movieShowDto.setScreenName(screen.getName());
            movieShowDto.setTheaterName(screen.getTheater().getName());
            movieShowDto.setLocationName(screen.getTheater().getLocation().getName());
        }
        return movieShowDto;
    }
}