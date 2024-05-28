package org.example.service.Impl;

import lombok.AllArgsConstructor;
import org.example.dto.MovieDTO;
import org.example.entity.Movie;
import org.example.exception.ResourceNotFoundException;
import org.example.mapper.MovieMapper;
import org.example.repository.MovieRepository;
import org.example.service.MovieService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
//    private final JavaMailSender javaMailSender;
    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        Movie movie= MovieMapper.mapToMovie(movieDTO);
        movie.setRating(0);
        movie.setVotes(0);
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
        System.out.println("Удалено!");
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

    @Override
    public List<MovieDTO> getMovieByGenre(String genre) {
        List<Movie> movies=movieRepository.findByGenre(genre);
        if(movies.isEmpty()){
            throw new ResourceNotFoundException("Нету фильмов в заданном жанре: "+genre);
        }

        return movies.stream()
                .map(MovieMapper::mapToMovieDto)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO rateMovie(Long movie_id, double rating) {
        Movie movie=movieRepository.findById(movie_id)
                .orElseThrow(()->new ResourceNotFoundException("Нету фильмо по данному id: "+movie_id));
        double currentRating=movie.getRating();
        int votes=movie.getVotes();

        double newRating=((currentRating*votes)+rating)/(votes+1);

        movie.setRating(newRating);
        movie.setVotes(votes+1);

        Movie updatedMovie=movieRepository.save(movie);

        movie.notifySubscribers();
        return MovieMapper.mapToMovieDto(updatedMovie);
    }
}
