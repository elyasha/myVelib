package core.system;

import core.components.Station;
import core.components.User;

import java.util.List;

public class MyVelibSystemFactory {

    public static MyVelibSystem createMyVelibSystem(List<Station> stations, List<User> users, double money) {
        return new MyVelibSystem(stations, users, money);
    }

    public static MyVelibSystem createMyVelibSystem() {
        return new MyVelibSystem();
    }

    public static MyVelibSystem createMyVelibSystem(List<Station> stations) {
        return new MyVelibSystem(stations);
    }


}