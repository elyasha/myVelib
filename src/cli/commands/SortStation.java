package cli.commands;


import core.CoreApp;
import core.components.Station;
import core.statistics.balance.station.StationApp;
import core.system.MyVelibSystem;

import java.util.List;

/**
 * This is the SortStation class that implements the sortStation command of the CLI.
 */
public class SortStation implements Command {

    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * sortStation [velibnetworkName, sortpolicy] : to display the stations in increas-
     * ing order w.r.t. to the sorting policy (as of Section 2.4) of user sortpolicy.
     * the sortpolicy parameter is optional, if you don't use it. We won't apply any policy
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {
        System.out.println("The sortStation command!");
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            if (args.length == 1) {
                mostUsedStationStrategy(args);
            } else {
                // Check if the sortPolicy == "mostUsed"
                if (args[1].equalsIgnoreCase("mostUsed")) {
                    mostUsedStationStrategy(args);
                }

                // Else
                if (args[1].equalsIgnoreCase("leastOccupied")) {
                    leastOccupiedStationStrategy(args);
                }
            }
        }

    }

    private static void leastOccupiedStationStrategy(String[] args) {
        // TODO: Implement the leastOccupied policy
        System.out.println("Not yet implemented! Sorry, but the developers are working on it!");
    }

    /**
     * This is the help command: it displays a message to better explain the command itself
     *
     * @param args the arguments of the command
     */
    public static void helpCommand(String[] args) {
        System.out.println("The sortStation command!");
        System.out.println("sortStation<velibnetworkName, sortpolicy> : to display the stations in increasing order w.r.t. to the sorting policy (as of Section 2.4) of user sortpolicy.");
        System.out.println("the sortpolicy parameter is optional, if you don't use it. We won't apply any policy");
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
        if (args.length > 2 || args.length == 0) {
            return false;
        }

        if (args.length == 1) {
            try {
                int integerValue = Integer.parseInt(args[0]);
                System.out.println("Wrong data type. Expecting a string! Please see your file.txt ;)");
                return false;
            } catch (NumberFormatException numberFormatException) {
                return true;
            }
        }
        try {
            int integerValue = Integer.parseInt(args[0]);
            return false;
        } catch (NumberFormatException e) {
            try {
                int integerValue = Integer.parseInt(args[1]);
                return false;
            } catch (NumberFormatException e1) {
                return true;
            }
        }


    }


    private static void mostUsedStationStrategy(String[] args) {
        System.out.println("The sortStation command without policies (will show the most used policy(!");
        List<MyVelibSystem> systems = CoreApp.getSystems();
        MyVelibSystem currentSystem = null;
        for (MyVelibSystem system : systems) {
            if (system.getName().equals(args[0])) {
                currentSystem = system;
                break;
            }
        }
        if (currentSystem != null) {
            List<Station> mostUsedStations = StationApp.sortStationByMostUsed(currentSystem.getStations());
            System.out.println("Displaying the most used stations by most used order.");
            for (Station station : mostUsedStations
            ) {
                System.out.println(station);
            }
        } else {
            System.out.println("The system does not exist");
        }
    }


}
