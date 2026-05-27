package com.pluralsight.enums;

public enum Sauce implements Topping {
    MAYO,
    MUSTARD,
    KETCHUP ,
    RANCH,
    THOUSAND_ISLANDS,
    VINAIGRETTE;

    @Override
    public String getName() {
        if (this == THOUSAND_ISLANDS){
            return "thousand islands";
        }

        return name().toLowerCase();
    }
}
