package core.components;

import core.components.factories.CardFactory;

import static org.junit.Assert.*;

public class CardTest {

    @org.junit.Test
    public void testToString() {
        Card card = new Vmax();
        int id = 1;
        String result = "Card{" + "id=" + id + '}';

        assertEquals(result, card.toString());
    }

    @org.junit.Test
    public void testEquals() {
        Card card1 = new Vlibre();
        Card card2 = new Vmax();

        assertNotEquals(card1, card2);
    }

    @org.junit.Test
    public void testHashCode() {
        Card card1 = new Vlibre();
        Card card2 = new Vmax();

        assertNotEquals(card1.hashCode(), card2.hashCode());
    }
}