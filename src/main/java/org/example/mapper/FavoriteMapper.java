package org.example.mapper;

import org.example.dto.FavoriteDTO;
import org.example.dto.MovieDTO;
import org.example.entity.Favorite;
import org.example.entity.Movie;

public class FavoriteMapper {
    public static FavoriteDTO mapToFavoriteDto(Favorite favorite) {
        return new FavoriteDTO(
                favorite.getId(),
                favorite.getUserId(),
                favorite.getMovieId()
        );
    };

    public static Favorite mapToFavorite(FavoriteDTO favoriteDTO){
        return new Favorite(
                favoriteDTO.getId(),
                favoriteDTO.getUserId(),
                favoriteDTO.getMovieId()
        );
    }
}
