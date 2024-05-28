package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.Movie;
import org.example.entity.User;
import org.example.state.SubscriptionState;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
    private long id;
    private Movie movie;
    private User user;
    private SubscriptionState state;
}
