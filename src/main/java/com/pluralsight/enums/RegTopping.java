package com.pluralsight.enums;

public enum RegTopping implements Topping {
    LETTUCE,
    PEPPERS,
    ONIONS,
    TOMATOES,
    JALAPENOS,
    CUCUMBERS,
    PICKLES,
    GUACAMOLE,
    MUSHROOMS;

    @Override
    public String getName() {
        return name().toLowerCase();
    }
}
