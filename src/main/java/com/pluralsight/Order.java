package com.pluralsight;


import com.pluralsight.enums.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    String customerName;
    ArrayList<Sandwich> sandwiches;
    ArrayList<OtherProduct> others;

    public Order(String customerName) {
        this.customerName = customerName;
        this.sandwiches = new ArrayList<>();
        this.others = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void addSandwich(Sandwich s){
        sandwiches.add(s);
    }

    public void addOtherProduct(OtherProduct other){
        others.add(other);
    }

    public double getOrderTotal() {
        double total = 0;

        for (Sandwich s : sandwiches){
            total += s.calculatePrice();
        }

        for (OtherProduct other : others){
            total += other.getPrice();
        }

        return total;
    }

    public String getOrderDetails(Order o){
        String p1 = String.format("""
                ================================
                            RECEIPT
                =================================
                Date: [%tF]
                
                Received From: [%s]
                
                Description:
                ---------------------------------
                """,LocalDateTime.now(),o.getCustomerName());

        for (Sandwich s: sandwiches){
            p1 += String.format("Sandwich - $%.2f",s.getPrice());
        }

        for (OtherProduct other: others){
            Drink drink = new Drink(3.00, Size.LARGE);
            p1 += String.format("%s Drink - $%.2f",Drink.getSize(), drink.getPrice() );
        }

        p1 += String.format("""
        \n---------------------------------
        Total:    $%.2f

        Payment Method: [Cash/Card]
        Received By: [Deli-cuos]
        ---------------------------------
            Thank You for Your Business
        =================================
        """, o.getOrderTotal());

        return p1;
    }
}
