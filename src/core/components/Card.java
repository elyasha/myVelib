package core.components;

public abstract class Card {
    private final int id = generateUniqueID();
    private static int numberOfCards = 0;


    private int generateUniqueID() {
        return ++numberOfCards;
    }


}
