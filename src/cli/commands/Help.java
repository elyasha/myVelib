package cli.commands;

import java.util.Arrays;
import java.util.List;

public class Help implements Command {
    /**
     * help command
     *
     * @param args
     */
    public static void main(String[] args) {

        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            if (args.length == 0) {
                helpCommand(args);
            } else {
                // sout the help for the particular command
                // Check the type of first argument and delegate the work for each class
                switch (args[0]) {
                    case "addUser":
                        AddUser.helpCommand(args);
                        break;
                    case "display":
                        Display.helpCommand(args);
                        break;
                    case "displayStation":
                        DisplayStation.helpCommand(args);
                        break;
                    case "displayUser":
                        DisplayUser.helpCommand(args);
                        break;
                    case "exit":
                        Exit.helpCommand(args);
                        break;
                    case "help":
                        Help.helpCommand(args);
                        break;
                    case "offline":
                        Offline.helpCommand(args);
                        break;
                    case "online":
                        Online.helpCommand(args);
                        break;
                    case "rentBike":
                        RentBicycle.helpCommand(args);
                        break;
                    case "returnBike":
                        ReturnBicycle.helpCommand(args);
                        break;
                    case "runTest":
                        RunTest.helpCommand(args);
                        break;
                    case "setup":
                        Setup.helpCommand(args);
                        break;
                    case "sortStation":
                        SortStation.helpCommand(args);
                        break;
                    default:
                        System.out.println("Not the good usage of the myVelib program. Please see the documentation [myvelib help [COMMAND]]");
                        // TODO: Learn how to use exceptions and error in Java
                        System.exit(1);
                }

            }
        }

    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }

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
