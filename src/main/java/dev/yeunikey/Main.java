package dev.yeunikey;

import dev.yeunikey.patterns.facade.RestaurantFacade;
import dev.yeunikey.patterns.strategy.CardPaymentStrategy;
import dev.yeunikey.patterns.strategy.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Restaurant System Starting via FACADE ===");

        // 1. Клиент создает только Фасад
        RestaurantFacade restaurant = new RestaurantFacade();

        // 2. Клиент готовит свой "запрос"
        // (Что заказать)
        Map<String, String> orderItems = new HashMap<>();
        orderItems.put("pizza", "Pepperoni");
        orderItems.put("pasta", "Carbonara");

        // (Как оплатить)
        PaymentStrategy payment = new CardPaymentStrategy("1234-5678-8765-4321");

        // 3. Клиент делает ОДИН вызов
        restaurant.placeOrder("Askar", orderItems, payment);

        System.out.println("=== Restaurant System Shutdown ===");
    }

}