package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.example.state.ActiveState;
import org.example.state.EndedState;
import org.example.state.SubscriptionState;
import org.springframework.boot.autoconfigure.task.TaskSchedulingProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Subs")
public class Subscription {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "movieId")
    private Movie movie;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private User user;


    @Column(name = "state")
    @Transient
    private SubscriptionState state;
//    private String state;


//@PostLoad
//    @PostPersist
//    public void initializeState(){
//    if(state==null){
//        setState(new ActiveState());
//    }
//}

    @PostLoad
    @PostPersist
    public void initializeState(){
        if(state==null){
            state=new ActiveState();
        }
    }

    public void update(){
        if("Active".equals(state.getState())){
            //javaMailSender
            user.createObserver().update(movie.getId(), movie.getRating());
        }
    }


    public void nextState(){state.next(this);}

    public void prevState(){state.prev(this);}

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", movie=" + movie +
                ", user=" + user +
                ", state=" + state +
                '}';
    }
}
