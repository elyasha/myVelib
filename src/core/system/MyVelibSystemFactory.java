package core.system;

import core.CoreApp;
import core.components.Station;
import core.components.User;

import java.util.List;

/**
 * The MyVelibSystemFactory class : This class is responsible for creating the new system on the core.Main application (the application itself)
 * It is used to implement the Factory design pattern (but, here due to time and design constraints, we used the simple factory)
 */
public class MyVelibSystemFactory {

    /**
     * Method for creating a new system in the core main application
     *
     * @param stations a list of stations
     * @param users    a list of users
     * @param money    an amount of money for the (new) system
     * @return the system created
     */
    public static MyVelibSystem createMyVelibSystem(List<Station> stations, List<User> users, double money) {
        MyVelibSystem system = new MyVelibSystem(stations, users, money);
        CoreApp.addMyVelibSystem(system);
        return system;
    }

    /**
     * (Simpler) method for creating a new system in the core main application
     *
     * @return the system created
     */
    public static MyVelibSystem createMyVelibSystem() {
        MyVelibSystem system = new MyVelibSystem();
        CoreApp.addMyVelibSystem(system);
        return system;
    }

    /**
     * (Intermediate) method for creating a new system in the core main application
     *
     * @param stations a list of stations
     * @return the (new) system
     */
    public static MyVelibSystem createMyVelibSystem(List<Station> stations) {
        MyVelibSystem system = new MyVelibSystem(stations);
        CoreApp.addMyVelibSystem(system);
        return system;
    }


}
