package com.nsu.movie_ticket_booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminTicketDto {
    private Long ticketId;
    private String movieName;
    private String userName;
    private String email;
    private String seatNumber;
    private double price;
    private LocalDate showDate;
    private LocalTime startTime;
    private String ticketStatus;
}
