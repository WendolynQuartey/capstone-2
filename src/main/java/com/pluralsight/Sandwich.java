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

    public Sandwich(Size size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.price = 0;
        this.ingredients = new HashSet<>();
        this.toppings = new HashSet<>();
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

    public String getSandwichDetails(Sandwich s){
        String p1 = "";
        for (Ingredient i: s.ingredients){
            p1 += String.format("\n\t%s", i.getName());
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

        for (Ingredient i: ingredients){
            this.price += i.getPrice();
        }

        return this.price;
    }

}
