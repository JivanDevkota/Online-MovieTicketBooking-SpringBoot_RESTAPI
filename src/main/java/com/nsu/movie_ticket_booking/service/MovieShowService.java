package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.dto.MovieShowDto;

import java.util.List;

public interface MovieShowService {


    public MovieShowDto getMovieShowById(Long movieId);
    public List<MovieShowDto> getAllMovieShows();
    public MovieShowDto createMovieShow(MovieShowDto movieShowDto);
    public List<MovieShowDto> searchMovieShowByName(String keyword);

    public List<MovieShowDto>nowShowing();
    public List<MovieShowDto> comingSoon();
}
