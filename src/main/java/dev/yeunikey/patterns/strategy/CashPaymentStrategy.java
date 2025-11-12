package dev.yeunikey.patterns.strategy;

public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("---------------------------------");
        System.out.println("Processing cash payment...");
        System.out.println("Please pay $" + amount + " to the courier upon delivery.");
        System.out.println("Payment will be collected at the door.");
    }

}