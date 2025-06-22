package com.nsu.movie_ticket_booking.dto;

import com.nsu.movie_ticket_booking.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDto {
    private Long seatId;
    private String seatNumber;
    private SeatType seatType;
    private boolean isAvailable;
    private int price;
}
