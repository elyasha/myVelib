package cli.commands;

public class Display implements Command {
    /**
     *
     * display <velibnetworkName>: to display the entire status (stations, parking bays,
     * users) of an a myVelib network velibnetworkName.
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("The display command!");
    }

    public static void helpCommand(String[] args) {
        // TODO
    }


    public boolean hasGoodInput(String[] args) {
        return false;
    }
}
