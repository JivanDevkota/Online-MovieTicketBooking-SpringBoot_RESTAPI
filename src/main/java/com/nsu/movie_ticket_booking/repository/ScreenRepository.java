package com.nsu.movie_ticket_booking.repository;

import com.nsu.movie_ticket_booking.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
