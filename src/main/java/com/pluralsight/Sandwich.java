package com.pluralsight;

import com.pluralsight.enums.Size;

import java.util.HashSet;

public class Sandwich {
    Size size;
    private String breadType;
    private boolean isToasted;
    double price;
    HashSet<Ingredient> ingredients;
    HashSet<Topping> toppings;

    public Sandwich(Size size, String breadType, boolean isToasted, double price) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.price = price;
        this.ingredients = new HashSet<>();
        this.toppings = new HashSet<>();
    }

    public Sandwich(Size size, double price) {
        this.size = size;
        this.price = price;
    }



    //region getters/setters

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
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

    //endregion

    public void addIngredients(Ingredient i){
        ingredients.add(i);
    }

    public void addRegToppings(Topping t){
        toppings.add(t);
    }

    public double calculatePrice() {
        double total = 0;

        for (Ingredient i: ingredients){
            total += i.getPrice();
        }

        if (this.size == Size.SMALL) {
            this.price = 5.50;
        } else if (this.size == Size.MEDIUM) {
            this.price = 7.00;
        } else if (this.size == Size.LARGE) {
            this.price = 8.50;
        }
        return total += this.price;
    }

}
