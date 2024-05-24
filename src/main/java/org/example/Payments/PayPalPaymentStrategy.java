package org.example.Payments;

public class PayPalPaymentStrategy implements PaymentStrategy{
    private final String email;
    private final String password;

    public PayPalPaymentStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {

        System.out.println("Paid "+amount+" using PayPal");
    }
}
