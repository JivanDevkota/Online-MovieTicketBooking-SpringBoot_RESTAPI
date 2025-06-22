package com.nsu.movie_ticket_booking.controller;

import com.nsu.movie_ticket_booking.dto.MovieShowDto;
import com.nsu.movie_ticket_booking.service.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieShowController {

    @Autowired
    private MovieShowService movieShowService;

    @PostMapping("admin/create/movie-shows")
    public ResponseEntity<MovieShowDto> createMovieShow(@RequestBody MovieShowDto dto) {
        MovieShowDto created = movieShowService.createMovieShow(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("admin/get-all/movie-shows")
    public ResponseEntity<List<MovieShowDto>> getAllMovieShows() {
        List<MovieShowDto> shows = movieShowService.getAllMovieShows();
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @GetMapping("/admin/get/movie/{id}")
    public ResponseEntity<MovieShowDto> getMovieShowById(@PathVariable Long id) {
        MovieShowDto dto = movieShowService.getMovieShowById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
