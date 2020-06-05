package core.components;

import core.components.factories.CardFactory;

import static org.junit.Assert.*;

/**
 * Testing Card Class
 */
public class CardTest {

    /**
     * Testing toString method
     */
    @org.junit.Test
    public void testToString() {
        Card card = new Vmax();
        int id = card.getId();
        String result = "Card{" + "id=" + id + '}';

        assertEquals(result, card.toString());
    }

    /**
     * Testing equals method
     */
    @org.junit.Test
    public void testEquals() {
        Card card1 = new Vlibre();
        Card card2 = new Vmax();

        assertNotEquals(card1, card2);
    }

    /**
     * Testing hashcode method
     */
    @org.junit.Test
    public void testHashCode() {
        Card card1 = new Vlibre();
        Card card2 = new Vmax();

        assertNotEquals(card1.hashCode(), card2.hashCode());
    }
}