package core.components;

public abstract class Card {
    private final int id;
    private static int numberOfCards = 0;

    public Card() {
    	this.id = generateUniqueID();
    }
    
    private int generateUniqueID() {
        return ++numberOfCards;
    }
    


}
