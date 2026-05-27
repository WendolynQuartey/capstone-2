package com.pluralsight.enums;

public enum RegTopping implements Topping {
    LETTUCE,
    PEPPERS,
    ONIONS,
    TOMATOES,
    JALAPEÑOS,
    CUCUMBERS,
    PICKLES,
    GUACAMOLE,
    MUSHROOMS;

    @Override
    public String getName() {
        return name().toLowerCase();
    }
}
