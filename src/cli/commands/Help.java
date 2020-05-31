package cli.commands;

import jdk.swing.interop.SwingInterOpUtils;

public class Help implements Command {
    /**
     * help command
     *
     * @param args
     */
    public static void main(String[] args) {
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

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help");
    }
}
