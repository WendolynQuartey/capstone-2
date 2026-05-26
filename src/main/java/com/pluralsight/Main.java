package com.pluralsight;

import com.pluralsight.enums.Size;

public class Main {
    public static void main(String[] args) {
        Meat meat = new Meat("steak", true, Size.SMALL,5.50);

        System.out.println(meat.getPrice());
    }
}
