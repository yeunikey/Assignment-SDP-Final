package dev.yeunikey.model;

import dev.yeunikey.patterns.observer.OrderObserver;
import dev.yeunikey.patterns.observer.OrderSubject;
import dev.yeunikey.patterns.strategy.CashPaymentStrategy;
import dev.yeunikey.patterns.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderSubject {

    private final String customerName;
    private final List<MenuItem> items;
    private final double totalPrice;
    private PaymentStrategy paymentStrategy;

    private transient List<OrderObserver> observers = new ArrayList<>();
    private boolean isPaid = false;

    private Order(OrderBuilder builder) {
        this.customerName = builder.customerName;
        this.items = builder.items;
        this.paymentStrategy = builder.paymentStrategy;

        double sum = 0;
        for (MenuItem item : items) {
            sum += item.getPrice();
        }
        this.totalPrice = sum;
    }

    @Override
    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (isPaid) {
            for (OrderObserver observer : observers) {
                observer.update(this);
            }
        }
    }

    public void checkout() {
        System.out.println("Checking out order for: " + customerName);
        System.out.println("Total: $" + totalPrice);

        if (this.paymentStrategy == null) {
            System.out.println("No payment method selected.");
            return;
        }

        this.paymentStrategy.pay(totalPrice);
        this.isPaid = true;

        notifyObservers();
    }

    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }

    public void displayItemsForKitchen() {
        for (MenuItem item : items) {
            System.out.println("  * " + item.getName());
        }
    }

    public void displayOrder() {
        System.out.println("=================================");
        System.out.println("Order for: " + customerName);
        System.out.println("Items:");
        for (MenuItem item : items) {
            item.display();
        }
        System.out.println("---------------------------------");
        System.out.println("Total Price: $" + getTotalPrice());
    }

    public static class OrderBuilder {

        private String customerName;
        private List<MenuItem> items = new ArrayList<>();
        private PaymentStrategy paymentStrategy;
        private List<OrderObserver> observers = new ArrayList<>();

        public OrderBuilder setCustomer(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public OrderBuilder addItem(MenuItem item) {
            this.items.add(item);
            return this;
        }

        public OrderBuilder setPaymentMethod(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
            return this;
        }

        public OrderBuilder addObserver(OrderObserver observer) {
            this.observers.add(observer);
            return this;
        }

        public Order build() {
            
            if (customerName == null || items.isEmpty()) {
                throw new IllegalStateException("Customer name and items must be set");
            }
            if (paymentStrategy == null) {
                System.out.println("Warning: No payment method selected. Using default.");
                this.paymentStrategy = new CashPaymentStrategy();
            }

            Order order = new Order(this);

            for (OrderObserver obs : observers) {
                order.attach(obs);
            }

            return order;
        }
    }
}