package core.components.factories;

import core.components.Card;
import core.components.Manager;
import core.components.User;
import core.system.MyVelibSystem;

import java.util.List;

import java.awt.*;

/**
 * The UserFactory class : This is the factory to create and add new users. We will always add users to a given system
 * It is uses the simple factory design pattern
 */
public class UserFactory {

    /**
     * This method is responsible for adding a (new) user to a system with some initial information.
     * @param system the system that the user is requesting to be inserted in
     * @param name the name of the new user
     * @param coordinate the (initial) coordinate of the user
     * @param creditCardNumber the credit card number of the new user
     * @param money the (initial) money of the user in the application
     * @return the User instance
     */
    public static User addUser(MyVelibSystem system, String name, Point coordinate, int creditCardNumber, double money) {
        User user = new User(name, coordinate, creditCardNumber, money);
        List<User> users = system.getUsers();
        users.add(user);
        system.setUsers(users);
        return user;
    }

    /**
     * This method is responsible for adding a (new) user to a system with some initial information. It can be simpler in some cases.
     * @param system the system that the user is requesting to be inserted in
     * @param name the name of the new user
     * @param creditCardNumber the credit card number of the new user
     * @return the User instance
     */
    public static User addUser(MyVelibSystem system, String name, int creditCardNumber) {
        User user = new User(name, new Point(0, 0), creditCardNumber, 0);
        List<User> users = system.getUsers();
        users.add(user);
        system.setUsers(users);
        return user;
    }


    /**
     * This method is responsible for adding a (new) manager to a system with some initial information.
     * @param system the system that the user is requesting to be inserted in
     * @param name the name of the new user
     * @param coordinate the (initial) coordinate of the manager
     * @param creditCardNumber the credit card number of the new user
     * @param money the (initial) money of the user in the application
     * @return the Manager instance
     */
    public static Manager addManager(MyVelibSystem system, String name, Point coordinate, int creditCardNumber, double money) {
        Manager user = new Manager(name, coordinate, creditCardNumber, money);
        List<User> users = system.getUsers();
        users.add(user);
        system.setUsers(users);
        return user;
    }

    /**
     * This method is responsible for adding a (new) manager to a system with some initial information. It can be simpler in some cases.
     * @param system the system that the user is requesting to be inserted in
     * @param name the name of the new user
     * @param creditCardNumber the credit card number of the new manager
     * @return the Manager instance
     */
    public static Manager addManager(MyVelibSystem system, String name, int creditCardNumber) {
        Manager user = new Manager(name, new Point(0, 0), creditCardNumber, 0);
        List<User> users = system.getUsers();
        users.add(user);
        system.setUsers(users);
        return user;
    }


}


