package org.example.state;

import org.example.entity.Subscription;

public class PausedState implements SubscriptionState{
    @Override
    public void next(Subscription subscription) {
        subscription.setState(new EndedState());
    }

    @Override
    public void prev(Subscription subscription) {
        subscription.setState(new ActiveState());
    }

    @Override
    public String getState() {
        return "Paused";
    }
}
