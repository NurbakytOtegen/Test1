package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.FavoriteDTO;
import org.example.entity.Movie;
import org.example.service.FavoriteService;
import org.hibernate.annotations.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/favorites")
public class FavoriteController {
    private final FavoriteService favoriteService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovieToFavorite(@RequestParam Long userId, @RequestParam Long movieId){
        boolean added= favoriteService.addMovieToFavorite(userId,movieId);
        if(added){
            return new ResponseEntity<>("Movies added to favorites", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Movie already in favorites",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllFavorites(@RequestParam Long userId){
        List<Movie> favorites=favoriteService.getAllFavorites(userId);
        return new ResponseEntity<>(favorites,HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFromFavorites(@RequestParam Long userId,@RequestParam Long movieId){
        boolean removed= favoriteService.removeFromFavorites(userId,movieId);
        if(removed){
            return new ResponseEntity<>("Кино было удалено с избранного",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Кино не было найдено в избранном",HttpStatus.NOT_FOUND);
        }
    }
}
