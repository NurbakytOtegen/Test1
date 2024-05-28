package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.Subscription;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private long id;
    private String title;
    private String description;
    private String img;
    private String genre;
    private double rating;
    private int votes;
    private double price;
    private Set<Subscription> subscriptions;

}
