package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Payments.PaymentMethod;
import org.example.entity.ERole;
import org.example.entity.Subscription;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private String email;
    private ERole role;
    private double balance;
    private List<PaymentMethod> paymentMethod;
    private Set<Subscription> subscriptions;
}
