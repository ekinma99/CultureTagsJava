package com.culturetagsjava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
            //new GUI();
        Scanner sc = new Scanner(System.in);
       Logic logic = new Logic();


         //Adding players Team  A and B
        logic.textPlayersA();
        int amountOfPlayersA = sc.nextInt();
        int amountA = logic.amountOfPlayersA(amountOfPlayersA);
        TeamA tA = new TeamA(amountA);
        logic.enterPlayerName();
        String playersNameA = sc.nextLine();
        logic.addPlayerA(playersNameA,tA, amountOfPlayersA);
        //////////////////////////////////
        logic.textPlayersB();
        int amountOfPlayersB = sc.nextInt();
        int amountB = logic.amountOfPlayersB(amountOfPlayersB);
        TeamB tB = new TeamB(amountB);
        logic.enterPlayerName();
        String playersNameB = sc.nextLine();
        logic.addPlayerB(playersNameB,tB, amountOfPlayersB);

        //getting both team players printed
        tA.getPlayers();
        tB.getPlayers();
        System.out.println("________________________________________________");

        // checking that teams  are even regardless the amount of space in memory
        //if not even the progam ends
        int totalPlayersA = tA.amountOfPlayers();
        int totalPlayersB = tB.amountOfPlayers();
        logic.compareAmountOfmembers(totalPlayersA, totalPlayersB);

        //who start guessing, the team with biggest number start choosing
        System.out.println("________________________________________________");
        int b = tA.startGuessing();
        int c = tB.startGuessing();
        logic.biggerNumberStart(b, c);

        // card with the letters and hint is assingned
        // the other team start guessing each =one have one opportunity
        System.out.println("________________________________________________");
        String playerA = tA.AssingCardsPlayer1(1);
        logic.assignCardsToLettersA(b, c, playerA, tA, amountOfPlayersA);
        String playerB = tB.AssingCardsPlayer1(1);
        logic.assignCardsToLettersB(b, c, playerB, tB, amountOfPlayersB);
    }
}
