package cli.commands;

import core.CoreApp;
import core.components.Station;
import core.system.MyVelibSystem;

import java.util.List;

/**
 * This is the DisplayStation class that implements the displayStation command of the CLI.
 */
public class DisplayStation implements Command {
    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * displayStation [velibnetworkName, stationID] : to display the statistics (as of
     * Section 2.4) of station stationID of a myVelib network velibnetwork.
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            System.out.println("The displayStation command!");
            List<MyVelibSystem> systems = CoreApp.getSystems();
            MyVelibSystem currentSystem = null;
            Station current_station = null;
            for (MyVelibSystem system : systems) {
                if (system.getName().equalsIgnoreCase(args[0])) {
                    currentSystem = system;
                    break;
                }
            }
            if (currentSystem != null) {
                List<Station> stations = currentSystem.getStations();
                for (Station station : stations) {
                    if (station.getId() == Integer.parseInt(args[1])) {
                        current_station = station;
                        currentSystem.displayStationReport(station);
                        break;
                    }
                }
                if (current_station == null) {
                    System.out.println("The id of the station does not exist");
                }

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
        System.out.println("The displayStation command!");
        System.out.println("displayStation <velibnetworkName, stationID> : to display the statistics of station stationID of a myVelib network velibnetwork.");

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
        try {
            int integerValue = Integer.parseInt(args[1]);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException.getMessage());
            System.out.println("Wrong data type. Expecting an integer! Please see your file.txt ;)");
            return false;
        }
        return args.length == 2;

    }
}
