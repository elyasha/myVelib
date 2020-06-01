package cli.commands;

import core.Main;
import core.components.Station;
import core.components.User;
import core.components.factories.BicycleFactory;
import core.system.MyVelibSystem;

import java.util.List;

/**
 * This is the RentBicycle class that implements the rentBicycle command of the CLI.
 */
public class RentBicycle implements Command {
    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * rentBicycle [userID, stationID] : to let the user userID renting a bike from station
     * stationID (if no bikes are available should behave accordingly)
     *
     * The application can have many myVelib systems (networks) and so
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
            System.out.println("The rentBicycle command!");
            List<MyVelibSystem> systems = Main.getSystems();
            boolean alreadyFind = false;
            for (MyVelibSystem system: systems) {
                for(User user: system.getUsers()){
                    if (user.getId()==Integer.parseInt(args[0]) && !alreadyFind){
                        for(Station station: system.getStations()){
                            if(station.getId()==Integer.parseInt(args[1])){
                                station.getStationTerminal().rentBicycle(BicycleFactory.createMechanicalBicycle(),user,station);
                                alreadyFind = true;
                            }
                        }
                    }
                }
            }
            if(alreadyFind == false){
                System.out.println("You cannot rent a bicycle");
                System.out.println("The station id or/and user id do not exist");
            }
            // TODO: Study parameters
        }
    }

    /**
     * This is the help command: it displays a message to better explain the command itself
     *
     * @param args the arguments of the command
     */
    public static void helpCommand(String[] args) {
        System.out.println("The rentBicycle command!");
        System.out.println("rentBicycle <userID, stationID> : to let the user userID renting a bike from station stationID (if no bikes are available should behave accordingly)");

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
