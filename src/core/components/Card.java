package core.components;

import java.util.Objects;

public abstract class Card {

    /**
     * id : the unique id that identifies the card
     */
    private final int id = generateUniqueID();


    /**
     * numberOfCards: the number of the cards that will exist in the myVelib system
     */
    private static int numberOfCards = 0;

    /**
     *
     * This methods generate an unique ID when we create a new object
     *
     * @return ++numberOfCards
     */
    private int generateUniqueID() {
        return ++numberOfCards;
    }

    /**
     *
     * id getter
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * numberOfCards getter
     *
     * @return
     */
    public static int getNumberOfCards() {
        return numberOfCards;
    }


    /**
     *
     * toString method of the Card class
     *
     * @return : a standard class toString
     */
    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                '}';
    }

    /**
     *
     * equals method of the Card class
     *
     *
     * @param o : an object o
     * @return : id == card.id
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id;
    }

    /**
     *
     * hashCode method of the Card class
     * we compare with respect to the id
     *
     * @return hash(id)
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
