package com.pluralsight;

abstract class Ingredient{
    boolean hasExtra;
    Size size;
    double price;

    public Ingredient(boolean hasExtra, Size size, double price) {
        this.hasExtra = hasExtra;
        this.size = size;
        this.price = price;
    }

    //region getters/setters

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

    abstract double getPrice();


    public void setPrice(double price) {
        this.price = price;
    }

    //endregion

}
