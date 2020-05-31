package cli.commands;

public class SortStation implements Command {
    /**
     *
     * sortStation<velibnetworkName, sortpolicy> : to display the stations in increas-
     * ing order w.r.t. to the sorting policy (as of Section 2.4) of user sortpolicy.
     * the sortpolicy parameter is optional, if you don't use it. We won't apply any policy
     *
     * @param args
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else{
            if (args.length == 1) {
                System.out.println("The sortStation command without policies!");
                // TODO: Design command without policies
            }
            else {
                System.out.println("The sortStation command with policies!");
                // TODO: [Optional] Design command with policies
            }
        }
    }

    public static void helpCommand(String[] args) {
        System.out.println("The sortStation command!");
        System.out.println("sortStation<velibnetworkName, sortpolicy> : to display the stations in increasing order w.r.t. to the sorting policy (as of Section 2.4) of user sortpolicy.");
        System.out.println("the sortpolicy parameter is optional, if you don't use it. We won't apply any policy");
    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }

    public static boolean hasGoodInput(String[] args) {
        return args.length <= 2;
        // TODO: Check to see if it is an integer

    }



}
