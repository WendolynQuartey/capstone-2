package com.pluralsight;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.Protein;
import com.pluralsight.enums.Size;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        UserInterface.display();
        Meat meat = new Meat(Protein.STEAK, true, Size.SMALL);

        System.out.println(meat.getPrice());

        Sandwich sandwich = new Sandwich(Size.SMALL, BreadType.WHITE, true);

        sandwich.addMeat(meat);

        System.out.println(sandwich.calculatePrice());

        Order order = new Order("Wendy");

        order.addSandwich(sandwich);
        System.out.println(order.getOrderDetails(order));

        ReceiptFileManager.saveReciept(order, LocalDateTime.now());
    }
}
