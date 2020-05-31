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
        System.out.println("The displayStation command!");

    }

    public static void helpCommand(String[] args) {
        // TODO
    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }


    public boolean hasGoodInput(String[] args) {
        return false;
    }
}
