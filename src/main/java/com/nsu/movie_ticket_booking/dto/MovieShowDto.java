package com.nsu.movie_ticket_booking.dto;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MovieShowDto {
    private Long id;

    private LocalDate showDate;
    private LocalTime startTime;

    private Long movieId;
    private String movieName;
    private String posterPath;
    private String movieDescription;
    private int length;
    private String actor;
    private String actress;
    private String director;

    private Long screenId;
    private String screenName;

    private String theaterName;
    private String  locationName;
    

}
