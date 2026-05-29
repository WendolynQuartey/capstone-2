package com.pluralsight;

import com.pluralsight.enums.*;

import java.util.HashSet;

public class Sandwich {
    Size size;
    private BreadType breadType;
    private boolean isToasted;
    double price;
    Cheese cheese;
    Meat meat;
    HashSet<Topping> toppings;

    public Sandwich(Size size, BreadType breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.price = 0;
        this.cheese = null;
        this.meat = null;
        this.toppings = new HashSet<>();
    }

    //region getters/setters

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public HashSet<Topping> getToppings() {
        return toppings;
    }

    //endregion

    public void addCheese(Cheese cheese){
        this.cheese = cheese;
    }

    public void addMeat(Meat meat){
        this.meat = meat;
    }

    public boolean addToppings(Topping t) {
        if (toppings.contains(t)){
            return false;
        }
        toppings.add(t);
        return true;
    }

    public boolean removeTopping(Topping t){
        if (toppings.contains(t)){
            toppings.remove(t);
            return true;
        }
        return false;
    }

    public String getSandwichDetails(Sandwich s){
        String p1 = "";
        if (this.cheese != null) {
            p1 += String.format("\n\t%s", cheese);
        }

        if (this.meat != null) {
            p1 += String.format("\n\t%s", meat);
        }

        for (Topping t: s.toppings){
            p1 += String.format("\n\t%s", t.getName());
        }
        return p1;
    }

    public double calculatePrice() {

        if (this.size == Size.SMALL) {
            this.price = 5.50;
        } else if (this.size == Size.MEDIUM) {
            this.price = 7.00;
        } else if (this.size == Size.LARGE) {
            this.price = 8.50;
        }
        if (this.cheese != null){
            this.price += cheese.getPrice();
        }
         if (this.meat != null){
             this.price += meat.getPrice();
         }

        return this.price;
    }

}
