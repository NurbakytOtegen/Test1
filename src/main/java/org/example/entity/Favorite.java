package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="favorite")
public class Favorite {
@GeneratedValue
        @Id
        @Column(name = "id")
    private long id;
@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
@ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
