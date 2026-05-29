package com.pluralsight;

import com.pluralsight.enums.*;

import java.util.Scanner;

public class UserInterface {
    private static Order order;
    private static final Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public static void display() {
        System.out.print("""
                \nWelcome to Wendy's Deli-cious Sandwicheria!
                Please enter your name:\t
                """);
        String customerName = scanner.nextLine();
         order = new Order(customerName);

         boolean isRunning = true;

        while(isRunning) {
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
                    break;
                case "2":
                    processDrink();
                    break;
                case "3":
                    processChips();
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Not an option. Try again");
            }
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

        processToppings(sandwich);

    }

        public static void processDrink () {
            System.out.println("What size would you like your drink?");
            displaySize();
        }

        public static void processChips () {

        }

        public static void processToppings(Sandwich sandwich) {

            boolean isRunning = true;

            while(isRunning) {
                System.out.print("""
                    \nTopping Options
                    1) Regular Toppings
                    2) Sauces
                    3) Sides
                    0) Go Back
                    
                    Select:\t
                    """);

                String userSelection = scanner.nextLine();

                switch (userSelection) {
                    case "1":
                        addRegToppings(sandwich);
                        break;
                    case "2":
                        addSauces(sandwich);
                        break;
                    case "3":
                        addSides(sandwich);
                        break;
                    case "0":
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Not an option. Try again");
                }
            }

        }

        public static void addSauces (Sandwich sandwich) {
            displaySauces();

            boolean isRunning = true;

            while (isRunning) {
                System.out.print("\nEnter a sauce you would like to add or 'done' to finish adding topping: ");
                String userSauce = scanner.nextLine().toLowerCase();

                if (userSauce.equals("done")){
                    isRunning = false;
                }

                boolean isUsedTopping = false;
                for (Sauce sauce : Sauce.values()) {
                    if (userSauce.equals(sauce.getName())) {
                        if (sandwich.addToppings(sauce)){
                            System.out.println(sauce.getName() + " has successfully been added to your sandwich");
                        } else {
                            System.out.println("You already added " + sauce.getName());
                        }
                        isUsedTopping = true;
                        }
                    }

                    if(!isUsedTopping){
                        System.out.println("This is not an option!!");
                    }

                }
            }

            public static void addSides (Sandwich sandwich){
            displaySides();

            boolean isRunning = true;

            while (isRunning) {
                System.out.print("\nEnter a side you would like to add or 'done' to finish adding topping: ");
                String userSide = scanner.nextLine().toLowerCase();

                if (userSide.equals("done")){
                    isRunning = false;
                }

                boolean isUsedTopping = false;
                for (Side side : Side.values()) {
                    if (userSide.equals(side.getName())) {
                        if (sandwich.addToppings(side)){
                            System.out.println(side.getName() + " has successfully been added to your sandwich");
                        } else {
                            System.out.println("You already added " + side.getName());
                        }
                        isUsedTopping = true;
                    }
                }

                if(!isUsedTopping){
                    System.out.println("This is not an option!!");
                }

                }
            }

            public static void addRegToppings (Sandwich sandwich) {
            displayRegToppings();

            boolean isRunning = true;

            while (isRunning) {
                System.out.print("\nEnter a topping you would like to add or 'done' to finish adding topping: ");
                String userTopping = scanner.nextLine().toLowerCase();

                if(userTopping.equals("done")){
                    isRunning = false;
                }

                boolean isUsedTopping = false;
                for (RegTopping topping : RegTopping.values()) {
                    if (userTopping.equals(topping.getName())) {
                        if (sandwich.addToppings(topping)){
                            System.out.println(topping.getName() + " has successfully been added to your sandwich");
                        } else {
                            System.out.println("You already added " + topping.getName());
                        }
                        isUsedTopping = true;
                    }
                }

                if(!isUsedTopping){
                    System.out.println("This is not an option!!");
                }

            }


        }

        public static void displayBreadType () {
            for (BreadType bread : BreadType.values()) {
                System.out.println(bread.name().toLowerCase());
            }
        }

        public static void displayRegToppings (){
            for (RegTopping topping : RegTopping.values()) {
                System.out.println(topping.name().toLowerCase());
            }
        }

        public static void displaySize () {
            for (Size size : Size.values()) {
                System.out.println(size.name().toLowerCase());
            }
        }

        public static void displaySauces() {
            for (Sauce sauce : Sauce.values()) {
                System.out.println(sauce.getName());
            }
        }

        public static void displaySides() {
            for (Side side : Side.values()) {
                System.out.println(side.getName());
            }
        }

        public static void displayMeats() {
            for (Protein meat : Protein.values()){
                System.out.println(meat.name().toLowerCase());
            }
        }

        public static void displayCheese() {
            for (Cheeses cheese : Cheeses.values()){
                System.out.println(cheese.name().toLowerCase());
            }
    }

}
