package cli.commands;

public class DisplayUser implements Command {
    /**
     *
     * displayUser<velibnetworkName, userID> : to display the statistics (as of Sec-
     * tion 2.4) of user userID of a myVelib network velibnetwork.
     *
     * @param args
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else {
            System.out.println("The displayUser command!");
            // TODO: Design command
        }
    }

    public static void helpCommand(String[] args) {
        System.out.println("The displayUser command!");
        System.out.println("displayUser<velibnetworkName, userID> : to display the statistics of user userID of a myVelib network velibnetwork.");
        System.out.println();
    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }


    public static boolean hasGoodInput(String[] args) {
        return args.length == 2;
        // TODO: Check to see if it is an integer

    }
}
