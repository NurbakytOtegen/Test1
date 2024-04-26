package org.example.service.Impl;

import lombok.AllArgsConstructor;
import org.example.dto.MovieDTO;
import org.example.entity.Movie;
import org.example.exception.ResourceNotFoundException;
import org.example.mapper.MovieMapper;
import org.example.repository.MovieRepository;
import org.example.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;
    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        Movie movie= MovieMapper.mapToMovie(movieDTO);
        Movie savedMovie=movieRepository.save(movie);
        return MovieMapper.mapToMovieDto(savedMovie);
    }

    @Override
    public MovieDTO getMovieById(Long movieId) {
        Movie movie= movieRepository.findById(movieId)
                .orElseThrow(()->new ResourceNotFoundException("Movie is not exists with given id"+movieId));
        return MovieMapper.mapToMovieDto(movie);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies= movieRepository.findAll();
        return movies.stream().map((movie) ->MovieMapper.mapToMovieDto(movie))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMovie(Long movieId) {
        Movie movie=movieRepository.findById(movieId).orElseThrow(()->new ResourceNotFoundException("Movie is now exist by this id "+movieId));
        movieRepository.deleteById(movieId);
    }

    @Override
    public MovieDTO updateMovie(Long movieId, MovieDTO updatedMovie) {
        Movie movie=movieRepository.findById(movieId).orElseThrow(()->new ResourceNotFoundException("Movie is now exist by this id "+movieId));
        movie.setTitle(updatedMovie.getTitle());
        movie.setDescription(updatedMovie.getDescription());
        movie.setImg(updatedMovie.getImg());
        Movie updatedMovieObj=movieRepository.save(movie);
        return MovieMapper.mapToMovieDto(updatedMovieObj);
    }
}
