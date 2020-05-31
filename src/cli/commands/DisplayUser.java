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
        System.out.println("The displayUser command!");
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
