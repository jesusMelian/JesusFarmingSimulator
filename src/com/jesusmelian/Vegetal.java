package com.jesusmelian;

public class Vegetal {
    private String name;
    private double price;

    public Vegetal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vegetal{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
