package core.components.factories;

import core.components.Manager;
import core.components.User;
import core.system.MyVelibSystem;
import java.util.List;

import java.awt.*;

public class UserFactory {

    public void addUser(MyVelibSystem system, String name, Point coordinate, int creditCardNumber, double money) {
        User user = new User(name, coordinate, creditCardNumber, money);
        List<User> users = system.getUsers();
        users.add(user);
        system.setUsers(users);
    }

    public void addUser(MyVelibSystem system, String name, int creditCardNumber) {
        User user = new User(name, new Point(0, 0), creditCardNumber, 0);
        List<User> users = system.getUsers();
        users.add(user);
        system.setUsers(users);
    }

    public void addManager(MyVelibSystem system, String name, Point coordinate, int creditCardNumber, double money) {
        Manager user = new Manager(name, coordinate, creditCardNumber, money);
        List<User> users = system.getUsers();
        users.add(user);
        system.setUsers(users);
    }

    public void addManager(MyVelibSystem system, String name, int creditCardNumber) {
        Manager user = new Manager(name, new Point(0, 0), creditCardNumber, 0);
        List<User> users = system.getUsers();
        users.add(user);
        system.setUsers(users);
    }


}


