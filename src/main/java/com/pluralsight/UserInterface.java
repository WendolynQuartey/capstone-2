package com.pluralsight;

import com.pluralsight.enums.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UserInterface {
    private static Order order;
    private static final Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public static void display() {
        boolean isRunning = true;
        while(isRunning) {
            String customerName = "";
            while(customerName.isEmpty()) {
                System.out.print("""
                        \nWelcome to Wendy's Deli-cious Sandwicheria!
                        Please enter your name:\t
                        """);
                customerName = scanner.nextLine().trim();
                if (customerName.isEmpty()) {
                    System.out.println("Name can't be empty. Try Again");
                }
            }

            order = new Order(customerName);

            while (isRunning) {
                System.out.print("""
                        Menu Options:
                        1) Order Sandwich
                        2) Order Drink
                        3) Order Chips
                        4) View Full Order & Checkout
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
                    case "4":
                        processOrder();
                        break;
                    case "0":
                        order = null;
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Not an option. Try again");
                }
            }
        }
    }


    public static void processOrder() {
        boolean isRunning = true;
        while (isRunning) {
            if (order.getChips().isEmpty() && order.getSandwiches().isEmpty() && order.getDrinks().isEmpty()) {
                System.out.println("Order is empty!");
                isRunning = false;
            } else {
                order.getOrderDetails(order);
                System.out.println("Will that be all? (yes/no) ");
                String confirmOrder = scanner.nextLine().toLowerCase();
                if (confirmOrder.equals("yes")) {
                    System.out.println(order.getReceiptDetails(order));
                    ReceiptFileManager.saveReceipt(order, LocalDateTime.now());
                    System.exit(0);
                } else if (confirmOrder.equals("no")) {
                    isRunning = false;
                } else {
                    System.out.println("This is not an option! Try Again!");
                }
            }
        }
    }

    public static void processSandwich() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("""
                     \nSandwich Options:
                      1) Customize Your Sandwich
                      2) Order BLT
                      3) Order Philly cheesesteak
                      0) Go Back
                    \s
                      Select:\t
                     \s""");

            String userSelection = scanner.nextLine();

            switch (userSelection) {
                case "1":
                    addCustomSandwich();
                    break;
                case "2":
                    processBLT();
                    break;
                case "3":
                    processPhillyCheese();
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Not an option. Try again");
            }

        }
    }

    public static void processBLT() {
        BLT bltSandwich = new BLT();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Current Toppings: ");
            for (Topping t : bltSandwich.getToppings()) {
                System.out.println(t.getName());
            }
            System.out.println(bltSandwich.getMeat().meat.name().toLowerCase());
            System.out.println(bltSandwich.getCheese().cheese.name().toLowerCase());
            System.out.print("""
                     \nBLT Options:
                      1) Customize Your BLT
                      2) Add BLT to Order
                      0) Go Back
                    \s
                      Select:\t
                     \s""");

            String userSelection = scanner.nextLine();

            switch (userSelection) {
                case "1":
                    processToppings(bltSandwich);
                    break;
                case "2":
                    order.addSandwich(bltSandwich);
                    isRunning = false;
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Not an option. Try again");
            }

        }
    }

    public static void processPhillyCheese() {
        PhillyCheese phillyCheese = new PhillyCheese();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Current Toppings: ");
            for (Topping t : phillyCheese.getToppings()) {
                System.out.println(t.getName());
            }
            System.out.println(phillyCheese.getMeat().meat.name().toLowerCase());
            System.out.println(phillyCheese.getCheese().cheese.name().toLowerCase());
            System.out.print("""
                     \nPhilly Cheesesteak Options:
                      1) Customize Your Philly Cheesesteak
                      2) Add Philly Cheesesteak to Order
                      0) Go Back
                    \s
                      Select:\t
                     \s""");

            String userSelection = scanner.nextLine();

            switch (userSelection) {
                case "1":
                    processToppings(phillyCheese);
                    break;
                case "2":
                    order.addSandwich(phillyCheese);
                    isRunning = false;
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Not an option. Try again");
            }

        }
    }

    public static void addCustomSandwich() {
        Size selectedSize = null;
        BreadType selectedBread = null;
        Sandwich sandwich;

        // Get user size and checks if size matches any Size enum values
        while (selectedSize == null) {
            System.out.println("Size Options: ");
            displaySize();

            System.out.print("\nWhat size would you like your sandwich? ");
            String userSize = scanner.nextLine().toUpperCase();

            for (Size size : Size.values()) {
                if (userSize.equals(size.name())) {
                    selectedSize = size;

                }
            }

            if (selectedSize == null) {
                System.out.print("\nThat size is not available! Please try again .\n");
            }

        }
        // Get user's bread type and checks if their bread type matches any BreadType enum values
        while (selectedBread == null) {
            System.out.println("Bread Options: ");
            displayBreadType();
            System.out.print("\nWhat bread type would you like use for your sandwich? ");

            String userBread = scanner.nextLine().toUpperCase();

            for (BreadType bread : BreadType.values()) {
                if (userBread.equals(bread.name())) {
                    selectedBread = bread;
                }
            }

            if (selectedBread == null) {
                System.out.print("\nThat bread is not available! Please try again. \n");
            }
        }


        sandwich = new Sandwich(selectedSize, selectedBread, false);

        boolean toastedAnswered = false;
        while (!toastedAnswered) {
            System.out.print("\nWould you like your sandwich toasted? (yes/no): ");
            String wantsToasted = scanner.nextLine().toLowerCase();
            if (wantsToasted.equals("yes")) {
                sandwich.setToasted(true);
                toastedAnswered = true;
            } else if (wantsToasted.equals("no")) {
                toastedAnswered = true;
            } else {
                System.out.println("This is not an option! Try Again");
            }
        }

        processToppings(sandwich);
        order.addSandwich(sandwich);
    }

    public static void processDrink() {
        boolean isRunning = true;
        while (isRunning) {
            displaySize();
            System.out.println("What size would you like your drink? ");
            String drinkSize = scanner.nextLine().toLowerCase();
            boolean isSize = false;

            for (Size size : Size.values()) {
                if (drinkSize.equals(size.name().toLowerCase())) {
                    Drink drink = new Drink(size);
                    order.addDrink(drink);
                    System.out.println(size + " drink added!");
                    isSize = true;
                    isRunning = false;
                }
            }

            if (!isSize) {
                System.out.println("This option is not available. Try Again!");
            }
        }
    }

    public static void processChips() {
        boolean isRunning = true;
        while (isRunning) {
            Chip chip = new Chip();
            order.addChips(chip);
            System.out.println("Chip added!");
            isRunning = false;
            }
    }

    public static void processToppings(Sandwich sandwich) {
        boolean isRunning = true;
        while (isRunning) {

            if (sandwich instanceof BLT || sandwich instanceof PhillyCheese) {
                System.out.print("""
                         \nTopping Options:
                          1) Add Regular Toppings
                          2) Add Sauces
                          3) Add Sides
                          4) Change Premium Toppings
                          5) Remove Topping
                          0) Done
                        \s
                          Select:\t
                         \s""");

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
                    case "4":
                        processPremiums(sandwich);
                        break;
                    case "5":
                        removeUsedToppings(sandwich);
                        break;
                    case "0":
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Not an option. Try again");
                }
            } else {
                System.out.print("""
                         \nTopping Options:
                          1) Add Regular Toppings
                          2) Add Sauces
                          3) Add Sides
                          4) Add Premium Toppings
                          0) Done
                        \s
                          Select:\t
                         \s""");

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
                    case "4":
                        processPremiums(sandwich);
                        break;
                    case "0":
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Not an option. Try again");
                }
            }
        }

    }

    public static void processPremiums(Sandwich sandwich) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("""
                    \nPremium Topping Options:
                    1) Meat
                    2) Cheese
                    0) Go Back
                    
                    Select:\t
                    """);

            String userSelection = scanner.nextLine();

            switch (userSelection) {
                case "1":
                    addMeat(sandwich);
                    break;
                case "2":
                    addCheese(sandwich);
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Not an option. Try again");
            }
        }
    }

    public static void addMeat(Sandwich sandwich) {
        boolean isRunning = true;
        while (isRunning) {
            if (sandwich.getMeat() == null) {
                displayMeats();
                System.out.println("Which protein would you like on your sandwich? ");
                String proteinChoice = scanner.nextLine().toLowerCase();

                for (Protein meat : Protein.values()) {
                    if (proteinChoice.equals(meat.name().toLowerCase())) {
                        boolean answeredExtra = false;
                        while (!answeredExtra) {
                            System.out.print("\nWould you like extra of " + proteinChoice + "? (yes/no) ");
                            String wantsExtraProtein = scanner.nextLine().toLowerCase();
                            if (wantsExtraProtein.equals("yes")) {
                                Meat userProtein = new Meat(meat, true, sandwich.getSize());
                                sandwich.addMeat(userProtein);
                                answeredExtra = true;
                                isRunning = false;
                            } else if (wantsExtraProtein.equals("no")) {
                                Meat userProtein = new Meat(meat, false, sandwich.getSize());
                                sandwich.addMeat(userProtein);
                                answeredExtra = true;
                                isRunning = false;
                            } else {
                                System.out.println("This is not an option!");
                            }
                        }
                    }
                }

            } else if (sandwich instanceof BLT || sandwich instanceof PhillyCheese){
                displayMeats();
                System.out.println("Which protein would you switch" + sandwich.getMeat().meat.name().toLowerCase() +"for on your sandwich? ");
                String proteinChoice = scanner.nextLine().toLowerCase();
                sandwich.setMeat(null);
                for (Protein meat : Protein.values()) {
                    if (proteinChoice.equals(meat.name().toLowerCase())) {
                        boolean answeredExtra = false;
                        while (!answeredExtra) {
                            System.out.print("\nWould you like extra of " + proteinChoice + " (yes/no) ");
                            String wantsExtraProtein = scanner.nextLine().toLowerCase();
                            if (wantsExtraProtein.equals("yes")) {
                                Meat userProtein = new Meat(meat, true, sandwich.getSize());
                                sandwich.addMeat(userProtein);
                                answeredExtra = true;
                                isRunning = false;
                            } else if (wantsExtraProtein.equals("no")) {
                                Meat userProtein = new Meat(meat, false, sandwich.getSize());
                                sandwich.addMeat(userProtein);
                                answeredExtra = true;
                                isRunning = false;
                            } else {
                                System.out.println("This is not an option!");
                            }
                        }
                    }
                }
            } else {
                isRunning = false;
            }
        }
    }

    public static void addCheese(Sandwich sandwich) {
        boolean isRunning = true;

        while (isRunning) {
            if (sandwich.getCheese() == null) {
                displayCheese();
                System.out.println("Which cheese would you like on your sandwich? ");
                String cheeseChoice = scanner.nextLine().toLowerCase();

                for (Cheeses cheese : Cheeses.values()) {
                    if (cheeseChoice.equals(cheese.name().toLowerCase())) {
                        boolean answeredExtra = false;
                        while (!answeredExtra) {
                            System.out.print("\nWould you like extra of " + cheeseChoice + " (yes/no) ");
                            String wantsExtraCheese = scanner.nextLine().toLowerCase();
                            if (wantsExtraCheese.equals("yes")) {
                                Cheese userCheese = new Cheese(cheese, true, sandwich.getSize());
                                sandwich.addCheese(userCheese);
                                answeredExtra = true;
                                isRunning = false;
                            } else if (wantsExtraCheese.equals("no")) {
                                Cheese userCheese = new Cheese(cheese, false, sandwich.getSize());
                                sandwich.addCheese(userCheese);
                                answeredExtra = true;
                                isRunning = false;
                            } else {
                                System.out.println("This is not an option!");
                            }
                        }
                    }
                }

            } else if (sandwich instanceof BLT || sandwich instanceof PhillyCheese){
                displayCheese();
                System.out.println("Which cheese would you switch" + sandwich.getCheese().cheese.name().toLowerCase() +"for on your sandwich? ");
                String proteinChoice = scanner.nextLine().toLowerCase();
                sandwich.setCheese(null);
                for (Cheeses cheese : Cheeses.values()) {
                    if (proteinChoice.equals(cheese.name().toLowerCase())) {
                        boolean answeredExtra = false;
                        while (!answeredExtra) {
                            System.out.print("\nWould you like extra of " + proteinChoice + " (yes/no) ");
                            String wantsExtraProtein = scanner.nextLine().toLowerCase();
                            if (wantsExtraProtein.equals("yes")) {
                                Cheese userCheese = new Cheese(cheese, true, sandwich.getSize());
                                sandwich.addCheese(userCheese);
                                answeredExtra = true;
                                isRunning = false;
                            } else if (wantsExtraProtein.equals("no")) {
                                Cheese userCheese = new Cheese(cheese, false, sandwich.getSize());
                                sandwich.addCheese(userCheese);
                                answeredExtra = true;
                                isRunning = false;
                            } else {
                                System.out.println("This is not an option!");
                            }
                        }
                    }
                }
            } else {
                System.out.println("That is not an option");
            }
        }
    }


        public static void addSauces (Sandwich sandwich){
            displaySauces();

            boolean isRunning = true;

            while (isRunning) {
                System.out.print("\nEnter a sauce you would like to add or 'done' to finish adding topping: ");
                String userSauce = scanner.nextLine().toLowerCase();

                if (userSauce.equals("done")) {
                    isRunning = false;
                }

                boolean isUsedTopping = false;
                for (Sauce sauce : Sauce.values()) {
                    if (userSauce.equals(sauce.getName())) {
                        if (sandwich.addToppings(sauce)) {
                            System.out.println(sauce.getName() + " has successfully been added to your sandwich");
                        } else {
                            System.out.println("You already added " + sauce.getName());
                        }
                        isUsedTopping = true;
                    }
                }

                if (!isUsedTopping) {
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

                if (userSide.equals("done")) {
                    isRunning = false;
                }

                boolean isUsedTopping = false;
                for (Side side : Side.values()) {
                    if (userSide.equals(side.getName())) {
                        if (sandwich.addToppings(side)) {
                            System.out.println(side.getName() + " has successfully been added to your sandwich");
                        } else {
                            System.out.println("You already added " + side.getName());
                        }
                        isUsedTopping = true;
                    }
                }

                if (!isUsedTopping) {
                    System.out.println("This is not an option!!");
                }

            }
        }

        public static void addRegToppings (Sandwich sandwich){
            displayRegToppings();

            boolean isRunning = true;

            while (isRunning) {
                System.out.print("\nEnter a topping you would like to add or 'done' to finish adding topping: ");
                String userTopping = scanner.nextLine().toLowerCase();

                if (userTopping.equals("done")) {
                    isRunning = false;
                }

                boolean isUsedTopping = false;
                for (RegTopping topping : RegTopping.values()) {
                    if (userTopping.equals(topping.getName())) {
                        if (sandwich.addToppings(topping)) {
                            System.out.println(topping.getName() + " has successfully been added to your sandwich");
                        } else {
                            System.out.println("You already added " + topping.getName());
                        }
                        isUsedTopping = true;
                    }
                }

                if (!isUsedTopping) {
                    System.out.println("This is not an option!!");
                }

            }

        }

    public static void removeUsedToppings(Sandwich sandwich){
        displayUsedToppings(sandwich);
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("\nEnter a topping you would like to remove or 'done' to finish adding topping: ");
            String userTopping = scanner.nextLine().toLowerCase();

            if (userTopping.equals("done")) {
                isRunning = false;
            }

            boolean isUsedTopping = false;
            for (RegTopping topping : RegTopping.values()) {
                if (userTopping.equals(topping.getName())) {
                    if (sandwich.removeTopping(topping)) {
                        System.out.println(topping.getName() + " has successfully been removed from your sandwich");
                    } else {
                        System.out.println("You already remove " + topping.getName());
                    }
                    isUsedTopping = true;
                }
            }

            if (!isUsedTopping) {
                System.out.println("This is not an option!!");
            }

        }

    }

        public static void displayBreadType () {
            for (BreadType bread : BreadType.values()) {
                System.out.println(bread.name().toLowerCase());
            }
        }

        public static void displayRegToppings () {
            for (RegTopping topping : RegTopping.values()) {
                System.out.println(topping.name().toLowerCase());
            }
        }

        public static void displaySize () {
            for (Size size : Size.values()) {
                System.out.println(size.name().toLowerCase());
            }
        }

        public static void displaySauces () {
            for (Sauce sauce : Sauce.values()) {
                System.out.println(sauce.getName());
            }
        }

        public static void displaySides () {
            for (Side side : Side.values()) {
                System.out.println(side.getName());
            }
        }

        public static void displayMeats () {
            for (Protein meat : Protein.values()) {
                System.out.println(meat.name().toLowerCase());
            }
        }

        public static void displayCheese () {
            for (Cheeses cheese : Cheeses.values()) {
                System.out.println(cheese.name().toLowerCase());
            }
        }
        public static void displayUsedToppings (Sandwich sandwich) {
            for (Topping topping : sandwich.getToppings()) {
                System.out.println(topping.getName());
            }
        }


    }

