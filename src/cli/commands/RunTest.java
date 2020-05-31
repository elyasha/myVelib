package cli.commands;

public class RunTest implements Command{
    /**
     *
     * the runTest command: Run the test suite of the myVelib framework
     *
     * @param args
     */

    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else {
            System.out.println("The runTest command");
            // TODO: Design command
        }
    }

    public static void helpCommand(String[] args) {
        System.out.println("The runTest command");
        System.out.println("the runTest command: Run the test suite of the myVelib framework");
    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }

    public static boolean hasGoodInput(String[] args) {
        return args.length <= 1;
    }


}
