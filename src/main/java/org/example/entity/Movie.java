package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="movies")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue
    @Column(name="id")
private long id;
    @Column(name = "title")
private String title;
    @Column(name="description")
    private String description;
    @Column(name="img")
    private String img;


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
