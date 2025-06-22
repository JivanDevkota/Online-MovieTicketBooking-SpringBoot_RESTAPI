package com.nsu.movie_ticket_booking.controller;

import com.nsu.movie_ticket_booking.dto.AdminTicketDto;
import com.nsu.movie_ticket_booking.dto.UserTicketDto;
import com.nsu.movie_ticket_booking.enums.TicketStatus;
import com.nsu.movie_ticket_booking.model.Ticket;
import com.nsu.movie_ticket_booking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PutMapping("/admin/confirm/ticket/{ticketId}/status")
    public ResponseEntity<String> updateStatus(
            @PathVariable Integer ticketId,
            @RequestParam TicketStatus status
    ) {
        ticketService.updateTicketStatus(ticketId, status);
        return ResponseEntity.ok("Ticket status updated to: " + status);
    }

    @GetMapping("/admin/get-all/tickets")
    public ResponseEntity<List<AdminTicketDto>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }


    @GetMapping("/user/tickets/{userId}")
    public ResponseEntity<List<UserTicketDto>> getTicketsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(ticketService.getTicketsByUserId(userId));
    }

}
