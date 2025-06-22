package com.nsu.movie_ticket_booking.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class UserTicketDto {
    private Long ticketId;
    private String seatNumber;
    private double price;
    private String movieName;
    private String posterPath;
    private LocalDate showDate;
    private LocalTime startTime;
    private String screenName;
    private String ticketStatus;
}
