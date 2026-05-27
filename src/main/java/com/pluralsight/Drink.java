package com.pluralsight;

import com.pluralsight.enums.Size;

public class Drink{
    Size size;

    public Drink(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        if (size == Size.SMALL) {
            return 2.00;
        } else if (size == Size.MEDIUM) {
            return 2.50;
        } else if (size == Size.LARGE) {
            return 3.00;
        }
        return 0;
    }
}
