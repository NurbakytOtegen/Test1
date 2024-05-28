package org.example.state;

import jakarta.persistence.Entity;
import org.example.entity.Subscription;

public class ActiveState implements SubscriptionState{

    @Override
    public void next(Subscription subscription) {
        subscription.setState(new PausedState());
    }

    @Override
    public void prev(Subscription subscription) {
        subscription.setState(new EndedState());
    }

    @Override
    public String getState() {
        return "Active";
    }
}
