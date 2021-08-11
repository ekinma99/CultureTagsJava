package com.culturetagsjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Team implements TeamsFeatures {

    private String[] teamPlayers;
    private int counter;
    private DealCards dealCards;
    private ArrayList<String> c;
    private String teamName;
    private int teamSize;
    private static int numberOfInstances = 0;

    // Setting amount of players in team in dynamic array
    public Team(int amountOfPlayers) {
        this(amountOfPlayers, new DealCards());
    }
    public Team(int amountOfPlayers, DealCards dealCards) {
        Team.numberOfInstances++;
        this.teamPlayers = new String[amountOfPlayers];
        this.teamSize = 0;
        this.dealCards = dealCards;
        switch (Team.numberOfInstances) {
            case 1:
                this.teamName = "A";
                break;
            case 2:
                this.teamName = "B";
                break;
            default:
                this.teamName = "";
                break;
        }
    }

    // Adding players to Array, if Array is filled it automatically generates more
    // space in memory. Also, it will never need to resize because team sizes are
    // constant.
    public void addPlayer(String newPlayer) {
        this.teamPlayers[this.teamSize++] = newPlayer;
    }

    // printing all players if needed
    @Override
    public void printPlayers() {
        System.out.println(Arrays.toString(teamPlayers));
    }

    @Override
    public String getPlayer(int position) {
        return teamPlayers[position];
    }

    // Assigned card
    @Override
    public String assignedCard() {
        String x = (String) c.get(0);
        return x;
    }

    @Override
    // Checking amount of players and compare to the other team. both should be
    // equal
    public int amountOfPlayers() {
        int x = 0;
        for (int i = 0; i < counter; i++) {
            if (teamPlayers[i] == null)
                break;
            x = i;
        }
        return x + 1;
    }

    // team with biggest number start guessing
    @Override
    public int startGuessing() {
        Random rand = new Random();
        int number = rand.nextInt(10);
        return number;
    }

    
    // added

    public int getTeamSize() {
        return this.teamSize;
    }

    public String getTeamName() {
        return this.teamName;
    }
}
