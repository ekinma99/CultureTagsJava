package com.culturetagsjava;

import java.util.Scanner;

public class Main {

    private ConsoleMenu consoleMenu;

    public Main(ConsoleMenu consoleMenu) {
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
        Scanner scanner = new Scanner(System.in);
        DealCards dealCards = new DealCards();
        Guess guess = new Guess(scanner);
        Logic logic = new Logic(scanner, dealCards, guess);
        GameMain gameMain = new GameMain(scanner, logic);
        Menu mainMenu = new Menu();
        ConsoleMenu consoleMenu = new ConsoleMenu(scanner, mainMenu, gameMain);
        Main main = new Main(consoleMenu);
        main.run();
    }
    
}
