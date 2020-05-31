package cli.commands;

public class Exit implements Command{
    /**
     *
     * Exit command: this commands exists the myVelib application
     *
     * @param args
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else {
            System.out.println("The exit command!");
            System.exit(0);

        }
    }

    public static void helpCommand(String[] args) {
        System.out.println("The exit command!");
        System.out.println("Exit command: this commands exists the myVelib application");
    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }


    public static boolean hasGoodInput(String[] args) {
        return args.length == 0;
    }
}
