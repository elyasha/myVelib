package cli.commands;

public class RunTest implements Command{
    /**
     *
     * the runTest command
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("The runTest");
    }

    public static void helpCommand(String[] args) {
        // TODO
    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }


}
