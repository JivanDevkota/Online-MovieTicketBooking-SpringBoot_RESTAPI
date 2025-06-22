package com.nsu.movie_ticket_booking.helper;

import com.nsu.movie_ticket_booking.enums.SeatType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SeatPricing {

    public static final Map<SeatType, Double> seatPricing =Map.of(
            SeatType.VIP,20.0,
            SeatType.PREMIUM,15.0,
            SeatType.REGULAR,10.0
    );

    public double getPrice(SeatType seatType){
        return seatPricing.getOrDefault(seatType,10.0);
    }
}
