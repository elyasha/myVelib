package cli.commands;

/**
 * This is the DisplayUser class that implements the displayUser command of the CLI.
 */
public class DisplayUser implements Command {
    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * displayUser [velibnetworkName, userID] : to display the statistics (as of Sec-
     * tion 2.4) of user userID of a myVelib network velibnetwork.
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            System.out.println("The displayUser command!");
            // TODO: Design command
        }
    }

    /**
     * This is the help command: it displays a message to better explain the command itself
     *
     * @param args the arguments of the command
     */
    public static void helpCommand(String[] args) {
        System.out.println("The displayUser command!");
        System.out.println("displayUser<velibnetworkName, userID> : to display the statistics of user userID of a myVelib network velibnetwork.");
        System.out.println();
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
        return args.length == 2;
        // TODO: Check to see if it is an integer

    }
}
