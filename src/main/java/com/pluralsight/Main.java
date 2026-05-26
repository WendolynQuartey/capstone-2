package com.pluralsight;

import com.pluralsight.enums.Size;

public class Main {
    public static void main(String[] args) {
        Meat meat = new Meat("steak", true, Size.SMALL,1.00);

        System.out.println(meat.getPrice());

        Sandwich sandwich = new Sandwich(Size.SMALL,"white", true);

        sandwich.addIngredients(meat);

        System.out.println(sandwich.calculatePrice());

        Order order = new Order("Wendy");

        order.addSandwich(sandwich);
        System.out.println(order.getOrderDetails(order));
    }
}
