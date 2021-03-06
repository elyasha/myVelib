package cli.commands;

import core.CoreApp;
import core.components.Station;
import core.components.User;
import core.system.MyVelibSystem;

import java.util.List;

/**
 * This is the ReturnBicycle class that implements the returnBicycle command of the CLI.
 */
public class ReturnBicycle implements Command {
    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * returnBicycle [userID, stationID, time] : to let the user userID returning a bicycle
     * to station stationID at a given instant of time time (if no parking bay is available
     * should behave accordingly). This command should display the cost of the rent
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {
        System.out.println("The returnBicycle command");

        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            List<MyVelibSystem> systems = CoreApp.getSystems();
            boolean alreadyFind = false;
            for (MyVelibSystem system : systems) {
                for (User user : system.getUsers()) {
                    if (user.getId() == Integer.parseInt(args[0]) && !alreadyFind) {
                        for (Station station : system.getStations()) {
                            if (station.getId() == Integer.parseInt(args[1])) {
                                station.getStationTerminal().dropBicycleWithIntervalOfTime(user.getBicycle(), user, station, Double.parseDouble(args[2]));
                                alreadyFind = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (!alreadyFind) {
                System.out.println("You cannot drop a bicycle");
                System.out.println("The station id or/and user id do not exist");
            }
        }

    }

    /**
     * This is the help command: it displays a message to better explain the command itself
     *
     * @param args the arguments of the command
     */
    public static void helpCommand(String[] args) {
        System.out.println("The returnBicycle command");
        System.out.println("returnBicycle <userID, stationID, time> : to let the user userID returning a bike to station stationID at a given instant of time time (if no parking bay is available should behave accordingly). This command should display the cost of the rent");
    }

    /**
     * This method implements all the help that will be displayed to the user if he enters a wrong input
     */
    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed");
        System.out.println("Please add some (consistent) argument. For help: myvelib help [COMMAND]");
    }

    /**
     * This methods is used to check if the command has good input from the user
     *
     * @param args the arguments of the command
     * @return true, if the command has good input. false, otherwise
     */
    public static boolean hasGoodInput(String[] args) {
        if (args.length != 3) {
            return false;
        }
        try {
            int integerValue1 = Integer.parseInt(args[0]);
            int integerValue2 = Integer.parseInt(args[1]);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException.getMessage());
            System.out.println("Wrong data type. Expecting an integer. Please see your file.txt ;)");
            return false;
        }
        return true;
    }
}
