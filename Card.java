public class Card {
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
