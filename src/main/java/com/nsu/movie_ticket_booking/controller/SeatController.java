package com.nsu.movie_ticket_booking.controller;

import com.nsu.movie_ticket_booking.dto.SeatDto;
import com.nsu.movie_ticket_booking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/user/get/seats/show/{showId}")
    public List<SeatDto> getSeatsByShow(@PathVariable Long showId) {
        return seatService.getAllSeatForMovieShow(showId);
    }
}
