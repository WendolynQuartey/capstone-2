package com.pluralsight;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.Size;
import com.pluralsight.enums.Topping;

import java.util.Scanner;

public class UserInterface {
    private static Order order;
    private static Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public static void display() {
        System.out.print("""
                \nWelcome to Wendy's Deli-cious Sandwicheria!
                Please enter your name:\t
                """);
        String customerName = scanner.nextLine();
         order = new Order(customerName);


        System.out.print("""
                Menu Options:
                1) Order Sandwich
                2) Order Drink
                3) Order Chips
                0) Exit
                
                Select:\t
                """);

        String userSelection = scanner.nextLine();

        switch (userSelection) {
            case "1":
                processSandwich();

        }
    }

    public static void setOrder(Order order) {
        UserInterface.order = order;
    }

    public void processOrder(String name) {

    }

    public static void processSandwich() {
        Size selectedSize = null;
        BreadType selectedBread = null;

        // Get user size and checks if size is a match for
        while (selectedSize == null) {
            System.out.println("Size Options: ");
            displaySize();

            System.out.print("\nWhat size would you like your sandwich? ");
            String userSize = scanner.nextLine().toUpperCase();

            for (Size size : Size.values()) {
                if (userSize.equals(size.name())) {
                    selectedSize = size;
                    break;
                }
            }
         if (selectedSize == null) {
                System.out.print("\nThat size is not available! Please try again .\n");
            }

        }

        while (selectedBread == null) {
            System.out.println("Bread Options: ");
            displayBreadType();
            System.out.print("\nWhat bread type would you like use for your sandwich? ");

            String userBread = scanner.nextLine().toUpperCase();

            for (BreadType bread : BreadType.values()) {
                if (userBread.equals(bread.name())) {
                    selectedBread = bread;
                }
                if (selectedBread == null) {
                    System.out.print("\nThat bread is not available! Please try again. \n");
                }
            }
        }

        Sandwich sandwich = new Sandwich(selectedSize, selectedBread, false);

        System.out.print("\nWould you like your sandwich toasted? (yes/no): ");
        String wantsToasted = scanner.nextLine().toLowerCase();
        if(wantsToasted.equals("yes")){
            sandwich.setToasted(true);
        } else {
            System.out.println("This is not an option!");
        }

        order.addSandwich(sandwich);

    }

        public static void processDrink () {
            System.out.println("What size would you like your drink?");
            displaySize();
        }

        public static void processChips () {

        }

        public static void displayMeats() {

        }

        public static void processToppings(Sandwich sandwich) {

            System.out.print("""
                    \nTopping Options
                    1) Order Sandwich
                    2) Order Drink
                    3) Order Chips
                    0) Exit
                    
                    Select:\t
                    """);
        }



//        public static void displayToppings () {
//            for (Topping topping : ) {
//                System.out.println(topping.name().toLowerCase());
//            }
//        }

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
