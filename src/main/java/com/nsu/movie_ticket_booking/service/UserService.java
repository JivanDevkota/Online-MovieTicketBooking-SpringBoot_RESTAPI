package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.dto.AuthenticationRequest;

public interface UserService {
    String login(AuthenticationRequest request);
}
