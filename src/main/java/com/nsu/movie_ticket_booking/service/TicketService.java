package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.dto.AdminTicketDto;
import com.nsu.movie_ticket_booking.dto.UserTicketDto;
import com.nsu.movie_ticket_booking.enums.TicketStatus;
import com.nsu.movie_ticket_booking.model.Ticket;

import java.util.List;

public interface TicketService {

    public void updateTicketStatus(Integer ticketId, TicketStatus ticketStatus);

    public List<AdminTicketDto> getAllTickets();

    public List<UserTicketDto> getTicketsByUserId(Long userId);
}
