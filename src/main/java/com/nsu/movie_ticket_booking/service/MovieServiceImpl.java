package com.nsu.movie_ticket_booking.service;

import com.nsu.movie_ticket_booking.config.ImageHelper;
import com.nsu.movie_ticket_booking.dto.MovieDto;
import com.nsu.movie_ticket_booking.exception.MovieNotFoundException;
import com.nsu.movie_ticket_booking.model.Category;
import com.nsu.movie_ticket_booking.model.Language;
import com.nsu.movie_ticket_booking.model.Movie;
import com.nsu.movie_ticket_booking.repository.CategoryRepository;
import com.nsu.movie_ticket_booking.repository.LanguageRepository;
import com.nsu.movie_ticket_booking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private ImageHelper imageHelper;

    public MovieDto createMovie(MovieDto movieDto,MultipartFile file) {
        Category category = categoryRepository
                .findById(movieDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException(""));

        Language language = languageRepository
                .findById(movieDto.getLanguageId())
                .orElseThrow(()->new RuntimeException(""));

        String savePoster="";
        try{
            savePoster = imageHelper.saveImg(file);
        }catch (IOException ex){
            throw new RuntimeException("");
        }

        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setMovieTitle(movieDto.getMovieTitle());
        movie.setMovieDescription(movieDto.getMovieDescription());
        movie.setLength(movieDto.getLength());
        movie.setPosterPath(savePoster);
        movie.setLanguage(language);
        movie.setCategory(category);
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie.toMovieDto();
    }

    public List<MovieDto> getAllMovie(){
        List<Movie> movieList = movieRepository.findAll();
      return   movieList.stream()
                .map(Movie::toMovieDto)
                .collect(Collectors.toList());
    }

   public Movie getById(Long movieId){
      return movieRepository.findById(movieId).orElseThrow(()->new MovieNotFoundException("Movie not found"));
   }
}
