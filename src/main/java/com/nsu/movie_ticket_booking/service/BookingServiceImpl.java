package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.dto.BookingRequestDto;
import com.nsu.movie_ticket_booking.dto.BookingResponseDto;
import com.nsu.movie_ticket_booking.dto.MyBookingResponseDto;
import com.nsu.movie_ticket_booking.enums.SeatType;
import com.nsu.movie_ticket_booking.enums.TicketStatus;
import com.nsu.movie_ticket_booking.helper.SeatPricing;
import com.nsu.movie_ticket_booking.model.*;
import com.nsu.movie_ticket_booking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieShowRepository movieShowRepository;


    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SeatPricing seatPricing;

    @Override
    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto) {
        User user = userRepository.findById(bookingRequestDto.getUserId())
                .orElseThrow();

        MovieShow movieShow=movieShowRepository.findById(bookingRequestDto.getShowId())
                .orElseThrow();

        Booking booking=new Booking();
        booking.setBookingTime(LocalDateTime.now());
        booking.setUser(user);

        List<Ticket>ticketList=new ArrayList<>();
//        double total=0;

        for (String seatNumber:bookingRequestDto.getSeatNumbers()){
            Seat seat=seatRepository.findBySeatNumberAndScreenId(
                    seatNumber,movieShow.getScreen().getId()
            ).orElseThrow(()->new RuntimeException(""));

            Ticket ticket=new Ticket();
            ticket.setSeatNumber(seatNumber);
            ticket.setPrice(seatPricing.getPrice(seat.getSeatType()));
            ticket.setBooking(booking);
            ticket.setMovieShow(movieShow);
            ticket.setTicketStatus(TicketStatus.PENDING);

            ticketList.add(ticket);
//            total+=ticket.getPrice();
        }

        booking.setTotalPrice(ticketList.stream().mapToDouble(Ticket::getPrice).sum());
        booking.setTickets(ticketList);
        Booking save = bookingRepository.save(booking);

        return save.toDto(save);
    }

//    public List<MyBookingResponseDto>getAllBookingByUserId(Long userId){
//
//    }
}
