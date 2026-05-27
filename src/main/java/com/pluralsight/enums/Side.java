package com.pluralsight.enums;

public enum Side  implements Topping{
    AU_JUS,
    SAUCE;


    @Override
    public String getName() {
        if(this == AU_JUS){
            return "au jus";
        }
        return name().toLowerCase();
    }
}
