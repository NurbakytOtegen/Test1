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

    @Column(name = "userId")
    private long userId;

    @Column(name = "movieId")
    private long movieId;
}
