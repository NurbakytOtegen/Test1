package org.example.mapper;

import org.example.dto.MovieDTO;
import org.example.entity.Movie;

public class MovieMapper {
    public static MovieDTO mapToMovieDto(Movie movie) {
        return new MovieDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getImg()
        );
    };

    public static Movie mapToMovie(MovieDTO movieDTO){
        return new Movie(
                movieDTO.getId(),
                movieDTO.getTitle(),
                movieDTO.getDescription(),
                movieDTO.getImg()
        );
    }
}

