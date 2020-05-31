package cli.commands;

public class Offline implements Command {
    /**
     *
     * offline <velibnetworkName, stationID> : to put offline the station stationID
     * of the myVelib network velibnetworkName
     *
     * @param args
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else {
            System.out.println("The offline command!");
            // TODO: Design command
        }
    }

    public static void helpCommand(String[] args) {
        System.out.println("The offline command!");
        System.out.println("offline <velibnetworkName, stationID> : to put offline the station stationID of the myVelib network velibnetworkName");
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


