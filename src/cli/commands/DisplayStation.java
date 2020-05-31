package cli.commands;

public class DisplayStation implements Command {
    /**
     *
     * displayStation<velibnetworkName, stationID> : to display the statistics (as of
     * Section 2.4) of station stationID of a myVelib network velibnetwork.
     *
     * @param args
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else {
            System.out.println("The displayStation command!");
            // TODO: Design command
        }

    }

    public static void helpCommand(String[] args) {
        System.out.println("The displayStation command!");
        System.out.println("displayStation <velibnetworkName, stationID> : to display the statistics of station stationID of a myVelib network velibnetwork.");

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
