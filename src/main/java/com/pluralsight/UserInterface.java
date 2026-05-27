package com.pluralsight;

import com.pluralsight.enums.Size;

import java.util.Scanner;

public class UserInterface {
    private Order order;
    private static Scanner scanner = new Scanner(System.in);

    public UserInterface() {}

    public static void display(){
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

        switch (userSelection){
            case "1":
                processSandwich();

        }
    }

    public void processOrder(String name){

    }
    public static void processSandwich(){
        System.out.println("Size Options: ");
        displaySize();
        System.out.print("lnWhat size would you like your sandwich? ");
        String userSize = scanner.nextLine();



    }

    public static void processDrink(){
        System.out.println("What size would you like your drink?");
        displaySize();
    }

    public static void processChips(){

    }

    public static void displayIngredients(){

    }

    public static void displayToppings(){

    }

    public static void displayBreadType(){

    }

    public static void displaySize(){
        for (Size size: Size.values()){
            System.out.println(size.name().toLowerCase());
        }
    }

}
