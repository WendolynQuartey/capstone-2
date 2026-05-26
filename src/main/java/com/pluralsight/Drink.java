package com.pluralsight;

import com.pluralsight.enums.Size;

public class Drink extends OtherProduct{
    Size size;

    public Drink(double price, Size size) {
        super(price);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        if (this.size == Size.SMALL) {
            this.price = 2.00;
        } else if (this.size == Size.MEDIUM) {
            this.price = 2.50;
        } else if (this.size == Size.LARGE) {
            this.price = 3.00;
        }
        return this.price;
    }
}
