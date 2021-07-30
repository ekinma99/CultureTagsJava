package com.culturetagsjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TeamB implements TeamsFeatures {
    String[] team;
    int counter;
    DealCards dealCards = new DealCards();
    ArrayList c = dealCards.cards();

    public TeamB(int amountOfPlayers) {
        team = new String[amountOfPlayers];
    }
    public void addPlayer(String newPlayer){
        if(team.length==counter){
            String[] teamResize = new String[counter*2];
            for (int i = 0; i < counter; i++)
                teamResize[i] = team[i];
            team = teamResize;
        }
        team[counter++]=newPlayer;
    }

    @Override
    public void getPlayers() {
        for (int i = 0; i < counter; i++) {
        }System.out.println(Arrays.toString(team));
    }

    @Override
    public String AssingCardsPlayer1(int position) {
        for (int i = 0; i < counter; i++) {
        }
        return team[position];
    }
    @Override
    public String assignedCard(){
        String x = (String) c.get(0);
        return x;
    }

    @Override
    public String playerTurn(int position) {
        for (int i = 0; i < counter; i++) {
        }
        return team[position];
    }

    @Override
    public int amountOfPlayers() {
        int x = 0;
        for (int i = 0; i < counter; i++) {
            if (team[i] == null)
                break;
            x = i;
        }
        return x+1;
    }

    @Override
    public int startGuessing() {
        Random rand = new Random();
        int number = rand.nextInt(10);
        return number;
    }
}
