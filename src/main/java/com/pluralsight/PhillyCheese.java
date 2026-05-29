package com.pluralsight;

import com.pluralsight.enums.*;

public class PhillyCheese extends Sandwich {
    public PhillyCheese() {
        super(Size.MEDIUM, BreadType.WHITE, true);
        Meat bltMeat = new Meat(Protein.STEAK, false, Size.MEDIUM);
        Cheese bltCheese = new Cheese(Cheeses.AMERICAN, false, Size.MEDIUM);
        this.addToppings(RegTopping.PEPPERS);
        this.addToppings(Sauce.MAYO);
        this.addMeat(bltMeat);
        this.addCheese(bltCheese);
    }

}
