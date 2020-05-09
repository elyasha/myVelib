package core.components;

public abstract class Card {
    private final int id = generateUniqueID();
    private static int numberOfCards = 0;

    public Card() {

    }
    
    private int generateUniqueID() {
        return ++numberOfCards;
    }
    


}
