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
        String cardDeckFilename = "map.txt";
        Scanner scanner = new Scanner(System.in);
        CardDeck cardDeck = new CardDeck();
        cardDeck.loadCards(cardDeckFilename);
        DealCards dealCards = new DealCards(cardDeck);
        Guess guess = new Guess(scanner);
        Logic logic = new Logic(scanner, dealCards, guess);
        GameMain gameMain = new GameMain(scanner, logic);
        Menu mainMenu = new Menu();
        ConsoleMenu consoleMenu = new ConsoleMenu(scanner, mainMenu, gameMain);
        Main main = new Main(consoleMenu);
        main.run();
    }
    
}
