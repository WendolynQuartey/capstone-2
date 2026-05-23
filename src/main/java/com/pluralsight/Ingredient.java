package com.pluralsight;

abstract class Ingredient {
    private double price;
    private boolean hasExtra;

    public Ingredient(double price, boolean hasExtra) {
        this.price = price;
        this.hasExtra = hasExtra;
    }

    abstract void getPrice();
}
