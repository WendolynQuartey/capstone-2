package com.pluralsight;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.Size;

import java.util.Scanner;

public class UserInterface {
    private Order order;
    private static Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public static void display() {
        System.out.println("""
                Wendy's Deli-cious Sandwicheria.
                Options:
                1) Order Sandwich
                2) Order Drink
                3) Order Chips
                0) Exit
                
                Select:\s
                """);

        String userSelection = scanner.nextLine();

        switch (userSelection) {
            case "1":
                processSandwich();

        }
    }

    public void processOrder(String name) {

    }

    public static void processSandwich() {
        System.out.println("Size Options: ");
        displaySize();

        System.out.print("\nWhat size would you like your sandwich? ");
        String userSize = scanner.nextLine().toUpperCase();

        for (Size size : Size.values()) {
            if (userSize.equals(size.name())) {
                System.out.println("Bread Options: ");
                displayBreadType();
                System.out.print("\nWhat bread type would you like use for your sandwich? ");
                String userBread = scanner.nextLine().toUpperCase();
                for (BreadType bread : BreadType.values()) {
                    if (userBread.equals(bread.name())) {

                    } else{
                        System.out.print("\nThat bread is not available!");
                        System.out.print("\nWhat bread type would you like your sandwich? ");
                    }
                }
            } else{
                System.out.print("\nThat size is not available!");
                System.out.print("\nWhat size would you like your sandwich? ");
            }

        }
    }

        public static void processDrink () {
            System.out.println("What size would you like your drink?");
            displaySize();
        }

        public static void processChips () {

        }

        public static void displayIngredients () {

        }

        public static void displayToppings () {

        }

        public static void displayBreadType () {
            for (BreadType bread : BreadType.values()) {
                System.out.println(bread.name().toLowerCase());
            }
        }

        public static void displaySize () {
            for (Size size : Size.values()) {
                System.out.println(size.name().toLowerCase());
            }
    }

}
