package com.nsu.movie_ticket_booking.repository;

import com.nsu.movie_ticket_booking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

//    Optional<User> findByRoleName(String roleName);
@Query("SELECT u FROM User u JOIN u.roles r WHERE r.roleName = :roleName")
Optional<User> findByRoleName(@Param("roleName") String roleName);
}
