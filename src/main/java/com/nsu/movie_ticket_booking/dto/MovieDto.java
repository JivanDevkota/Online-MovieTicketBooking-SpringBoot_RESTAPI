package com.nsu.movie_ticket_booking.dto;

import lombok.Data;

@Data
public class MovieDto {

    private Long id;
    private String movieTitle;
    private String movieDescription;
    private int length;
    private String posterPath;
    private Long languageId;
    private String languageName;
    private Long categoryId;
    private String categoryName;
}
