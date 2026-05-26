package com.pluralsight;

import com.pluralsight.enums.Size;

public class Drink extends OtherProduct{
    static Size size;

    public Drink(double price, Size size) {
        super(price);
        this.size = size;
    }

    public static Size getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        if (size == Size.SMALL) {
            this.price = 2.00;
        } else if (size == Size.MEDIUM) {
            this.price = 2.50;
        } else if (size == Size.LARGE) {
            this.price = 3.00;
        }
        return this.price;
    }
}
