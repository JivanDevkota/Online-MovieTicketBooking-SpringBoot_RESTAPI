package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.dto.MovieDto;
import com.nsu.movie_ticket_booking.model.Movie;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieService {

    public MovieDto createMovie(MovieDto movieDto, MultipartFile file);
    public List<MovieDto> getAllMovie();
    public Movie getById(Long movieId);

}
