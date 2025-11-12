package dev.yeunikey.patterns.observer;

import dev.yeunikey.model.Order;

public interface OrderObserver {
    void update(Order order);
}