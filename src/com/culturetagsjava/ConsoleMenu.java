package com.culturetagsjava;

import java.util.Scanner;

public class ConsoleMenu {
    // 3 menu options
    /*
     * Instructions Play Game Add New Cards
     */
    // Have a constructor
    /*
     * Takes user input if equal to instructions -> if equal Play Game -> if equal
     * Add New Cards
     */

    private Scanner scanner;
    private GameMain gameMain;
    
    public ConsoleMenu(Scanner scanner, GameMain gameMain) {
        this.scanner = scanner;
        this.gameMain = gameMain;
    }

    public void displayMenu() throws InterruptedException {
        // Make the following into a method
        System.out.println("-----------------------------------");
        System.out.println("##### Welcome to Culture Tags #####");
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println("Please type one of the following:");
        System.out.println("Please note case sensitivity.");
        System.out.println();
        System.out.println("#### Instructions");
        System.out.println("#### Play Game");
        System.out.println("#### Add New Cards");
        Scanner scan = new Scanner(System.in);
        String option = scan.nextLine();
        optionAction(option);
    }

    public void optionAction(String chosenAction) throws InterruptedException {
        if (chosenAction.equals("Instructions")) {
            System.out.println("Instructions are currently unavailable");
        } else if (chosenAction.equals("Play Game")) {
            this.gameMain.run();
        } else if (chosenAction.equals("Add New Cards")) {
            System.out.println("Add New Cards feature is currently unavailable.");
        } else {
            displayMenu();
        }
    }
}
