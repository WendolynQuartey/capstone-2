package com.pluralsight;

import com.pluralsight.enums.Cheeses;
import com.pluralsight.enums.Size;

public class Cheese {
    Cheeses cheese;
    boolean hasExtra;
    Size size;

    public Cheese(Cheeses cheese, boolean hasExtra, Size size) {
        this.cheese = cheese;
    }

    double getPrice() {
        if (this.size == Size.SMALL) {
            if (this.hasExtra) {
                return 1.05;
            }
            return .75;
        } else if (this.size == Size.MEDIUM) {
            if (this.hasExtra) {
                return 2.10;
            }
            return 1.50;
        } else if (this.size == Size.LARGE) {
            if (this.hasExtra) {
                return 3.15;
            }
            return 2.25;
        }

        return 0;
    }
}
