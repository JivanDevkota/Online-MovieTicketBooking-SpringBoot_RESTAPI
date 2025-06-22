package com.nsu.movie_ticket_booking.controller;

import com.nsu.movie_ticket_booking.dto.MovieShowDto;
import com.nsu.movie_ticket_booking.service.MovieService;
import com.nsu.movie_ticket_booking.service.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PublicPageController {

    @Autowired
    private MovieShowService movieShowService;

    @GetMapping("/get/all/movie-shows")
    public ResponseEntity<List<MovieShowDto>> getAllMovieShows() {
        List<MovieShowDto> shows = movieShowService.getAllMovieShows();
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @GetMapping("/get/movie/{id}")
    public ResponseEntity<MovieShowDto> getMovieShowById(@PathVariable Long id) {
        MovieShowDto dto = movieShowService.getMovieShowById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/get/movie-shows/{search}")
    public ResponseEntity<List<MovieShowDto>> getMovieShowsBySearch(@RequestParam String search) {
        List<MovieShowDto> shows = movieShowService.searchMovieShowByName(search);
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @GetMapping("/get/movie-shows/now-showing")
    public ResponseEntity<List<MovieShowDto>> getNowShowing() {
        return ResponseEntity.ok(movieShowService.nowShowing());
    }

    @GetMapping("/get/movie-shows/coming-soon")
    public ResponseEntity<List<MovieShowDto>> getComingSoon() {
        return ResponseEntity.ok(movieShowService.comingSoon());
    }

}
