package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.dto.MovieShowDto;
import com.nsu.movie_ticket_booking.model.Movie;
import com.nsu.movie_ticket_booking.model.MovieShow;
import com.nsu.movie_ticket_booking.model.Screen;
import com.nsu.movie_ticket_booking.repository.MovieRepository;
import com.nsu.movie_ticket_booking.repository.MovieShowRepository;
import com.nsu.movie_ticket_booking.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieShowServiceImpl implements MovieShowService {

    @Autowired
    private MovieShowRepository movieShowRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreenRepository screenRepository;

    public MovieShowDto createMovieShow(MovieShowDto movieShowDto) {

        Movie movie = movieRepository.findById(movieShowDto.getMovieId()).orElseThrow(() -> new RuntimeException(""));

        Screen screen = screenRepository.findById(movieShowDto.getScreenId()).orElseThrow(() -> new RuntimeException(""));

        MovieShow movieShow = new MovieShow();
        movieShow.setMovie(movie);
        movieShow.setScreen(screen);
        movieShow.setShowDate(movieShowDto.getShowDate());
        movieShow.setStartTime(movieShowDto.getStartTime());

        MovieShow savedShow = movieShowRepository.save(movieShow);
        return savedShow.toMovieShowDto();
    }

    public List<MovieShowDto> getAllMovieShows() {
        return movieShowRepository.findAll().stream().map(MovieShow::toMovieShowDto).collect(Collectors.toList());
    }

    public MovieShowDto getMovieShowById(Long movieId) {
        MovieShow movieShow = movieShowRepository.findById(movieId).orElseThrow(() -> new RuntimeException(""));
        return movieShow.toMovieShowDto();
    }

    public List<MovieShowDto> searchMovieShowByName(String keyword) {
        List<MovieShow> movieShows = movieShowRepository.findByMovie_MovieTitleContainingIgnoreCase(keyword);
        return movieShows.stream().map(MovieShow::toMovieShowDto).collect(Collectors.toList());
    }

    public List<MovieShowDto>nowShowing(){
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
       return movieShowRepository.findByShowDate(today)
               .stream()
               .filter(movieShow -> movieShow.getStartTime().isAfter(now))
               .map(MovieShow::toMovieShowDto)
               .collect(Collectors.toList());
    }

    public List<MovieShowDto> comingSoon() {

        LocalDate today = LocalDate.now();
        return movieShowRepository.findByShowDateAfter(today).stream().map(MovieShow::toMovieShowDto).collect(Collectors.toList());
    }


}
