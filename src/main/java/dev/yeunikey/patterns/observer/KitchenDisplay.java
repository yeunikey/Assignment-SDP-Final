package dev.yeunikey.patterns.observer;

import dev.yeunikey.model.Order;

public class KitchenDisplay implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("=================================");
        System.out.println(" KITCHEN NOTIFICATION ");
        System.out.println("New order received (ID: " + order.hashCode() + ")");
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Items to prepare:");
        order.displayItemsForKitchen();
        System.out.println("=================================");
    }

}