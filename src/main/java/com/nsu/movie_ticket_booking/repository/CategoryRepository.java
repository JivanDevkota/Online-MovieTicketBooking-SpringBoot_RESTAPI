package com.nsu.movie_ticket_booking.repository;

import com.nsu.movie_ticket_booking.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
