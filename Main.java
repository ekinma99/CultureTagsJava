/**
 * Cards from https://www.thoughtco.com/common-english-idioms-3211646
 */

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