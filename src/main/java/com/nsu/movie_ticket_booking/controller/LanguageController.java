package com.nsu.movie_ticket_booking.controller;

import com.nsu.movie_ticket_booking.model.Language;
import com.nsu.movie_ticket_booking.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/admin/get-all/languages")
    public ResponseEntity<?>getAllLanguage(){
        List<Language> languages = languageService.getAllLanguages();
        return ResponseEntity.ok(languages);
    }
}
