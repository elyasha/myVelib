package core.setup;

import core.components.Station;
import core.components.User;
import core.components.factories.BicycleFactory;
import core.components.factories.PointFactory;
import core.statistics.balance.station.StationApp;
import core.system.MyVelibSystem;

import java.util.List;

/**
 * The ComputationStatistics class : This is the class to implement the computation statistics of a myvelib system or network
 */
public class ComputationStatistics {

    /**
     * The main method for the computation statistics
     *
     * @param args arguments
     */
    public static void main(String[] args) {

        // Setup the system
        String[] setupArgs = {args[0], "10", "10", "1010", "5"};
        MyVelibSystem system = InitialSetup.getInitialSetupSystem(setupArgs);

//        Computation of statistics
//        1. the myVelib system stores relevant data in form of records representing N rental bike
//        simulations (by different users, on different stations, and with different duration)
        // User without card
        User userWithoutCard = system.getUsers().get(0);
        userWithoutCard.rentBicyclePlanning(system, PointFactory.addPoint(0, 0), PointFactory.addPoint(20, 20), BicycleFactory.createElectricalBicycle());


        // User with Vmax
        User userVmax = system.getUsers().get(1);
        userVmax.rentBicyclePlanning(system, PointFactory.addPoint(234, 234), PointFactory.addPoint(0, 0), BicycleFactory.createMechanicalBicycle());


        // User with Vlibre
        User userVlibre = system.getUsers().get(2);
        userVlibre.rentBicyclePlanning(system, PointFactory.addPoint(234, 234), PointFactory.addPoint(0, 0), BicycleFactory.createMechanicalBicycle());

        // User without card
        double RENT_TIME_FOR_USER_WITHOUT_CARD = 200;
        userWithoutCard.dropBicyclePlanningWithIntervalOfTime(system, PointFactory.addPoint(0, 0), PointFactory.addPoint(20, 20), RENT_TIME_FOR_USER_WITHOUT_CARD);


        // User with Vmax
        double RENT_TIME_FOR_USER_WITH_VMAX = 600;
        userVmax.dropBicyclePlanningWithIntervalOfTime(system, PointFactory.addPoint(234, 234), PointFactory.addPoint(0, 0), RENT_TIME_FOR_USER_WITH_VMAX);


        // User with Vlibre
        double RENT_TIME_FOR_USER_WITH_VLIBRE = 240;
        userVlibre.dropBicyclePlanningWithIntervalOfTime(system, PointFactory.addPoint(234, 234), PointFactory.addPoint(0, 0), RENT_TIME_FOR_USER_WITH_VLIBRE);


//        2. the statistics (computed w.r.t. the rental records added in previous step) for each
//        user are displayed

        system.displayUserReport(userWithoutCard);
        system.displayUserReport(userVmax);
        system.displayUserReport(userVlibre);


//        3. the statistics (computed w.r.t. the rental records added in previous step) for each
//        station are displayed
        for (Station station : system.getStations()) {
            system.displayStationReport(station);
        }


//        4. stations are displayed sorted w.r.t. the most used station (first)

        List<Station> mostUsedStations = StationApp.sortStationByMostUsed(system.getStations());

        System.out.println("MOST USED STATIONS");
        for (Station station : mostUsedStations) {
            System.out.println(station);
        }


//        5. stations are displayed sorted w.r.t. the least occupied station (first)

        // TODO : Implement the leastOccupied report
    }
}
