package com.culturetagsjava;

import java.util.Scanner;

public class Guess {

    private Scanner scanner;

    public Guess(Scanner scanner) {
        this.scanner = scanner;
    }

    public String myGuess() {
        return scanner.nextLine();
    }

}
