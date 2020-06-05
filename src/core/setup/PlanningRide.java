package core.setup;

import core.components.Station;
import core.components.User;
import core.components.factories.BicycleFactory;
import core.components.factories.PointFactory;
import core.rides.planning.PlanningApp;
import core.system.MyVelibSystem;

import java.util.List;

import java.awt.*;

/**
 * The PlanningRide class : This is the class to implement the planning simulations from the planning package when creating a new journey ride for a user
 */
public class PlanningRide {

    /**
     * The main method for planning ride
     * @param args arguments
     */
    public static void main(String[] args) {

        // Setup the system


//        Simulation of a planning ride
//        1. a user at a given position require a ride planning to reach a destination position
        String myVelibNetworkName = args[0];

        String[] setupArgs = {myVelibNetworkName, "10", "10", "1010", "5"};
        MyVelibSystem system = InitialSetup.getInitialSetupSystem(setupArgs);

        int userID = Integer.parseInt(args[1]);
        Point startPoint = PointFactory.addPoint(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        Point endPoint = PointFactory.addPoint(Integer.parseInt(args[4]), Integer.parseInt(args[5]));


//        2. the user receives the source and destination stations
        List<Station> bestStations = PlanningApp.getBestStation(system, startPoint, endPoint, BicycleFactory.createMechanicalBicycle());
        System.out.println(bestStations);

//        3. the user retrieve a bicycle from the source station of the planned ride at a given
//        instant of time

        User user = null;
        for (User user_i : system.getUsers()) {
            if (user_i.getId() == userID) {
                user = user_i;
            }
        }

        if (user == null) {
            System.out.println("User does not exist in the system");
        } else {
            user.rentBicyclePlanning(system, startPoint, endPoint, BicycleFactory.createMechanicalBicycle());
        }


//        4. the user that is holding a bicycle returns it (in a given free slot) at a given station at
//        a given instant of time.
        double INTERVAL_OF_TIME = Double.parseDouble(args[6]);

        assert user != null;
        user.dropBicyclePlanningWithIntervalOfTime(system, startPoint, endPoint, INTERVAL_OF_TIME);

    }
}
