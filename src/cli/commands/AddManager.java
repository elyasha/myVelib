package cli.commands;

/**
 * This is the AddManager class that implements the addManager command of the CLI.
 */
public class AddManager implements Command {
    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * addManager [userName,cardType, velibnetworkName] :
     * to add a user with name {userName} and card {cardType}
     * (i.e. ``none'' if the user has no card) to a myVelib network {velibnetworkName}
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            System.out.println("The addManager command!");
            // TODO: Design the command
        }
    }


    /**
     * This methods is used to check if the command has good input from the user
     *
     * @param args the arguments of the command
     * @return true, if the command has good input. false, otherwise
     */
    public static boolean hasGoodInput(String[] args) {
        // Check the quantity of arguments in this command
        if (args.length != 3) {
            return false;
        } else {
            // Check if the cardType is well written
            if (!args[1].equals("Vmax") && !args[1].equals("Vlibre")) {
                CardTypeError();
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * This methods prints a message related to the card type error
     */
    private static void CardTypeError() {
        System.out.println("There is an error in the card type!");
        System.out.println("Please, add a coherent card type (Vmax, Vlibre, none)");
    }


    /**
     * This is the help command: it displays a message to better explain the command itself
     *
     * @param args the arguments of the command
     */
    public static void helpCommand(String[] args) {
        System.out.println("The addManager command!");
        System.out.println("addManager <userName,cardType, velibnetworkName> :");
        System.out.println("to add a user with name {userName} and card {cardType:Vmax/Vlibre/none}");
        System.out.println("(i.e. ``none'' if the user has no card) to a myVelib network {velibnetworkName}");

    }


    /**
     * This method implements all the help that will be displayed to the user if he enters a wrong input
     */
    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }
}
