package com.pluralsight;

import com.pluralsight.enums.*;

public class BLT extends Sandwich {
    public BLT() {
        super(Size.MEDIUM, BreadType.WHITE, true);
        Meat bltMeat = new Meat(Protein.BACON, false, Size.MEDIUM);
        Cheese bltCheese = new Cheese(Cheeses.CHEDDAR, false, Size.MEDIUM);
        this.addToppings(RegTopping.LETTUCE);
        this.addToppings(RegTopping.TOMATOES);
        this.addToppings(Sauce.RANCH);
        this.addMeat(bltMeat);
        this.addCheese(bltCheese);
    }
}
