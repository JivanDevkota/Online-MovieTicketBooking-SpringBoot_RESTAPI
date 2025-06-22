package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.dto.SeatDto;

import java.util.List;

public interface SeatService {

    List<SeatDto>getAllSeatForMovieShow(Long movieShow);
}
