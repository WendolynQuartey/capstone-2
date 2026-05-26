package com.pluralsight.enums;

import com.pluralsight.Sandwich;

import java.util.ArrayList;

public class Order {
    String customerName;
    ArrayList<Sandwich> sandwiches;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void addSandwich(Sandwich s){
        sandwiches.add(s);
    }

    public double getOrderTotal() {
        double total = 0;

        for (Sandwich s : sandwiches){
            total += s.calculatePrice();
        }
        return total;
    }
}
