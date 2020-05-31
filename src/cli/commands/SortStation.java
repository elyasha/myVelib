package cli.commands;

public class SortStation implements Command {
    /**
     *
     * sortStation<velibnetworkName, sortpolicy> : to display the stations in increas-
     * ing order w.r.t. to the sorting policy (as of Section 2.4) of user sortpolicy.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("The sortStation command!");
    }

    public static void helpCommand(String[] args) {
        // TODO:
    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }


}
