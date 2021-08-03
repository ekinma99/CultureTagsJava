package com.culturetagsjava;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private Scanner scanner;
    private Logic logic;

    public Main(Scanner scanner, Logic logic) {
        this.scanner = scanner;
        this.logic = logic;
    }

    private Team addPlayer(String team) {
        this.logic.textPlayers(team);
        int amountOfPlayers = this.scanner.nextInt();
        Team t = new Team(amountOfPlayers);
        System.out.println("enter players name");
        String playersName = this.scanner.nextLine();
        this.logic.addPlayer(playersName, t, amountOfPlayers);
        return t;
    }

    private void run() {
        try {
            ArrayList<Team> teams = new ArrayList<>();
            // Adding players Team A and B
            for (String team : new String[] { "A", "B" }) {
                Team t = addPlayer(team);
                // getting both team players printed
                t.getPlayers();
                teams.add(t);
            }

            System.out.println("________________________________________________");

            // checking that teams are even regardless the amount of space in memory
            // if not even the progam ends
            Team tA = teams.get(0);
            Team tB = teams.get(1);
            this.logic.compareAmountOfMembers(tA, tB);

            // who start guessing, the team with biggest number start choosing
            System.out.println("________________________________________________");
            int b = tA.startGuessing();
            int c = tB.startGuessing();
            this.logic.biggerNumberStart(b, c);

            // card with the letters and hint is assingned
            // the other team start guessing each =one have one opportunity
            System.out.println("________________________________________________");
            String playerA = tA.AssignCardsPlayer1(1);
            this.logic.assignCardsToLetters(b, c, playerA, tA, tA.__getTeam().length);
            String playerB = tB.AssignCardsPlayer1(1);
            this.logic.assignCardsToLetters(b, c, playerB, tB, tB.__getTeam().length);

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();

        Main main = new Main(scanner, logic);
        main.run();

    }
}
