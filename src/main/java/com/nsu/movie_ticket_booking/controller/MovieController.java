package com.nsu.movie_ticket_booking.controller;

import com.nsu.movie_ticket_booking.dto.MovieDto;
import com.nsu.movie_ticket_booking.model.Movie;
import com.nsu.movie_ticket_booking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/admin/create-movie")
    public ResponseEntity<MovieDto> createMovie(
            @RequestParam("file") MultipartFile file,
            @RequestParam("movieTitle") String title,
            @RequestParam("movieDescription") String description,
            @RequestParam("length") int length,
            @RequestParam("languageId") Long languageId,
            @RequestParam("categoryId") Long categoryId) {

        MovieDto movieDto = new MovieDto();
        movieDto.setMovieTitle(title);
        movieDto.setMovieDescription(description);
        movieDto.setLength(length);
        movieDto.setLanguageId(languageId);
        movieDto.setCategoryId(categoryId);

        MovieDto created = movieService.createMovie(movieDto, file);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/admin/get/all-movies")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<MovieDto> allMovie = movieService.getAllMovie();
        return new ResponseEntity<>(allMovie, HttpStatus.OK);
    }

    @GetMapping("/admin/get/movie/{movieId}")
    private ResponseEntity<Movie> getMovie(@PathVariable Long movieId) {
        Movie movieById = movieService.getById(movieId);
        return new ResponseEntity<>(movieById,HttpStatus.OK);
    }


}
