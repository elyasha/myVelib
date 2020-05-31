package cli.commands;

public class Exit implements Command{
    /**
     *
     * Exit command
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("The exit command!");
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
