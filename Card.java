package com.culturetagsjava;

public class Card {
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
