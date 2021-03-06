package core.components.factories;

import core.components.User;
import core.components.Vlibre;
import core.components.Vmax;
import core.system.MyVelibSystem;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Testing the card factory class
 */
public class CardFactoryTest {

    /**
     * Testing the creation of Vmax card
     */
    @Test
    public void addVmax() {
        MyVelibSystem system = new MyVelibSystem();
        User user = new User("Matheus", new Point(0, 0), 0000, 0);
        // Adding user to system
        system.getUsers().add(user);
        // Adding card
        CardFactory.addVmax(system, user);
        Vmax card = new Vmax();

        assertEquals(card.getClass(), user.getCard().getClass());

    }

    /**
     * Testing the creation of Vlibre
     */
    @Test
    public void addVlibre() {
        MyVelibSystem system = new MyVelibSystem();
        User user = new User("Matheus", new Point(0, 0), 0000, 0);
        // Adding user to system
        system.getUsers().add(user);
        // Adding card
        CardFactory.addVlibre(system, user);
        Vlibre card = new Vlibre();

        assertEquals(card.getClass(), user.getCard().getClass());
    }
}