package org.example.Payments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodDto {
    private long id;
    private String type;
    private String cardNumber;
    private String cvv;
    private String paypalEmail;
    private String paypalPassword;
}
