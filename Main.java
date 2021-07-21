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

class CardDealer {

    private List<Card> cards;
    private List<Card> addedCards;
    private Map<String, String> phraseDescriptionMap;
    private boolean removedFlag;

    CardDealer() {
        cards = new ArrayList<>();
        addedCards = new ArrayList<>();
        phraseDescriptionMap = new HashMap<>();
        removedFlag = false;
    }

    void addCard(Card card) {
        if (phraseDescriptionMap.putIfAbsent(card.getPhrase(), card.getDescription()) == null) {
            addedCards.add(card);
        } else {
            // card already exists
        }
    }
    
    void removeCard(Card card) {
        if (phraseDescriptionMap.containsKey(card.getPhrase())) {
            cards.remove(card);
            phraseDescriptionMap.remove(card.getPhrase());
            removedFlag = true;
        }
    }

    void loadCards(String filename) {
        try {
            File inputFile = new File(filename);
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fileReader);

            // Get the next two lines (phrase and description)
            String phrase = br.readLine();
            String description = br.readLine();
            
            while (phrase != null) {

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
        
        CardDealer dealer = new CardDealer();
        dealer.loadCards(filename);
        
        
        dealer = new CardDealer();

        dealer.addCard(new Card("card A", "description of card A."));
        dealer.addCard(new Card("card B", "description of card B."));
        dealer.addCard(new Card("card C", "description of card C."));
        dealer.addCard(new Card("card D", "description of card D."));

        dealer.exportCards("input2.txt");

    }
}