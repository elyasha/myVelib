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
        System.out.println("The offline command!");
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
