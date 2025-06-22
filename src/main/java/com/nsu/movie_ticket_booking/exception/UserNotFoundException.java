package com.nsu.movie_ticket_booking.exception;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserNotFoundException extends RuntimeException {
    private String message;

    public UserNotFoundException(){}

    public UserNotFoundException(String message){
        this.message = message;
    }
}
