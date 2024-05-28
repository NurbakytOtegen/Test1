package org.example.mapper;

import org.example.dto.SubscriptionDto;
import org.example.entity.Subscription;

public class SubscriptionMapper {
    public static SubscriptionDto mapToSubscriptionDto(Subscription subscription){
        return new SubscriptionDto(
                subscription.getId(),
                subscription.getMovie(),
                subscription.getUser(),
                subscription.getState()
        );
    }

    public static Subscription mapToSubscription(SubscriptionDto subscriptionDto){
        return new Subscription(
                subscriptionDto.getId(),
                subscriptionDto.getMovie(),
                subscriptionDto.getUser(),
                subscriptionDto.getState()
        );
    }
}
