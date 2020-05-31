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

        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else {
            System.out.println("The display command!");
            // TODO: Design command
        }
    }

    public static void helpCommand(String[] args) {
        System.out.println("The display command!");
        System.out.println("display <velibnetworkName>: to display the entire status (stations, parking bays, users) of an a myVelib network velibnetworkName.");
    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }


    public static boolean hasGoodInput(String[] args) {
        return args.length == 1;
    }
}
