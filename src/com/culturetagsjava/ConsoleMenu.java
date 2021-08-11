package com.culturetagsjava;

import java.util.Scanner;

public class ConsoleMenu {

    private Scanner scanner;
    private Menu mainMenu;
    private GameMain gameMain;

    public ConsoleMenu(Scanner scanner, Menu mainMenu, GameMain gameMain) {
        this.scanner = scanner;
        this.mainMenu = mainMenu;
        this.gameMain = gameMain;
    }

    public void displayMenu() throws InterruptedException {
        System.out.println(" ##### Welcome to Culture Tags #####");
        System.out.println("------------------------------------");
        System.out.println("A Game for People Who Love Hashtags!");
        System.out.println("------------------------------------");
        System.out.println();
        System.out.println("--------------CREATORS--------------");
        System.out.println("Java Program By: Nahom E., Nelson E.,");
        System.out.println("Mehki H., Elmiche K., Kaitlyn R.");
        System.out.println("------------------------------------");
        System.out.println();
        System.out.println("----------------MENU----------------");
        System.out.println("Please type in the letter associated");
        System.out.println("with your option of choice.");
        System.out.println();
        System.out.println("A Instructions");
        System.out.println("B Play Game");
        System.out.println("C Add New Cards");
        System.out.println("------------------------------------");
        Scanner scan = new Scanner(System.in);
        String option = scanner.nextLine();
        optionAction(option);
    }

    public void optionAction(String chosenAction) throws InterruptedException {
        chosenAction = chosenAction.toUpperCase();
        if (chosenAction.equals("A")) {
            Instructions instructions = new Instructions();
        } else if (chosenAction.equals("B")) {
            this.gameMain.run();
        } else if (chosenAction.equals("C")) {
            System.out.println("Add New Cards feature is currently unavailable.");
        } else {
            displayMenu();
        }
    }
}
