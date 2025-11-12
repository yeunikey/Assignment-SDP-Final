package dev.yeunikey.patterns.decorator;

import dev.yeunikey.model.MenuItem;

public abstract class MenuItemDecorator implements MenuItem {

    protected MenuItem decoratedItem;

    public MenuItemDecorator(MenuItem decoratedItem) {
        this.decoratedItem = decoratedItem;
    }

    @Override
    public String getName() {
        return decoratedItem.getName();
    }

    @Override
    public double getPrice() {
        return decoratedItem.getPrice();
    }

    @Override
    public void display() {
        decoratedItem.display();
    }

}