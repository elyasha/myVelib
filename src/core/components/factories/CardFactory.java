package core.components.factories;

import core.components.*;
import core.system.MyVelibSystem;

import java.awt.*;
import java.util.List;

/**
 * The CardFactory class : This is the factory to create and add new cards to users
 * It is uses the simple factory design pattern
 */
public class CardFactory {

    /**
     * This method is responsible to add a new Vmax card to a user
     * @param system the system in which the user is supposed to be in
     * @param user the supposed user that we want to add a new Vmax card (he may not be on the system)
     */
    public static void addVmax(MyVelibSystem system, User user) {
        // Check if the user is on the system and has no card
        if (system.getUsers().contains(user) && user.getCard() == null) {
            // Add the Vmax card to user
            Card vmax = new Vmax();
            user.setCard(vmax);

        } else {
            System.out.println("User is not in the system or has already a card!");
        }
    }

    /**
     * This method is responsible to add a new Vlibre card to a user
     * @param system the system in which the user is supposed to be in
     * @param user the supposed user that we want to add a new Vlibre card (he may not be on the system)
     */
    public static void addVlibre(MyVelibSystem system, User user) {
        // Check if the user is on the system and has no card
        if (system.getUsers().contains(user) && user.getCard() == null) {
            // Add the Vlibre card to user
            Card vlibre = new Vlibre();
            user.setCard(vlibre);

        } else {
            System.out.println("User is not in the system or has already a card!");
        }
    }
}
