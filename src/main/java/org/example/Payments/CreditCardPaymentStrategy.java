package org.example.Payments;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    private final String cardNumber;
    private final String cvv;

    public CreditCardPaymentStrategy(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {

        System.out.println("Paid "+amount+ "using Credit Card");
    }
}
