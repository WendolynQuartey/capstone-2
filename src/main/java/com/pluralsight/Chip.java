package com.pluralsight;

public class Chip extends OtherProduct{
    public Chip(double price) {
        super(price);
    }

    @Override
    public double getPrice() {
        this.price = 1.5;
        return this.price;
    }
}
