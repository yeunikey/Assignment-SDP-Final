package dev.yeunikey.patterns.factory;

import dev.yeunikey.model.MenuItem;
import dev.yeunikey.model.Pasta;
import dev.yeunikey.model.Pizza;

public class MenuItemFactory {

    public MenuItem createMenuItem(String itemType, String name, double price) {
        if ("pizza".equalsIgnoreCase(itemType)) {
            return new Pizza(name, price);
        } else if ("pasta".equalsIgnoreCase(itemType)) {
            return new Pasta(name, price);
        }
        throw new IllegalArgumentException("Unknown menu item type: " + itemType);
    }

}