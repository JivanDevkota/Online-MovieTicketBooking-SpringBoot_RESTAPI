package com.nsu.movie_ticket_booking.model;

import com.nsu.movie_ticket_booking.dto.BookingResponseDto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime bookingTime;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    private List<Ticket>tickets=new ArrayList<>();


    public  BookingResponseDto toDto(Booking booking){
        BookingResponseDto dto = new BookingResponseDto();
        dto.setBookingId(booking.getId());
        dto.setBookingTime(booking.getBookingTime());
        dto.setTotalPrice(booking.getTotalPrice());

        if (!booking.getTickets().isEmpty()){
            MovieShow movieShow = booking.getTickets().get(0).getMovieShow();
            dto.setMovieTitle(movieShow.getMovie().getMovieTitle());
            dto.setShowDate(movieShow.getShowDate().toString());
            dto.setShowTime(movieShow.getStartTime().toString());
        }
        List<String> seatNumbers = booking.getTickets().stream()
                .map(Ticket::getSeatNumber)
                .collect(Collectors.toList());
        dto.setSeatNumbers(seatNumbers);

        return dto;
    }


}
