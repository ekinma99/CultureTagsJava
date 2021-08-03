package com.culturetagsjava;

public interface TeamsFeatures {
     void getPlayers();

     String AssignCardsPlayer1(int position);

     String assignedCard();

     String playerTurn(int position);

     int amountOfPlayers();

     int startGuessing();
}
