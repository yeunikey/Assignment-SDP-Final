package dev.yeunikey.patterns.facade;

import dev.yeunikey.model.MenuItem;
import dev.yeunikey.model.Order;
import dev.yeunikey.patterns.decorator.Bacon;
import dev.yeunikey.patterns.decorator.ExtraCheese;
import dev.yeunikey.patterns.factory.MenuItemFactory;
import dev.yeunikey.patterns.observer.KitchenDisplay;
import dev.yeunikey.patterns.observer.OrderObserver;
import dev.yeunikey.patterns.strategy.PaymentStrategy;

import java.util.Map;

public class RestaurantFacade {

    private MenuItemFactory itemFactory;
    private OrderObserver kitchen;

    public RestaurantFacade() {
        this.itemFactory = new MenuItemFactory();
        this.kitchen = new KitchenDisplay();
    }

    public Order placeOrder(String customerName, Map<String, String> itemsToOrder, PaymentStrategy paymentStrategy) {

        System.out.println("--- Facade: Placing order for " + customerName + " ---");

        Order.OrderBuilder builder = new Order.OrderBuilder()
                .setCustomer(customerName)
                .setPaymentMethod(paymentStrategy)
                .addObserver(this.kitchen);

        for (Map.Entry<String, String> entry : itemsToOrder.entrySet()) {
            String itemType = entry.getKey();
            String itemName = entry.getValue();

            MenuItem item;

            if ("pizza".equals(itemType)) {
                item = itemFactory.createMenuItem("pizza", itemName, 12.0); // Базовая цена
            } else if ("pasta".equals(itemType)) {
                item = itemFactory.createMenuItem("pasta", itemName, 10.0);
            } else {
                continue;
            }

            if ("Pepperoni".equals(itemName)) {
                item = new ExtraCheese(item);
            }
            if ("Carbonara".equals(itemName)) {
                item = new Bacon(item);
            }

            builder.addItem(item);
        }

        Order order = builder.build();
        order.displayOrder();
        order.checkout();

        System.out.println("--- Facade: Order processed ---");
        return order;
    }

}