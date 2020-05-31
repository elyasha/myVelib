package cli.commands;

/**
 * This is the RunTest class that implements the runTest command of the CLI.
 */
public class RunTest implements Command {
    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * the runTest command: Run the test suite of the myVelib framework
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            System.out.println("The runTest command");
            // TODO: Design command
        }
    }

    /**
     * This is the help command: it displays a message to better explain the command itself
     *
     * @param args the arguments of the command
     */
    public static void helpCommand(String[] args) {
        System.out.println("The runTest command");
        System.out.println("the runTest command: Run the test suite of the myVelib framework");
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
        return args.length <= 1;
    }


}
