package com.culturetagsjava;

import java.util.Scanner;

public class Logic {
    private Scanner scanner;
    private DealCards cardMeaning;
    private Guess guess;

    private String wth = cardMeaning.wth();
    private String lalaland = cardMeaning.lalaland();
    private String mma = cardMeaning.mma();
    private String ww2 = cardMeaning.ww2();
    private String rt = cardMeaning.rt();
    private String ftp = cardMeaning.ftp();

    public Logic(Scanner scanner, DealCards dealCards, Guess guess) {
        this.scanner = scanner;
        this.cardMeaning = dealCards;
        this.guess = guess;
    }

    public void textPlayers(String team) {
        if (!team.equals("A") || !team.equals("B")) {
            return;
        } else {
            System.out.println("enter amount of players for team " + team);
        }
    }

    public boolean compareAmountOfMembers(Team tA, Team tB) {
        if (tA.amountOfPlayers() != tB.amountOfPlayers()) {
            System.out.println("teams are not even");
            System.out.println("add more players");
        } else {
            System.out.println("Team A has\t" + tA.amountOfPlayers() + "\tmembers");
            System.out.println("Team B has\t" + tB.amountOfPlayers() + "\tmembers");
        }
        return tA.amountOfPlayers() != tB.amountOfPlayers();
    }

    public void biggerNumberStart(int x, int y) {
        String winnerNumber = (x > y) ? "highest number is\t" + x : "highest number is\t" + y;
        System.out.println(winnerNumber);
    }

    public void addPlayer(String player, Team team, int amountOfPlayers) {
        int count = 0;
        do {
            System.out.println("insert players");
            player = this.scanner.nextLine();
            team.addPlayer(player);
            count++;
        } while (count < amountOfPlayers);
    }

    public void assignCardsToLetters(int b, int c, String player, Team t, int amountOfPlayers) {
        int counter = 0;
        String hint = "";
        if (b < c) {
            player = t.AssignCardsPlayer1(1);
            String assignedCard = t.assignedCard();
            if (assignedCard.contains("WW2")) {
                assignedCard = ww2;
                hint = "war";
            }
            if (assignedCard.contains("MMA")) {
                assignedCard = mma;
                hint = "fight";
            }
            if (assignedCard == "LALALAND") {
                assignedCard = lalaland;
                hint = "movie";
            }
            if (assignedCard == "RT") {
                assignedCard = rt;
                hint = "broadcasting";
            }
            if (assignedCard == "WTH") {
                assignedCard = wth;
                hint = "slang";
            }
            if (assignedCard == "FTP") {
                assignedCard = ftp;
                hint = "networking";
            }
            // System.out.println("playerB is\t" + player); // TODO: who is playerB?
            System.out.println("player is\t" + player);
            System.out.println("assigned card is\t" + t.assignedCard());
            System.out.println("hint: " + hint);
            System.out.println("________________________________________________");

            algo(counter, amountOfPlayers, t, assignedCard);
        }
    }

    public void algo(int counter, int amountOfPlayers, Team t, String assignedCard) {
        if (counter < amountOfPlayers) {
            String playerName = t.playerTurn(counter);
            System.out.println(playerName + "\tIts Guessing");
            System.out.println("enter your word");
            String word = guess.myGuess();
            String myWord = word;
            if (myWord.equals(assignedCard)) {
                System.out.println("you won team " + t.getTeamName());
                System.exit(0);
            }
            if (myWord != assignedCard) {
                System.out.println("Next Player " + t.getTeamName());
                counter++;
                algo(counter, amountOfPlayers, t, assignedCard);
            }
        }
    }

}
