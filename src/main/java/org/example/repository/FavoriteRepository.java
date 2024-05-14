package org.example.repository;

import org.example.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
    boolean existsByUserIdAndMovieId(Long userId, Long movieId);
    List<Favorite> findByUserId(Long userId);
    void deleteByUserIdAndMovieId(Long userId, Long movieId);
}
