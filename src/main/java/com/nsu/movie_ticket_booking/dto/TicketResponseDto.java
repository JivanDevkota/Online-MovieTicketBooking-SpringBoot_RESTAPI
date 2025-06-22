package com.nsu.movie_ticket_booking.dto;

import com.nsu.movie_ticket_booking.enums.TicketStatus;
import lombok.Data;

@Data
public class TicketResponseDto {
    private Long id;
    private String seatNumber;
    private double price;
    private TicketStatus ticketStatus;
    private String movieName;
    private String showDate;
    private String startTime;
    private String theaterName;
    private String screenName;
}
