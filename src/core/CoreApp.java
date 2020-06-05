package core;

import core.system.MyVelibSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * The CoreApp class: This class is responsible to be the core class that executes the core package when running the java myVelib framework
 * It is indeed the core main application itself
 */
public class CoreApp {

    /**
     * This is where all systems will be saved when running the application
     */
    private static List<MyVelibSystem> systems = new ArrayList<>();

    /**
     * a getter for systems
     *
     * @return All systems of the myVelib app
     */
    public static List<MyVelibSystem> getSystems() {
        return systems;
    }

    /**
     * A setter for systems
     *
     * @param systems A list of systems that is used to set all systems in the application
     */
    public static void setSystems(List<MyVelibSystem> systems) {
        CoreApp.systems = systems;
    }

    /**
     * This is the main() method of our myVelib core app. It is here only for consistence, but it is not required to run the cli application.
     *
     * @param args the arguments of our core myVelib application
     */
    public static void main(String[] args) {
        // This method does not need to be implemented. Actually the core package will be used by the cli package to run the cli application
    }

    /**
     * A method to add a new system to the systems variable
     *
     * @param system A system that will be added to the Main class (of the myVelib app)
     */
    public static void addMyVelibSystem(MyVelibSystem system) {
        systems.add(system);
    }
}
