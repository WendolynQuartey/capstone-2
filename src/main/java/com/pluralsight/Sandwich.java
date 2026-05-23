package com.pluralsight;

import java.util.ArrayList;

public class Sandwich {
    private Size size;
    private String breadType;
    private boolean isToasted;
    private double price;
    ArrayList<Ingredient> ingredients;

    public Sandwich(Size size, String breadType, boolean isToasted, double price) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.price = price;
        this.ingredients = new ArrayList<>();
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
