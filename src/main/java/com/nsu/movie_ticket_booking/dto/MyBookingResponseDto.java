package com.nsu.movie_ticket_booking.dto;

import lombok.Data;

@Data
public class MyBookingResponseDto {

    private String bookingTime;
    private String totalPrice;

    private Long userId;
    private String userName;
}
