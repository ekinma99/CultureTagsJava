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

    public void textPlayersA() {
        System.out.println("enter amount of players for team A");
    }

    public void textPlayersB() {
        System.out.println("enter amount of players for team B");
    }

    public void enterPlayerName() {
        System.out.println("enter players name");
    }

    public int amountOfPlayersA(int players) {
        return players;
    }

    public int amountOfPlayersB(int players) {
        return players;
    }

    public void compareAmountOfmembers(int x, int y) {
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

    public void addPlayerA(String player, TeamA tA, int amountOfpPlayers) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        do {
            System.out.println("insert players");
            player = sc.nextLine();
            tA.addPlayer(player);
            count++;
        } while (count < amountOfpPlayers);

    }

    public void addPlayerB(String player, TeamB tB, int amountOfpPlayers) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        do {
            System.out.println("insert players");
            player = sc.nextLine();
            tB.addPlayer(player);
            count++;
        } while (count < amountOfpPlayers);

    }

    public void assignCardsToLettersA(int b, int c, String playerA, TeamA tA, int amountOfPlayersA)
            throws InterruptedException {
        int counter = 0;
        String hint = "";
        if (b > c) {
            playerA = tA.AssignCardsPlayer1(1);
            String assignedCard = tA.assignedCard();
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
            System.out.println("playerA is\t" + playerA);
            System.out.println("assigned card is\t" + tA.assignedCard());
            System.out.println("hint: " + hint);
            System.out.println("________________________________________________");
            String finalAssignedCard = assignedCard;
            algoA(counter, amountOfPlayersA, tA, finalAssignedCard);
        }
    }

    public void assignCardsToLettersB(int b, int c, String playerB, TeamB tB, int amountOfPlayersB) {
        int counter = 0;
        String hint = "";
        if (b < c) {
            playerB = tB.AssignCardsPlayer1(1);
            String assignedCard = tB.assignedCard();
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
            System.out.println("playerB is\t" + playerB);
            System.out.println("assigned card is\t" + tB.assignedCard());
            System.out.println("hint: " + hint);
            System.out.println("________________________________________________");

            algoB(counter, amountOfPlayersB, tB, assignedCard);
        }
    }

    public void algoA(int counter, int amountOfPlayersA, TeamA tA, String assignedCard) {
        if (counter < amountOfPlayersA) {
            String playerName = tA.playerTurn(counter);
            System.out.println(playerName + "\tIts Guessing");
            System.out.println("enter your word");
            String word = guess.myScanner();
            String myWord = guess.myGuess(word);
            if (myWord.equals(assignedCard)) {
                System.out.println("you won team A");
                System.exit(0);
            }
            if (myWord != assignedCard) {
                System.out.println("Next Player A");
                counter++;
                algoA(counter, amountOfPlayersA, tA, assignedCard);
            }
        }
    }

    public void algoB(int counter, int amountOfPlayersB, TeamB tB, String assignedCard) {
        if (counter < amountOfPlayersB) {
            String playerName = tB.playerTurn(counter);
            System.out.println(playerName + "\tIts Guessing");
            System.out.println("enter your word");
            String word = guess.myScanner();
            String myWord = guess.myGuess(word);
            if (myWord.equals(assignedCard)) {
                System.out.println("you won team B");
                System.exit(0);
            }
            if (myWord != assignedCard) {
                System.out.println("Next Player B");
                counter++;
                algoB(counter, amountOfPlayersB, tB, assignedCard);
            }
        }
    }

}
