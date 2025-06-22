package com.nsu.movie_ticket_booking.repository;

import com.nsu.movie_ticket_booking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    Optional<Seat> findBySeatNumberAndScreenId(String seatNumber, Long screenId);

    List<Seat> findByScreenId(Long id);
}
