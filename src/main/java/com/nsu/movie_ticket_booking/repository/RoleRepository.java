package com.nsu.movie_ticket_booking.repository;

import com.nsu.movie_ticket_booking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role>findByRoleName(String roleName);
}
