package core.setup;

import core.components.Station;
import core.components.User;
import core.system.MyVelibSystem;

/**
 * The VisualizationStatistics class : It is responsible to test and implement the visualization part of the project
 */
public class VisualizationStatistics {


    /**
     * The main method for the VisualizationStatistics class
     *
     * @param args arguments
     */
    public static void main(String[] args) {

        // Setup the system
        String[] setupArgs = {"myvelib", "10", "10", "1010", "5"};
        MyVelibSystem system = InitialSetup.getInitialSetupSystem(setupArgs);

//    Visualisation of user, station and system state
//1. a manager (or a user) of myVelib request to see the current state of a user with given
//    ID

        int userID1 = Integer.parseInt(args[0]);

        User user1 = null;
        for (User user_i : system.getUsers()) {
            if (user_i.getId() == userID1) {
                user1 = user_i;
            }
        }
        system.displayUserReport(user1);

//2. the system displays a report of the requested user (including its balance, time credit,
//                                                       number of rides, etc).


//            3. a manager (or a user) of myVelib request to see the current state of a station with
//    given ID
        int stationID1 = Integer.parseInt(args[1]);
        Station station1 = null;
        for (Station station_i : system.getStations()) {
            if (station_i.getId() == stationID1) {
                station1 = station_i;
            }
        }
        system.displayStationReport(station1);

//4. the system displays a report of the requested station (including num. of free/occupied
//            slots, current state, its occupation etc)


//5. a manager (or a user) of myVelib request to see the current state of a the entire
//    system

        system.displaySystemReport();
//6. the system displays a summary report of the system (including list of online/offline
//            stations, list of users of myVelib , etc.)

    }

}
