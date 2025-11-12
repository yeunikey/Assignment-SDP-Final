package dev.yeunikey.patterns.decorator;

import dev.yeunikey.model.MenuItem;

public class Bacon extends MenuItemDecorator {

    public Bacon(MenuItem decoratedItem) {
        super(decoratedItem);
    }

    @Override
    public String getName() {
        return super.getName() + " + Bacon";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2.00;
    }

    @Override
    public void display() {
        System.out.println("  - " + getName() + " ($" + getPrice() + ")");
    }

}