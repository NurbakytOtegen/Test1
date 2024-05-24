package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.MovieDTO;
import org.example.entity.Movie;
import org.example.exception.ResourceNotFoundException;
import org.example.mapper.MovieMapper;
import org.example.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public interface MovieService {
    MovieDTO createMovie(MovieDTO movieDTO);
    MovieDTO getMovieById(Long movieId);
    List<MovieDTO> getAllMovies();
    void deleteMovie(Long movieId);
    MovieDTO updateMovie(Long movieId, MovieDTO updatedMovie);

    ///
    List<MovieDTO> getMovieByGenre(String genre);
    MovieDTO rateMovie(Long movie_id, double rating);
}
