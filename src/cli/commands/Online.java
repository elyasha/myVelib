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
        System.out.println("The online command!");
    }

    public static void helpCommand(String[] args) {
        // TODO
    }


    public boolean hasGoodInput(String[] args) {
        return false;
    }
}
