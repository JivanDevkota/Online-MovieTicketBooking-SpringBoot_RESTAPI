package com.nsu.movie_ticket_booking.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDto {
    private Long userId;
    private Long showId;
    private List<String>seatNumbers;
}
