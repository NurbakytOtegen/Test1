package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.FavoriteDTO;
import org.example.entity.Favorite;
import org.example.entity.Movie;
import org.example.repository.FavoriteRepository;
import org.example.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private MovieRepository movieRepository;

    //Добавить кино в избранные
    public boolean addMovieToFavorite(Long userId, Long movieId){
        if(favoriteRepository.existsByUserIdAndMovieId(userId,movieId)){
            return false;
        }
        Favorite favorite=new Favorite();
        favorite.setUserId(userId);
        favorite.setMovieId(movieId);
        favoriteRepository.save(favorite);

        return true;
    }

    public List<Movie> getAllFavorites(Long userId){
        List<Favorite> favorites=favoriteRepository.findByUserId(userId);
        List<Long> moviesIds=favorites.stream().map(Favorite::getMovieId).collect(Collectors.toList());

        return movieRepository.findAllById(moviesIds);
    }

    public boolean removeFromFavorites(Long userId, Long movieId){

        favoriteRepository.deleteByUserIdAndMovieId(userId,movieId);
        return true;
    }
}
