package org.example.Payments;

import org.example.exception.ResourceNotFoundException;

public class PaymentStrategyFactory {
    public static PaymentStrategy getPaymentStrategy(PaymentMethodDto paymentMethodDto){
        if("creditCard".equalsIgnoreCase(paymentMethodDto.getType())){
            return new CreditCardPaymentStrategy(paymentMethodDto.getCardNumber(),paymentMethodDto.getCvv());
        } else if ("paypal".equalsIgnoreCase(paymentMethodDto.getType())) {
            return new PayPalPaymentStrategy(paymentMethodDto.getPaypalEmail(),paymentMethodDto.getPaypalPassword());
        }
        throw new IllegalArgumentException("Invalid payment method type");

    }
}
