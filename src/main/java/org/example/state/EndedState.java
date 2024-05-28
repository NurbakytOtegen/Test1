package org.example.state;

import org.example.entity.Subscription;

public class EndedState implements SubscriptionState{
    @Override
    public void next(Subscription subscription) {
        subscription.setState(new ActiveState());
    }

    @Override
    public void prev(Subscription subscription) {
        subscription.setState(new PausedState());
    }

    @Override
    public String getState() {
        return "Ended";
    }
}
