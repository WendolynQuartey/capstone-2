package com.pluralsight;

abstract class Ingredient {
    double price;
    boolean hasExtra;
    Size size;

    public Ingredient(double price, boolean hasExtra, Size size) {
        this.price = price;
        this.hasExtra = hasExtra;
        this.size = size;
    }

    //region getters/setters
    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHasExtra() {
        return hasExtra;
    }

    public void setHasExtra(boolean hasExtra) {
        this.hasExtra = hasExtra;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    //endregion

    abstract double getPrice();
}
