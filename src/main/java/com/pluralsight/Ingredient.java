package com.pluralsight;

import com.pluralsight.enums.Size;

abstract class Ingredient {
    String name;
    boolean hasExtra;
    Size size;
    double price;

    public Ingredient(String name, boolean hasExtra, Size size, double price) {
        this.name = name;
        this.hasExtra = hasExtra;
        this.size = size;
        this.price = price;
    }

    //region getters/setters
    public String getName() {
        return name;
    }

    public boolean isHasExtra() {
        return hasExtra;
    }

    public Size getSize() {
        return size;
    }


    abstract double getPrice();


    public void setPrice(double price) {
        this.price = price;
    }

    //endregion

}
