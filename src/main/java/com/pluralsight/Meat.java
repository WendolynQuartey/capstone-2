package com.pluralsight;

import com.pluralsight.enums.Size;

public class Meat extends Ingredient{
    public Meat(String name, boolean hasExtra, Size size, double price) {
        super(name, hasExtra, size, price);
    }

    @Override
    double getPrice() {
        if (this.size == Size.SMALL) {
            if (this.hasExtra) {
                return this.price += 1.50;
            }
            return this.price += 1;
        } else if (this.size == Size.MEDIUM) {
            if (this.hasExtra) {
                return this.price += 3.00;
            }
            return this.price += 2.00;
        } else if (this.size == Size.LARGE) {
            if (this.hasExtra) {
                return this.price += 4.50;
            }
            return this.price += 3.00;
        }

        return 0;
    }
}
