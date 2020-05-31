package core.system;

import core.Main;
import core.components.Station;
import core.components.User;

import java.util.List;

public class MyVelibSystemFactory {

    public static MyVelibSystem createMyVelibSystem(List<Station> stations, List<User> users, double money) {
        MyVelibSystem system = new MyVelibSystem(stations, users, money);
        Main.addMyVelibSystem(system);
        return system;
    }

    public static MyVelibSystem createMyVelibSystem() {
        MyVelibSystem system = new MyVelibSystem();
        Main.addMyVelibSystem(system);
        return system;
    }

    public static MyVelibSystem createMyVelibSystem(List<Station> stations) {
        MyVelibSystem system = new MyVelibSystem(stations);
        Main.addMyVelibSystem(system);
        return system;
    }


}
