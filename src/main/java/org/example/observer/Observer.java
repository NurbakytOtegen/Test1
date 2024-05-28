package org.example.observer;

public interface Observer {
    void update(Long movieId, double newRating);
}
