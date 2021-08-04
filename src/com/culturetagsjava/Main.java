package com.culturetagsjava;

import java.util.Scanner;

public class Main {

    private Scanner scanner;
    private Menu mainMenu;
    private ConsoleMenu consoleMenu;

    public Main(Scanner scanner, Menu mainMenu, ConsoleMenu consoleMenu) {
        this.scanner = scanner;
        this.mainMenu = mainMenu;
        this.consoleMenu = consoleMenu;
    }

    private void run() {
        try {
            this.consoleMenu.displayMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Menu mainMenu = new Menu();
        Scanner scanner = new Scanner(System.in);
        DealCards dealCards = new DealCards();
        Guess guess = new Guess(scanner);
        Logic logic = new Logic(scanner, dealCards, guess);
        GameMain gameMain = new GameMain(scanner, logic);
        ConsoleMenu consoleMenu = new ConsoleMenu(scanner, gameMain);
        Main main = new Main(scanner, mainMenu, consoleMenu);
        main.run();
    }
    
}
