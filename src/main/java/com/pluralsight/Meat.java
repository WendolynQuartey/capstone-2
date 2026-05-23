package com.pluralsight;

public class Meat extends Ingredient{
    public Meat(Size size, String breadType, boolean isToasted, double price, boolean hasExtra) {
        super(size, breadType, isToasted, price, hasExtra);
    }

    @Override
    public double getPrice() {
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
