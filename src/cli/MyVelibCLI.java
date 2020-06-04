package cli;

import cli.commands.RunTest;
import core.setup.SetupApp;

import java.util.*;

/**
 * This is the class that implements the interpreter or the CLI. Here basically we have a while loop that will only exits
 * when the user writes "exit" in the terminal. Otherwise, the program will wait for new commands and execute the main() method
 * of each command class.
 */
public class MyVelibCLI {

    /**
     * This is the main() method of the CLI class. It waits for the users to call the "myvelib" program and expect 0 or 1 argument.
     * If there are 0 arguments, then we will enter in the interpreter mode (just like python)
     * If there is 1 arguments, the CLI will assume it is a file path and will run the runTest command with the file provided.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {

            // Initialization of scanner and currentArgs
            Scanner scanner = new Scanner(System.in);
            String[] currentArgs; // A list of args that will change each iteration

            // Initialization of the system
            SetupApp.initializeProgramWithInitialFile();
            System.out.println(">>> : Please enter the next command!");
            currentArgs = scanner.nextLine().split(" ");

            // While loop to run commands
            while (!currentArgs[0].equals("exit")) {
                // Execute the next command
                RunCommand.main(currentArgs);
                System.out.println();

                // Ask for the next command
                System.out.println(">>> : Please enter the next command!");
                currentArgs = scanner.nextLine().split(" ");
                System.out.println();

            }

        } else {
            RunTest.main(args);
        }
    }

}
