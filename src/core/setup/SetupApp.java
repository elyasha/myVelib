package core.setup;

import cli.commands.RunTest;

/**
 * The Main class from core.setup: This is the class to implement the setup methodology when creating a new myvelib system or network.
 * It can call other class that have already implement its own way of setting up a new myvelib network
 */
public class SetupApp {

    public static void initializeProgramWithInitialFile() {
        String[] fileName = new String[1];
        fileName[0] = "eval\\myvelibInitialization.txt";

        RunTest.main(fileName);
    }



}
