package core.components;

import java.util.Objects;

public abstract class Card {
    private final int id = generateUniqueID();
    private static int numberOfCards = 0;


    private int generateUniqueID() {
        return ++numberOfCards;
    }

    public int getId() {
        return id;
    }

    public static int getNumberOfCards() {
        return numberOfCards;
    }




    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
