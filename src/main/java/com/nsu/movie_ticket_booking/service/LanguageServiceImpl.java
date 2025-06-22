package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.model.Language;
import com.nsu.movie_ticket_booking.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }
}
