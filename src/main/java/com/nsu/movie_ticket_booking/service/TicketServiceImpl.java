package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.dto.AdminTicketDto;
import com.nsu.movie_ticket_booking.dto.UserTicketDto;
import com.nsu.movie_ticket_booking.enums.TicketStatus;
import com.nsu.movie_ticket_booking.model.*;
import com.nsu.movie_ticket_booking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EmailService emailService;

    public void updateTicketStatus(Integer ticketId, TicketStatus ticketStatus) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket Not Found"));
        ticket.setTicketStatus(ticketStatus);
        ticketRepository.save(ticket);

        if (ticketStatus == TicketStatus.CONFIRMED) {
            emailService.sendTicketConfirmationEmail(ticket);
        }
    }

//    @Override
//    public List<Ticket> getAllTickets() {
//        return ticketRepository.findAll();
//    }


    @Override
    public List<AdminTicketDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(ticket -> {
            Booking booking = ticket.getBooking();
            User user = booking.getUser();
            MovieShow show = ticket.getMovieShow();
            Movie movie = show.getMovie();

            return new AdminTicketDto(
                    ticket.getId(),
                    movie.getMovieTitle(),
                    user.getUsername(),
                    user.getEmail(),
                    ticket.getSeatNumber(),
                    ticket.getPrice(),
                    show.getShowDate(),
                    show.getStartTime(),
                    ticket.getTicketStatus().name()
            );
        }).collect(Collectors.toList());
    }

    @Override
    public List<UserTicketDto> getTicketsByUserId(Long userId) {

        List<Ticket> tickets = ticketRepository.findByBookingUserId(userId);

        return tickets.stream().map(ticket -> {
            MovieShow movieShow = ticket.getMovieShow();
            Movie movie = movieShow.getMovie();
            Screen screen = movieShow.getScreen();

            UserTicketDto dto = new UserTicketDto();
            dto.setTicketId(ticket.getId());
            dto.setSeatNumber(ticket.getSeatNumber());
            dto.setPrice(ticket.getPrice());
            dto.setTicketStatus(ticket.getTicketStatus().name());

            dto.setMovieName(movie.getMovieTitle());
            dto.setPosterPath(movie.getPosterPath());
            dto.setShowDate(movieShow.getShowDate());
            dto.setStartTime(movieShow.getStartTime());
            dto.setScreenName(screen.getName());
            return  dto;
        }).collect(Collectors.toList());
    }

}
