package com.culturetagsjava;

import java.util.ArrayList;
import java.util.Scanner;

public class GameMain {

    private Scanner scanner;
    private Logic logic;

    public GameMain(Scanner scanner, Logic logic) {
        this.scanner = scanner;
        this.logic = logic;
    }

    private Team addPlayer(String team) {
        this.logic.textPlayers(team);
        int amountOfPlayers = this.scanner.nextInt();
        Team t = new Team(amountOfPlayers);
        System.out.println("Enter players name");
        String playersName = this.scanner.nextLine();
        this.logic.addPlayer(playersName, t, amountOfPlayers);
        return t;
    }

    public void run() {
        ArrayList<Team> teams = new ArrayList<>();
        // Adding players Team A and B
        for (String team : new String[] { "A", "B" }) {
            Team t = addPlayer(team);
            // getting both team players printed
            t.printPlayers();
            teams.add(t);
        }

        System.out.println("________________________________________________");

        // checking that teams are even regardless the amount of space in memory
        // if not even the progam ends
        Team tA = teams.get(0);
        Team tB = teams.get(1);
        boolean equalSizes = this.logic.compareAmountOfMembers(tA, tB);
        if (!equalSizes) {
            System.exit(0);
        }

        // who start guessing, the team with biggest number start choosing
        System.out.println("________________________________________________");
        int b = tA.startGuessing();
        int c = tB.startGuessing();
        this.logic.biggerNumberStart(b, c);

        // card with the letters and hint is assingned
        // the other team start guessing each =one have one opportunity
        System.out.println("________________________________________________");
        String playerA = tA.AssignCardsPlayer1(0); // previously was 1
        this.logic.assignCardsToLetters(b, c, playerA, tA, tA.getTeamSize());
        String playerB = tB.AssignCardsPlayer1(0);
        this.logic.assignCardsToLetters(b, c, playerB, tB, tB.getTeamSize());

        this.scanner.close();
    }

}
