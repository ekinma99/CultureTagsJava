package com.culturetagsjava;

import java.util.Scanner;

public class Guess {
// may have to look back at this
    private Scanner scanner;

    public Guess(Scanner scanner) {
        this.scanner = scanner;
    }

    public String myGuess() {
        return scanner.nextLine();
    }

}
