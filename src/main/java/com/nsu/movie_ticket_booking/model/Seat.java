package com.nsu.movie_ticket_booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nsu.movie_ticket_booking.enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;  //regular, vip, etc

    @JsonProperty("isAvailable")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    @JsonBackReference
    private Screen screen;
}
