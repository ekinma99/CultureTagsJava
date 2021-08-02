package com.culturetagsjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TeamA implements TeamsFeatures {
    String[] team;
    int counter;
    DealCards dealCards = new DealCards();
    ArrayList c = dealCards.cards();

    //Setting amount of players in team in dynamic array
    public TeamA(int amountOfPlayers) {
        team = new String[amountOfPlayers];
    }

    //Adding players to Array, if Array is filled it automatically generates more space in memory
    public void addPlayer(String newPlayer) {
        if (team.length == counter) {
            String[] teamResize = new String[counter * 2];
            for (int i = 0; i < counter; i++)
                teamResize[i] = team[i];
            team = teamResize;
        }
        team[counter++] = newPlayer;
    }

    //printing all players if needed
    @Override
    public void getPlayers() {
        for (int i = 0; i < counter; i++) {
        }
        System.out.println(Arrays.toString(team));
    }
    @Override
    public String playerTurn(int position){
        for (int i = 0; i < counter; i++) {
        }
        return team[position];
    }

    // Assign cards to players
    @Override
    public String AssignCardsPlayer1(int position) {
        for (int i = 0; i < counter; i++) {
        }
            return team[position];
    }

    // Assigned card
    @Override
    public String assignedCard(){
        String x = (String) c.get(0);
        return x;
    }

    @Override
    //Checking amount of players and compare to the other team. both should be equal
    public int amountOfPlayers() {
        int x = 0;
        for (int i = 0; i < counter; i++) {
            if (team[i] == null)
                break;
                x = i;
        }
        return x+1;
    }

    //team with biggest number start guessing
    @Override
    public int startGuessing(){
        Random rand = new Random();
        int number = rand.nextInt(10);
        return number;
    }
}
