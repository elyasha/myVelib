package cli;

import cli.commands.*;

/**
 * The Main class for the CLI application. This class will use the main() from the commands package.
 * This will be used when calling the interpreter or running the program to read a .txt file.
 */
public class Main {

    /**
     * main() is the implementation of the Main class for the CLI application.
     * It is here that we define how the CLI application will run and responds to the user.
     * @param args the arguments of the command
     */
    public static void main(String[] args) {

        // Check in there is any argument for the program
        if (args.length == 0) {
            Help.wrongArgumentHelp();
            System.exit(1);
        }

        // Check the type of first argument and delegate the work for each class
        switch (args[0]) {
            case "addUser":
                AddUser.main(args);
                break;
            case "display":
                Display.main(args);
                break;
            case "displayStation":
                DisplayStation.main(args);
                break;
            case "displayUser":
                DisplayUser.main(args);
                break;
            case "exit":
                Exit.main(args);
                break;
            case "help":
                Help.main(args);
                break;
            case "offline":
                Offline.main(args);
                break;
            case "online":
                Online.main(args);
                break;
            case "rentBicycle":
                RentBicycle.main(args);
                break;
            case "returnBicycle":
                ReturnBicycle.main(args);
                break;
            case "runTest":
                RunTest.main(args);
                break;
            case "setup":
                Setup.main(args);
                break;
            case "sortStation":
                SortStation.main(args);

                break;
            default:
                System.out.println("Not the good usage of the myVelib program. Please see the documentation [myvelib help]");
                // TODO: Learn how to use exceptions and error in Java
                System.exit(1);
        }

    }
}
