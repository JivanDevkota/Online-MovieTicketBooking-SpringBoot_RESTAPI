package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.model.Screen;
import com.nsu.movie_ticket_booking.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenServiceImpl implements ScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    @Override
    public List<Screen> getAllMovieScreen() {
        return screenRepository.findAll();
    }
}
