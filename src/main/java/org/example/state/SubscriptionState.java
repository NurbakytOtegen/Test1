package org.example.state;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.example.entity.Subscription;

public interface SubscriptionState {

    void next(Subscription subscription);
    void prev(Subscription subscription);
    String getState();
}
