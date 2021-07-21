/**
 * Cards from https://www.thoughtco.com/common-english-idioms-3211646
 */

import java.io.*;
import java.util.*;

class Card {
    private String phrase;
    private String description;
    public Card(String phrase, String description) {
        this.phrase = phrase;
        this.description = description;
    }
    public String getPhrase() {
        return phrase;
    }
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

/**
 * A class to represent a deck of cards
 */
class CardDeck {

    /**
     * The cards in the deck
     */
    private List<Card> cards;

    /**
     * The cards that were newly added
     */
    private List<Card> addedCards;

    /**
     * The map of each phrase to its description
     */
    private Map<String, String> phraseDescriptionMap;

    /**
     * A flag to remember if any cards were removed
     */
    private boolean removedFlag;

    CardDeck() {
        cards = new ArrayList<>();
        addedCards = new ArrayList<>();
        phraseDescriptionMap = new HashMap<>();
        removedFlag = false;
    }

    /**
     * Adds a card if it is not already in the deck
     * @param card The card to add
     */
    void addCard(Card card) {
        // add the card to the map only if its not in the map
        if (phraseDescriptionMap.putIfAbsent(card.getPhrase(), card.getDescription()) == null) {
            // also keep track of it in the list
            addedCards.add(card);
        } else {
            // card already exists
        }
    }
    
    /**
     * Removes a cards from the card deck
     * @param card The card to remove
     */
    void removeCard(Card card) {
        // check if the card actually exists in the deck
        if (phraseDescriptionMap.containsKey(card.getPhrase())) {
            // remove the card from the list and map, and note that
            // there has been a card removed from the deck (see exportCards)
            cards.remove(card);
            phraseDescriptionMap.remove(card.getPhrase());
            removedFlag = true;
        }
    }

    /**
     * Reads the cards from a file and loads them into the list
     * and map
     * @param filename
     */
    void loadCards(String filename) {
        try {
            File inputFile = new File(filename);
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fileReader);

            // Get the next two lines (phrase and description)
            String phrase = br.readLine();
            String description = br.readLine();
            
            while (phrase != null) {

                // make a new card out of each two lines (phrase and description)
                // and put it in the map

                cards.add(new Card(phrase, description));
                phraseDescriptionMap.put(phrase, description);

                // Get the next two lines
                phrase = br.readLine();
                description = br.readLine();
            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the file so that it has all the new cards and doesn't
     * have the removed ones
     * @param filename Which file to write the cards to
    */
    void exportCards(String filename) {
        try {
            File inputFile = new File(filename);
            FileWriter fileWriter = new FileWriter(inputFile);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            if (!removedFlag) {
                // if we didnt remove anything, just write the added cards
                for (Card card : addedCards) {
                    bw.write(String.format("%s\n%s\n", card.getPhrase(), card.getDescription()));
                }
            } else {
                // re-create the file writer to overwrite the file, so that
                // we exclude the removed cards
                bw.close();
                fileWriter = new FileWriter(inputFile, false);
                bw = new BufferedWriter(fileWriter);
                for (String phrase : phraseDescriptionMap.keySet()) {
                    String description = phraseDescriptionMap.get(phrase);
                    bw.write(String.format("%s\n%s\n", phrase, description));
                }
            }

            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

public class Main {

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

        // Export these new Cards to a file
        dealer.exportCards("input2.txt");

    }
}