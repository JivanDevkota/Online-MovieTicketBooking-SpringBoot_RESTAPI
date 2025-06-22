package com.nsu.movie_ticket_booking.controller;

import com.nsu.movie_ticket_booking.dto.BookingRequestDto;
import com.nsu.movie_ticket_booking.dto.BookingResponseDto;
import com.nsu.movie_ticket_booking.dto.MovieShowDto;
import com.nsu.movie_ticket_booking.service.BookingService;
import com.nsu.movie_ticket_booking.service.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private MovieShowService movieShowService;

    @PostMapping("/user/create-booking")
    public ResponseEntity<BookingResponseDto> addBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        BookingResponseDto booking = bookingService.createBooking(bookingRequestDto);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @GetMapping("/user/get/movie/{id}")
    public ResponseEntity<MovieShowDto> getMovieShowByIdUser(@PathVariable Long id) {
        MovieShowDto dto = movieShowService.getMovieShowById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
