package cli.commands;

import core.Main;
import core.components.Station;
import core.components.User;
import core.system.MyVelibSystem;

import java.util.List;

/**
 * This is the DisplayUser class that implements the displayUser command of the CLI.
 */
public class DisplayUser implements Command {
    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * displayUser [velibnetworkName, userID] : to display the statistics (as of Sec-
     * tion 2.4) of user userID of a myVelib network velibnetwork.
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            System.out.println("The displayStation command!");
            List<MyVelibSystem> systems = Main.getSystems();
            MyVelibSystem currentSystem = null;
            User currentUser = null;
            for (MyVelibSystem system: systems){
                if (system.getName().equals(args[0])){
                    currentSystem = system;
                    break;
                }
            }
            if (currentSystem != null){
                List<User> users = currentSystem.getUsers();
                for(User user: users){
                    if(user.getId() == Integer.parseInt(args[1])) {
                        currentUser = user;
                        currentSystem.displayUserReport(currentUser);
                        break;
                    }
                }
                if(currentUser == null){
                    System.out.println("The id of the user does not exist");
                }

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
        System.out.println("The displayUser command!");
        System.out.println("displayUser<velibnetworkName, userID> : to display the statistics of user userID of a myVelib network velibnetwork.");
        System.out.println();
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
        return args.length == 2;
        // TODO: Check to see if it is an integer

    }
}
