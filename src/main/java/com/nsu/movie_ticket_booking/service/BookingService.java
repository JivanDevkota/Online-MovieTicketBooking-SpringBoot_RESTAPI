package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.dto.BookingRequestDto;
import com.nsu.movie_ticket_booking.dto.BookingResponseDto;

public interface BookingService {

    BookingResponseDto createBooking(BookingRequestDto bookingRequestDto);

}
