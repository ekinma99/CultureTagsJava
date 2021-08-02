package com.culturetagsjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class to represent a deck of cards
 */
public class CardDeck {

    /**
     * The cards in the deck
     */
    private List<Card> cardsList;

    /**
     * The cards that were newly added
     */
    private List<Card> addedCards;

    /**
     * The map of each phrase to its category
     */
    private Map<String, String> phraseCategoryMap;

    /**
     * A flag to remember if any cards were removed
     */
    private boolean removedFlag;

    CardDeck() {
        cardsList = new ArrayList<>();
        addedCards = new ArrayList<>();
        phraseCategoryMap = new HashMap<>();
        removedFlag = false;
    }

    /**
     * Adds a card if it is not already in the deck
     * 
     * @param card The card to add
     */
    void addCard(Card card) {
        // add the card to the map only if its not in the map
        if (phraseCategoryMap.putIfAbsent(card.getPhrase(), card.getCategory()) == null) {
            // also keep track of it in the list
            addedCards.add(card);
        } else {
            // card already exists
        }
    }

    /**
     * Removes a cards from the card deck
     * 
     * @param card The card to remove
     */
    void removeCard(Card card) {
        // check if the card actually exists in the deck
        if (phraseCategoryMap.containsKey(card.getPhrase())) {
            // remove the card from the list and map, and note that
            // there has been a card removed from the deck (see exportCards)
            cardsList.remove(card);
            phraseCategoryMap.remove(card.getPhrase());
            removedFlag = true;
        }
    }

    /**
     * Reads the cards from a file and loads them into the list and map
     * 
     * @param filename
     */
    void loadCards(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader br = new BufferedReader(fileReader);

            // Read the next two lines (phrase and description)
            String phrase = br.readLine();
            String category = br.readLine();

            while (phrase != null) {

                // make a new card out of each two lines (phrase and category)
                // and put it in the map

                cardsList.add(new Card(phrase, category));
                phraseCategoryMap.put(phrase, category);

                // Get the next two lines
                phrase = br.readLine();
                category = br.readLine();
            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the file so that it has all the new cards and doesn't have the
     * removed ones
     * 
     * @param filename Which file to write the cards to
     */
    void exportCards(String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            if (!removedFlag) {
                // if we didnt remove anything, just write the added cards
                for (Card card : addedCards) {
                    bw.write(String.format("%s\n%s\n", card.getPhrase(), card.getCategory()));
                }
            } else {
                // re-create the file writer to overwrite the file, so that
                // we exclude the removed cards
                bw.close();
                fileWriter = new FileWriter(filename, false);
                bw = new BufferedWriter(fileWriter);
                for (String phrase : phraseCategoryMap.keySet()) {
                    String category = phraseCategoryMap.get(phrase);
                    bw.write(String.format("%s\n%s\n", phrase, category));
                }
            }

            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String filename = "input.txt";

        // Load pre-made cards from a file
        CardDeck dealer = new CardDeck();
        dealer.loadCards(filename);

        // Make a new empty CardDealer
        dealer = new CardDeck();

        // Add some cards
        dealer.addCard(new Card("card A", "description of card A."));
        dealer.addCard(new Card("card B", "description of card B."));
        dealer.addCard(new Card("card C", "description of card C."));
        dealer.addCard(new Card("card D", "description of card D."));

        // Export these new Cards to a file; TO-DO: will need to remove this later
        dealer.exportCards("input2.txt");

    }

}
