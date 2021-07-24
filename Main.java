/**
 * Cards from https://www.thoughtco.com/common-english-idioms-3211646
 */

<<<<<<< HEAD
import java.io.*;
import java.util.*;

class Card {
    /* A card needs to have:
    * Phrase
    * Category */ 
     
    private String phrase;
    private String category;
    public Card(String phrase, String category) {
        this.phrase = phrase;
        this.category = category;
    }
    public String getPhrase() {
        return phrase;
    }
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
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
    private Map<String, String> phraseCategoryMap;
    
    // A var for storing the acronym
    // A map for storing the phrase & category

    /**
     * A flag to remember if any cards were removed
     */
    private boolean removedFlag;

    CardDeck() {
        cards = new ArrayList<>();
        addedCards = new ArrayList<>();
        phraseCategoryMap = new HashMap<>();
        removedFlag = false;
    }

    /**
     * Adds a card if it is not already in the deck
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
     * @param card The card to remove
     */
    void removeCard(Card card) {
        // check if the card actually exists in the deck
        if (phraseCategoryMap.containsKey(card.getPhrase()) || phraseCategoryMap.containsValue(card.getCategory()) {
            // remove the card from the list and map, and note that
            // there has been a card removed from the deck (see exportCards)
            cards.remove(card);
            phraseCategoryMap.remove(card.getPhrase());
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
            File inputFile = new File(filename); // creates variable of the file 
            FileReader fileReader = new FileReader(inputFile); // the var created the line before is the parameter 
            BufferedReader br = new BufferedReader(fileReader); 

            // Get the next two lines (phrase and category)
            String phrase = br.readLine(); //reads phrase
            String category = br.readLine(); // reads category
            
            while (phrase != null) {

                // make a new card out of each two lines (phrase and category)
                // and put it in the map

                cards.add(new Card(phrase, category)); // create a card
                phraseCategoryMap.put(phrase, category); //inputs it as map

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
     * Updates the file so that it has all the new cards and doesn't
     * have the removed ones
     * @param filename Which file to write the cards to
    */
    void exportCards(String filename) {
        try {
            File inputFile = new File(filename); // The user chooses the file
            FileWriter fileWriter = new FileWriter(inputFile);
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
                fileWriter = new FileWriter(inputFile, false);
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

}

=======
>>>>>>> 5b96f5eb1ac44d57930865844bcf7ea861016541
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

        // Export these new Cards to a file; TO-DO: will need to remove this later
        dealer.exportCards("input2.txt");

    }
}