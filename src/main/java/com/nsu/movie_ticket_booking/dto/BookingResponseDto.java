package com.nsu.movie_ticket_booking.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingResponseDto {
    private Long bookingId;
    private LocalDateTime bookingTime;
    private Double totalPrice;
    private String movieTitle;
    private String  showDate;
    private String showTime;
    private String actor;
    private String actress;
    private String director;
    private List<String>seatNumbers;

}
