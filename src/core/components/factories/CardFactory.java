package core.components.factories;

import core.components.*;
import core.system.MyVelibSystem;

import java.awt.*;
import java.util.List;

public class CardFactory {

    public void addVmax(MyVelibSystem system, User user) {
        List<User> users = system.getUsers();

        // Check if the user is on the system and has no card
        if (users.contains(user) && user.getCard() == null) {
            // Add the Vmax card to user
            Card vmax = new Vmax();
            user.setCard(vmax);

        } else {
            System.out.println("User is not in the system or has already a card!");
        }
    }

    public void addVlibre(MyVelibSystem system, User user) {
        List<User> users = system.getUsers();

        // Check if the user is on the system and has no card
        if (users.contains(user) && user.getCard() == null) {
            // Add the Vlibre card to user
            Card vlibre = new Vlibre();
            user.setCard(vlibre);

        } else {
            System.out.println("User is not in the system or has already a card!");
        }
    }
}
