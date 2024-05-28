package org.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.HashSet;
import java.util.Set;

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
    @Column(name="genre")
    private String genre;
    @Column(name="rating")
    private double rating;
    @Column(name="votes")
    private int votes;
    @Column(name="price")
    private double price;
    @JsonManagedReference
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Subscription> subscriptions=new HashSet<>();

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", votes=" + votes +
                ", price=" + price +
                ", subscriptions=" + subscriptions +
                '}';
    }




    public void addSubscription(Subscription subscription){
        subscriptions.add(subscription);
        subscription.setMovie(this);
    }

    public void removeSubscription(Subscription subscription){
        subscriptions.remove(subscription);
        subscription.setMovie(null);
    }

    public void notifySubscribers(){
        for (Subscription subscription: subscriptions){
            ///javaMailSender
            subscription.update();
        }
    }
}
