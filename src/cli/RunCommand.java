package cli;

import cli.commands.*;

/**
 * The RunCommand class for the CLI application. This class will use the main() from the commands package.
 * This will be used when calling the interpreter or running the program to read a .txt file.
 */
public class RunCommand {

    /**
     * main() is the implementation of the Main class for the CLI application.
     * It is here that we define how the CLI application will run and responds to the user.
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {


        // Check if there is any argument for the program
        if (args.length == 0) {
            Help.wrongArgumentHelp();
        }
        else {
            String[] argsCommand = new String[args.length - 1];

            for (int j = 1; j < args.length; j++) {
                argsCommand[j - 1] = args[j];
            }
            // Check the type of first argument and delegate the work for each class
            switch (args[0]) {

                case "addUser":
                    AddUser.main(argsCommand);
                    break;

                case "addManager":
                    AddManager.main(argsCommand);
                case "display":
                    Display.main(argsCommand);
                    break;
                case "displayStation":
                    DisplayStation.main(argsCommand);
                    break;
                case "displayUser":
                    DisplayUser.main(argsCommand);
                    break;
                case "exit":
                    Exit.main(argsCommand);
                    break;
                case "help":
                    Help.main(argsCommand);
                    break;
                case "offline":
                    Offline.main(argsCommand);
                    break;
                case "online":
                    Online.main(argsCommand);
                    break;
                case "rentBicycle":
                    RentBicycle.main(argsCommand);
                    break;
                case "returnBicycle":
                    ReturnBicycle.main(argsCommand);
                    break;
                case "runTest":
                    RunTest.main(argsCommand);
                    break;
                case "setup":
                    Setup.main(argsCommand);
                    break;
                case "sortStation":
                    SortStation.main(argsCommand);
                    break;
                default:
                    System.out.println("Not the good usage of the myVelib program. Please see the documentation [myvelib help]");
            }
        }



    }
}
