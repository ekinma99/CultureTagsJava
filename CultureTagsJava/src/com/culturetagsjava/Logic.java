package com.culturetagsjava;

import java.util.Scanner;

public class Logic {
    DealCards cardMeaning = new DealCards();
    Guess guess = new Guess();

    private String wth = cardMeaning.wth();
    String lalaland = cardMeaning.lalaland();
    String mma = cardMeaning.mma();
    String ww2 = cardMeaning.ww2();
    String rt = cardMeaning.rt();
    String ftp = cardMeaning.ftp();

    public void textPlayers(String team) {
        if (!team.equals("A") || !team.equals("B")) {
            return;
        } else {
            System.out.println("enter amount of players for team " + team);
        }
    }

    public void __textPlayersA() {
        System.out.println("enter amount of players for team A");
    }

    public void __textPlayersB() {
        System.out.println("enter amount of players for team B");
    }

    public void __enterPlayerName() {
        System.out.println("enter players name");
    }

    public int __amountOfPlayersA(int players) {
        return players;
    }

    public int __amountOfPlayersB(int players) {
        return players;
    }

    public void compareAmountOfMembers(Team tA, Team tB) {
        int totalPlayersA = tA.amountOfPlayers();
        int totalPlayersB = tB.amountOfPlayers();
        compareAmountOfMembers(totalPlayersA, totalPlayersB);
    }

    public void compareAmountOfMembers(int x, int y) {
        if (x != y) {
            System.out.println("teams are not even");
            System.out.println("add more players");
            System.exit(0);
        }
        System.out.println("Team A have\t" + x + "\tmembers");
        System.out.println("Team B have\t" + y + "\tmembers");
    }

    public void biggerNumberStart(int x, int y) {
        String winnerNumber = (x > y) ? "highest number is\t" + x : "highest number is\t" + y;
        System.out.println(winnerNumber);
    }

    public void addPlayer(String player, Team team, int amountOfPlayers) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        do {
            System.out.println("insert players");
            player = sc.nextLine();
            team.addPlayer(player);
            count++;
        } while (count < amountOfPlayers);
        sc.close();
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
            String word = guess.myScanner();
            String myWord = guess.myGuess(word);
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
