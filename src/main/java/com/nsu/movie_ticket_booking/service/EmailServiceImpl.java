package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
   private JavaMailSender mailSender;

    public void sendTicketConfirmationEmail(Ticket ticket) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(ticket.getBooking().getUser().getEmail());
        message.setSubject("Your Ticket is Confirmed!");
        message.setText("Hi " + ticket.getBooking().getUser().getUsername()
                + ",\n\nYour ticket for "
                + ticket.getMovieShow().getMovie().getMovieTitle()
                + " at " + ticket.getMovieShow().getStartTime()
                + " on " + ticket.getMovieShow().getShowDate()
                + " has been confirmed.\n\nSeat: " + ticket.getSeatNumber()
                + "\nPrice: Rs. " + ticket.getPrice()
                + "\n\nThank you!");
        mailSender.send(message);
    }
}
