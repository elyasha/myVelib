package core.setup;

import cli.commands.RunTest;

/**
 * The SetupApp class from core.setup: This is the class to implement the setup methodology when creating a new myvelib system or network.
 * It can call other class that have already implement its own way of setting up a new myvelib network
 */
public class SetupApp {

    /**
     * This method has the function to initialize the initial system when running the myVelib CLI.
     * It assumes that we will use a myvelibInitialization.txt file in the eval folder of the project.
     */
    public static void initializeProgramWithInitialFile() {
        String[] fileName = new String[1];
        fileName[0] = "eval\\myvelibInitialization.txt"; // Change to my_velib.ini if you prefer

        RunTest.main(fileName);
    }
}
