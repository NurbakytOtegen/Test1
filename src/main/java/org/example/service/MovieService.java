package org.example.service;

import org.example.dto.MovieDTO;
import org.example.entity.Movie;
import org.example.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface MovieService {
    MovieDTO createMovie(MovieDTO movieDTO);
    MovieDTO getMovieById(Long movieId);
    List<MovieDTO> getAllMovies();
    void deleteMovie(Long movieId);
    MovieDTO updateMovie(Long movieId, MovieDTO updatedMovie);

//    private final MovieRepository movieRepository;
//    private List<Movie> movies=new ArrayList<>();
//
//    public MovieService(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }
//    public String addMovie(Movie movie){
//        if(!movie.getTitle().isBlank()){
//            movies.add(movie);
//            movieRepository.save(movie);
//            return "Added Movie";
//        }
//        else {
//            return "Not Added Movie";
//        }
//    }
//    public List<Movie> getAllMovies(){
//        return  movies;
//    }
//    public void deleteMovie(Movie movie){
//        movieRepository.delete(movie);
//    }
//    public List<Movie> getAllByTitle(String movie){
//        return movieRepository.getAllByTitle(movie);
//    }
}
