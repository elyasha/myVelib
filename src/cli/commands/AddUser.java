package cli.commands;

import core.CoreApp;
import core.components.User;
import core.components.factories.UserFactory;
import core.system.MyVelibSystem;

import java.util.List;

/**
 * This is the AddUser class that implements the addUser command of the CLI.
 */
public class AddUser implements Command {
    /**
     * Default credit card number
     */
    private static final int DEFAULT_CREDIT_CARD_NUMBER = 0000;

    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * addUser [userName,cardType, velibnetworkName] :
     * to add a user with name {userName} and card {cardType}
     * (i.e. ``none'' if the user has no card) to a myVelib network {velibnetworkName}
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {
        System.out.println("The addUser command!");
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            // Check if the system exists in the application

            List<MyVelibSystem> systems = CoreApp.getSystems();
            MyVelibSystem currentSystem = null;
            for (MyVelibSystem system : systems) {
                if (system.getName().equals(args[2])) {
                    currentSystem = system;
                    break;
                }
            }
            if (currentSystem != null) {
                User user = UserFactory.addUser(currentSystem, args[0], DEFAULT_CREDIT_CARD_NUMBER);
                user.addCard(args[1]);
            } else {
                System.out.println("The system does not exist");
            }


        }
    }

    /**
     * This is the help command: it displays a message to better explain the command itself
     *
     * @param args the arguments of the command
     */

    public static void helpCommand(String[] args) {
        System.out.println("The addUser command!");
        System.out.println("addUser <userName,cardType, velibnetworkName> :");
        System.out.println("to add a user with name {userName} and card {cardType: Vmax/Vlibre/none}");
        System.out.println("(i.e. ``none'' if the user has no card) to a myVelib network {velibnetworkName}");
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
        // Check the quantity of arguments in this command
        if (args.length != 3) {
            return false;
        } else {
            // Check if the cardType is well written
            switch (args[1]) {
                case "Vmax":
                case "Vlibre":
                case "None":
                    return true;
                default:
                    CardTypeError();
                    return false;
            }
        }
    }

    /**
     * This methods prints a message related to the card type error
     */
    private static void CardTypeError() {
        System.out.println("There is an error in the card type!");
        System.out.println("Please, add a coherent card type (Vmax, Vlibre, None)");
    }
}
