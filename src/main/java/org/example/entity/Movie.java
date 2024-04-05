package org.example.entity;

import jakarta.persistence.*;

@Table(name="galaxy_movie")
@Entity
public class Movie {
    @Id
    @GeneratedValue
    @Column(name="id")
private long id;
    @Column(name = "title")
private String title;

    public Movie() {}
    public Movie(int id,String title){
        this.id=id;
        this.title=title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
