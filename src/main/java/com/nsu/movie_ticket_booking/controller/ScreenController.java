package com.nsu.movie_ticket_booking.controller;

import com.nsu.movie_ticket_booking.model.Screen;
import com.nsu.movie_ticket_booking.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    @GetMapping("/admin/get-all-screens")
    public ResponseEntity<List<?>>getAllScreens() {
        List<Screen> allMovieScreen = screenService.getAllMovieScreen();
        return new ResponseEntity<>(allMovieScreen, HttpStatus.OK);
    }
}
