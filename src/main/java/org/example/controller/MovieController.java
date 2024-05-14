package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.dto.MovieDTO;
import org.example.entity.Movie;
import org.example.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/movies")
@Tag(name="Auth")
public class MovieController {
    private final MovieService movieService;

    //Build Add Movie REST API
    @PostMapping("")
    @Operation(summary = "Доступен авторизованным пользователям")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO){
        MovieDTO savedMovie=movieService.createMovie(movieDTO);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }
    //Build Movie By ID REST API
    @GetMapping("movie_id={id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable("id") Long movieId){
        MovieDTO movieDTO=movieService.getMovieById(movieId);
        return ResponseEntity.ok(movieDTO);
    }
    //Build Get All Movies REST API
    @GetMapping("")
    public ResponseEntity<List<MovieDTO>> getAllMovies(){
        List<MovieDTO> movies=movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    //Build Update Movie REST API
    @PutMapping("{id}")
    public ResponseEntity<MovieDTO> updateMovie(
            @PathVariable("id") Long movieId,
            @RequestBody MovieDTO updatedMovie){

        MovieDTO movieDTO=movieService.updateMovie(movieId,updatedMovie);
        return ResponseEntity.ok(movieDTO);
    }
    //Build Delete Movie REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long movieId){
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok("Movie deleted successfully!");
    }
}
