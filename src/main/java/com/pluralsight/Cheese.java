package com.pluralsight;

import com.pluralsight.enums.Size;

public class Cheese  extends Ingredient{
    public Cheese(String name, boolean hasExtra, Size size, double price) {
        super(name, hasExtra, size, price);
    }

    @Override
    double getPrice() {
        if (this.size == Size.SMALL) {
            if (this.hasExtra) {
                return this.price += 1.05;
            }
            return this.price += .75;
        } else if (this.size == Size.MEDIUM) {
            if (this.hasExtra) {
                return this.price += 2.10;
            }
            return this.price += 1.50;
        } else if (this.size == Size.LARGE) {
            if (this.hasExtra) {
                return this.price += 3.15;
            }
            return this.price += 2.25;
        }

        return 0;
    }
}
