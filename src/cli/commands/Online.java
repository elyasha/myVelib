package cli.commands;

public class Online implements Command {
    /**
     *
     * online <velibnetworkName, stationID> : to put online the station stationID of
     * the myVelib network velibnetworkName
     *
     * @param args
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else {
            System.out.println("The online command!");
            // TODO: Design command
        }
    }

    public static void helpCommand(String[] args) {
        System.out.println("The online command!");
        System.out.println("online <velibnetworkName, stationID> : to put online the station stationID of the myVelib network velibnetworkName");
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
