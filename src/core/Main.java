package core;

import core.system.MyVelibSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * The Main class: This class is responsible to be the core class that executes the core package when running the java myVelib framework
 * It is indeed the core main application itself
 */
public class Main {

    /**
     * This is where all systems will be saved when running the application
     */
    private static List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();

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
        Main.systems = systems;
    }

    /**
     * This is the main() method of our myVelib application. The myVelib application itself
     *
     * @param args the arguments of our core myVelib application
     */
    public static void main(String[] args) {


        // Mode interpreter
        // Application

        // It will run until the exit command is prompted

        // State 1 : Waiting for a command to be prompted

        // State 2 : Figuring out the command to be executed

        // State 3 : Executing the command

        // Mode read a file and execute
        // TODO : We need to code the fact that the application will read a txt file
        // Usage: myvelib file.txt
        // Output: Execute the commands in file.txt


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
