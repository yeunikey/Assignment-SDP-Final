package dev.yeunikey.patterns.strategy;

public class CardPaymentStrategy implements PaymentStrategy {

    private String cardNumber;

    public CardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("---------------------------------");
        System.out.println("Processing card payment...");
        System.out.println("Paid $" + amount + " using card ending in " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Payment successful.");
    }

}