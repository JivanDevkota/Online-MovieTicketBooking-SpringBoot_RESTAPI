package com.nsu.movie_ticket_booking.repository;

import com.nsu.movie_ticket_booking.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByMovieShowId(Long showId);

    List<Ticket> findByBookingUserId(Long userId);  // if Ticket → Booking → User

}
