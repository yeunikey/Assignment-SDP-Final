package dev.yeunikey.model;

public class Pasta implements MenuItem {

    private String name;
    private double price;

    public Pasta(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void display() {
        System.out.println("  - Pasta: " + name + " ($" + price + ")");
    }

}