package com.pluralsight;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.Size;

public class PhillyCheese extends Sandwich {
    public PhillyCheese() {
        super(Size.MEDIUM, BreadType.WHITE, true);
    }
}
