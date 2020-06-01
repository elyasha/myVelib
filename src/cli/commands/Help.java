package cli.commands;

import java.util.Arrays;
import java.util.List;

/**
 * This is the Help class that implements the help command of the CLI.
 */
public class Help implements Command {
    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * help command
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {

        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            if (args.length == 0) {
                helpCommand(args);
            } else {
                String[] argsCommand = new String[args.length - 1];

                for (int j = 1; j < args.length; j++) {
                    argsCommand[j - 1] = args[j];
                }
                // sout the help for the particular command
                // Check the type of first argument and delegate the work for each class
                switch (args[0]) {
                    case "addUser":
                        AddUser.helpCommand(argsCommand);
                        break;
                    case "addManager":
                        AddManager.helpCommand(argsCommand);
                    case "display":
                        Display.helpCommand(argsCommand);
                        break;
                    case "displayStation":
                        DisplayStation.helpCommand(argsCommand);
                        break;
                    case "displayUser":
                        DisplayUser.helpCommand(argsCommand);
                        break;
                    case "exit":
                        Exit.helpCommand(argsCommand);
                        break;
                    case "help":
                        Help.helpCommand(argsCommand);
                        break;
                    case "offline":
                        Offline.helpCommand(argsCommand);
                        break;
                    case "online":
                        Online.helpCommand(argsCommand);
                        break;
                    case "rentBicycle":
                        RentBicycle.helpCommand(argsCommand);
                        break;
                    case "returnBicycle":
                        ReturnBicycle.helpCommand(argsCommand);
                        break;
                    case "runTest":
                        RunTest.helpCommand(argsCommand);
                        break;
                    case "setup":
                        Setup.helpCommand(argsCommand);
                        break;
                    case "sortStation":
                        SortStation.helpCommand(argsCommand);
                        break;
                    default:
                        System.out.println("Not the good usage of the myVelib program. Please see the documentation [myvelib help [COMMAND]]");
                        // TODO: Learn how to use exceptions and error in Java
                }

            }
        }

    }

    /**
     * This method implements all the help that will be displayed to the user if he enters a wrong input
     */
    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }

    /**
     * This methods is used to check if the command has good input from the user
     *
     * @param args the arguments of the command
     * @return true, if the command has good input. false, otherwise
     */
    public static boolean hasGoodInput(String[] args) {
        if (args.length == 0) {
            return true;
        } else if (args.length == 1) {
            // Check if the input is a real command
            // TODO: Create a file to store constants (list of commands)
            List<String> commandList = Arrays.asList("addManager", "addUser", "display", "displayStation", "displayUser", "exit", "help", "offline", "online", "rentBicycle", "returnBicycle", "runTest", "setup", "sortStation");
            if (commandList.contains(args[0])) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * This is the help command: it displays a message to better explain the command itself
     *
     * @param args the arguments of the command
     */
    public static void helpCommand(String[] args) {
        System.out.println();
        System.out.println("CLI to interact with myVelib");
        System.out.println();

        System.out.println("VERSION");
        System.out.println("myVelib Framework v1.0 win32-x64 java11.0.7");
        System.out.println();

        System.out.println("USAGE");
        System.out.println("$ myvelib [COMMAND]");
        System.out.println();

        System.out.println("COMMANDS");
        System.out.println("addManager:" + "       " + "add a manager to a myvelib system");
        System.out.println("addUser:" + "          " + "add a user to a myvelib system");
        System.out.println("display:" + "          " + "display the entire status of a myvelib system");
        System.out.println("displayStation:" + "   " + "display informations of a station");
        System.out.println("exit" + "              " + "exit command");
        System.out.println("help" + "              " + "see informations related to the CLI");
        System.out.println("offline" + "           " + "to put offline a station of a myvelib network");
        System.out.println("online" + "            " + "to put online a station of a myvelib network");
        System.out.println("rentBicycle" + "       " + "rent a bicycle");
        System.out.println("returnBicycle" + "     " + "to drop a bicycle");
        System.out.println("runTest" + "           " + "run test suite for this version of the CLI");
        System.out.println("setup" + "             " + "setup a myvelib network");
        System.out.println("sortStation" + "       " + "sort stations with different kinds of policies");
        System.out.println();
        System.out.println();
    }
}
