package cli;

import cli.commands.RunTest;
import cli.commands.Setup;
import core.setup.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MyVelibCLI {

    private final String[] listOfCommands = {"addManager", "addUser", "display", "displayStation", "displayUser", "exit", "help", "offline", "online", "rentBicycle", "returnBicycle", "runTest", "setup", "sortStation"};


    public String[] getListOfCommands() {
        return listOfCommands;
    }

    // Create a method to know how to change the state of the CLI

    public static void main(String[] args) {
        if (args.length == 0) {
            // While loop to run commands
            Scanner scanner = new Scanner(System.in);
            String[] currentArgs;

            // Initialization of the system
            Main.initializeProgramWithInitialFile();
            System.out.println(">>> : Please enter the next command!");
            currentArgs = scanner.nextLine().split(" ");

            while (!currentArgs[0].equals("exit")) {
                // Execute the next command
                RunCommand.main(currentArgs);
                System.out.println();
                System.out.println();

                // Ask for the next command
                System.out.println(">>> : Please enter the next command!");
                currentArgs = scanner.nextLine().split(" ");
                System.out.println();
                System.out.println();

            };


        }
        else {
            RunTest.main(args);
        }
    }

}
