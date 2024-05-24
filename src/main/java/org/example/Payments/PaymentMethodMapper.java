package org.example.Payments;

public class PaymentMethodMapper {
    public static PaymentMethodDto mapToPaymentMethodDto(PaymentMethod paymentMethod){
        return new PaymentMethodDto(
                paymentMethod.getId(),
                paymentMethod.getType(),
                paymentMethod.getCardNumber(),
                paymentMethod.getCvv(),
                paymentMethod.getPaypalEmail(),
                paymentMethod.getPaypalPassword()
        );
    }

    public static PaymentMethod mapToPaymentMethod(PaymentMethodDto paymentMethodDto){
        return new PaymentMethod(
                paymentMethodDto.getId(),
                paymentMethodDto.getType(),
                paymentMethodDto.getCardNumber(),
                paymentMethodDto.getCvv(),
                paymentMethodDto.getPaypalEmail(),
                paymentMethodDto.getPaypalPassword()
        );
    }
}
