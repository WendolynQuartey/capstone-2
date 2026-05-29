package com.pluralsight;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    String customerName;
    ArrayList<Sandwich> sandwiches;
    ArrayList<Drink> drinks;
    ArrayList<Chip> chips;

    public Order(String customerName) {
        this.customerName = customerName;
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }

    public void addSandwich(Sandwich s){
        sandwiches.add(s);
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void addChips(Chip chip){
        chips.add(chip);
    }

    public double getOrderTotal() {
        double total = 0;

        if (sandwiches != null) {
            for (Sandwich s : sandwiches) {
                total += s.calculatePrice();
            }
        }

        if (drinks != null) {
            for (Drink d : drinks) {
                total += d.getPrice();
            }
        }

        if (chips != null) {
            for (Chip c : chips) {
                total += c.getPrice();
            }
        }

        return total;
    }

    public String getReceiptDetails(Order o){
        String receipt = String.format("""
                ================================
                            RECEIPT
                =================================
                Date: [%tF]
                
                Received From: [%s]
                
                Description:
                ---------------------------------
                """,LocalDateTime.now(),o.getCustomerName());

        for (Sandwich s: sandwiches){
            receipt += String.format("%s Sandwich $%.2f",s.getSize(),s.getPrice());
            receipt += s.getSandwichDetails(s);
        }

        if(this.drinks != null) {
            for (Drink d : drinks) {
                receipt += String.format("%s Drink - $%.2f", d.getSize(), d.getPrice());
            }
        }

        if (this.chips != null) {
            for (Chip c : chips) {
                receipt += String.format("Chip - $%.2f", c.getPrice());
            }
        }

        receipt += String.format("""
        \n---------------------------------
        Total:    $%.2f

        Payment Method: [Cash/Card]
        Received By: [Deli-cuos]
        ---------------------------------
            Thank You for Your Business
        =================================
        """, o.getOrderTotal());

        return receipt;
    }

    public String getOrderDetails(Order o) {
        String result = "";

        if (this.sandwiches != null) {
            for (Sandwich s : sandwiches) {
                result += String.format("%s Sandwich $%.2f", s.getSize(), s.getPrice());
                result += s.getSandwichDetails(s);
            }
        }

        if(this.drinks != null) {
            for (Drink d : drinks) {
                result += String.format("%s Drink - $%.2f", d.getSize(), d.getPrice());
            }
        }

        if (this.chips != null) {
            for (Chip c : chips) {
                result += String.format("Chip - $%.2f", c.getPrice());
            }
        }
        return result;
    }
}
