package cli.commands;

import core.Main;
import core.components.User;
import core.components.factories.UserFactory;
import core.system.MyVelibSystem;

import java.util.List;

/**
 * This is the Display class that implements the display command of the CLI.
 */
public class Display implements Command {
    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * display [velibnetworkName]: to display the entire status (stations, parking bays,
     * users) of an a myVelib network velibnetworkName.
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {

        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            System.out.println("The display command!");
            List<MyVelibSystem> systems = Main.getSystems();
            MyVelibSystem currentSystem = null;
            for (MyVelibSystem system: systems){
                if (system.getName().equals(args[0])){
                    currentSystem = system;
                    break;
                }
            }
            if (currentSystem != null){
                currentSystem.displaySystemReport();
            }
            else{
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
        System.out.println("The display command!");
        System.out.println("display <velibnetworkName>: to display the entire status (stations, parking bays, users) of an a myVelib network velibnetworkName.");
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
        return args.length == 1;
    }
}
