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


    public boolean hasGoodInput(String[] args) {
        return false;
    }
}
