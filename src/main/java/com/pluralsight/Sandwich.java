package com.pluralsight;

import java.util.HashSet;

public class Sandwich {
    Size size;
    private String breadType;
    private boolean isToasted;
    double price;
    HashSet<Ingredient> ingredients;
    //HashSet<Topping> toppings;

    public Sandwich(Size size, String breadType, boolean isToasted, double price) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.price = price;
        this.ingredients = new HashSet<>();
        //this.toppings = new HashSet<>();
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
        this.ingredients.add(i);
    }
}
