package com.pluralsight;

abstract class Ingredient extends Sandwich{
    boolean hasExtra;

    public Ingredient(Size size, String breadType, boolean isToasted, double price, boolean hasExtra) {
        super(size, breadType, isToasted, price);
        this.hasExtra = hasExtra;
    }

    //region getters/setters

    public boolean isHasExtra() {
        return hasExtra;
    }

    public void setHasExtra(boolean hasExtra) {
        this.hasExtra = hasExtra;
    }

    //endregion

}
