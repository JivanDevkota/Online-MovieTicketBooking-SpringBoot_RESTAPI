package com.nsu.movie_ticket_booking.repository;

import com.nsu.movie_ticket_booking.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
