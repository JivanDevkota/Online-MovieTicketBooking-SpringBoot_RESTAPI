package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.model.Ticket;

public interface EmailService {
    void sendTicketConfirmationEmail(Ticket ticket);
}
