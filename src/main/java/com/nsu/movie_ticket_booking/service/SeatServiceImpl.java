package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.dto.SeatDto;
import com.nsu.movie_ticket_booking.model.MovieShow;
import java.util.List;
import java.util.stream.Collectors;

import com.nsu.movie_ticket_booking.model.Seat;
import com.nsu.movie_ticket_booking.model.Ticket;
import com.nsu.movie_ticket_booking.repository.MovieShowRepository;
import com.nsu.movie_ticket_booking.repository.SeatRepository;
import com.nsu.movie_ticket_booking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private MovieShowRepository movieShowRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<SeatDto> getAllSeatForMovieShow(Long showId) {
        MovieShow movieShow = movieShowRepository.findById(showId).orElseThrow();
        List<Seat> seats = seatRepository.findByScreenId(movieShow.getScreen().getId());

        List<String> bookedSeats = ticketRepository.findByMovieShowId(showId)
                .stream()
                .map(ticket -> ticket.getSeatNumber())
                .collect(Collectors.toList());

        return seats.stream().map(seat -> {
            SeatDto dto = new SeatDto();
            dto.setSeatId(seat.getSeatId());
            dto.setSeatNumber(seat.getSeatNumber());
            dto.setSeatType(seat.getSeatType());
            dto.setAvailable(!bookedSeats.contains(seat.getSeatNumber()));
            return dto;
        }).collect(Collectors.toList());
    }

//    @Override
//    public List<SeatDto> getAllSeatForMovieShow(Long movieShow) {
//
//        MovieShow show = movieShowRepository.findById(movieShow)
//                .orElseThrow(() -> new RuntimeException("MovieShow not found"));
//        Screen screen = show.getScreen();
//        List<Seat> seats = screen.getSeats();
//        return seats
//                .stream()
//                .map(seat -> new SeatDto(
//                       seat.getSeatId(),
//                        seat.getSeatNumber(),
//                        seat.getSeatType(),
//                        seat.isAvailable()
//                )).collect(Collectors.toList());
//    }
}
