package com.nsu.movie_ticket_booking.repository;

import com.nsu.movie_ticket_booking.dto.MovieShowDto;
import com.nsu.movie_ticket_booking.model.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {

    List<MovieShow>findByMovie_MovieTitleContainingIgnoreCase(String keyword);

    List<MovieShow>findByShowDate(LocalDate showDate);
    List<MovieShow>findByShowDateAfter(LocalDate showDate );
}
