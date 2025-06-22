package com.nsu.movie_ticket_booking.exception;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieNotFoundException extends RuntimeException {

    private String message;

    public MovieNotFoundException(){}

    public MovieNotFoundException(String message){
        super();
        this.message = message;
    }
}
