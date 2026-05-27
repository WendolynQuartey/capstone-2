package com.pluralsight;

import com.pluralsight.enums.Protein;
import com.pluralsight.enums.Size;

public class Meat{
    Protein meat;
    boolean hasExtra;
    Size size;


    public Meat(Protein meat, boolean hasExtra, Size size) {
        this.meat = meat;
        this.hasExtra = hasExtra;
        this.size = size;
    }


    double getPrice() {
        if (this.size == Size.SMALL) {
            if (this.hasExtra) {
                return 1.50;
            }
            return 1;
        } else if (this.size == Size.MEDIUM) {
            if (this.hasExtra) {
                return 3.00;
            }
            return 2.00;
        } else if (this.size == Size.LARGE) {
            if (this.hasExtra) {
                return 4.50;
            }
            return 3.00;
        }

        return 0;
    }
}
