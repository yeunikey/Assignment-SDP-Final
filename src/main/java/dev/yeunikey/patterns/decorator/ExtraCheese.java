package dev.yeunikey.patterns.decorator;

import dev.yeunikey.model.MenuItem;

public class ExtraCheese extends MenuItemDecorator {

    public ExtraCheese(MenuItem decoratedItem) {
        super(decoratedItem);
    }

    @Override
    public String getName() {
        return super.getName() + " + Extra Cheese";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1.50;
    }

    @Override
    public void display() {
        System.out.println("  - " + getName() + " ($" + getPrice() + ")");
    }

}