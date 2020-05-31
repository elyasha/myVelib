package core;

import core.system.MyVelibSystem;

import java.util.List;

public class Main {

    private static List<MyVelibSystem> systems;

    public static List<MyVelibSystem> getSystems() {
        return systems;
    }

    public static void setSystems(List<MyVelibSystem> systems) {
        Main.systems = systems;
    }

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

    public static void addMyVelibSystem(MyVelibSystem system) {
        systems.add(system);
    }
}
