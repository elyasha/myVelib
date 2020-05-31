package cli.commands;

/**
 * This is the SortStation class that implements the sortStation command of the CLI.
 */
public class SortStation implements Command {

    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * sortStation [velibnetworkName, sortpolicy] : to display the stations in increas-
     * ing order w.r.t. to the sorting policy (as of Section 2.4) of user sortpolicy.
     * the sortpolicy parameter is optional, if you don't use it. We won't apply any policy
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            if (args.length == 1) {
                System.out.println("The sortStation command without policies!");
                // TODO: Design command without policies
            } else {
                System.out.println("The sortStation command with policies!");
                // TODO: [Optional] Design command with policies
            }
        }
    }

    /**
     * This is the help command: it displays a message to better explain the command itself
     *
     * @param args the arguments of the command
     */
    public static void helpCommand(String[] args) {
        System.out.println("The sortStation command!");
        System.out.println("sortStation<velibnetworkName, sortpolicy> : to display the stations in increasing order w.r.t. to the sorting policy (as of Section 2.4) of user sortpolicy.");
        System.out.println("the sortpolicy parameter is optional, if you don't use it. We won't apply any policy");
    }

    /**
     * This method implements all the help that will be displayed to the user if he enters a wrong input
     */
    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }

    /**
     * This methods is used to check if the command has good input from the user
     *
     * @param args the arguments of the command
     * @return true, if the command has good input. false, otherwise
     */
    public static boolean hasGoodInput(String[] args) {
        return args.length <= 2;
        // TODO: Check to see if it is an integer

    }


}
