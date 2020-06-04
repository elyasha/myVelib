package core.setup;

import core.components.*;
import core.components.factories.CardFactory;
import core.components.factories.ParkingSlotsFactory;
import core.components.factories.StationFactory;
import core.components.factories.UserFactory;
import core.components.factories.PointFactory;
import core.system.MyVelibSystem;
import core.system.MyVelibSystemFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Random;

/**
 * The InitialSetup class : This is the class to implement the initial setup when creating a new myvelib system or network
 */
public class InitialSetup {

    /**
     * Constant of station occupied percentage
     */
    private static final double STATION_OCCUPIED_PERCENTAGE = 0.7;

    /**
     * Constant of percentage of electrical bicycles
     */
    private static final double PERCENTAGE_OF_ELECTRICAL_BICYCLE = 0.3;

    /**
     * Constant of percentage of plus stations
     */
    private static final double PERCENTAGE_OF_PLUS_STATIONS = 0.5;

    /**
     * Constant for the user without card
     */
    private static final String USER_WITHOUT_CARD_NAME = "Matheus";

    /**
     * Constant for the user without card
     */
    private static final int USER_WITHOUT_CARD_CREDITCARD = 0000;

    /**
     * Constant for the user without card
     */
    private static final double USER_WITHOUT_CARD_MONEY = 100;

    /**
     * Constant for the user with Vmax
     */
    private static final String USER_VMAX_NAME = "Charles";

    /**
     * Constant for the user with Vmax
     */
    private static final int USER_VMAX_CREDITCARD = 0000;

    /**
     * Constant for the user with Vmax
     */
    private static final double USER_VMAX_MONEY = 100;

    /**
     * Constant for the user with Vlibre
     */
    private static final String USER_VLIBRE_NAME = "Valdisa";

    /**
     * Constant for the user with Vlibre
     */
    private static final int USER_VLIBRE_CREDITCARD = 0000;

    /**
     * Constant for the user with Vlibre
     */
    private static final double USER_VLIBRE_MONEY = 100;

    /**
     * This method will be used when running the initialSetup command to get an initial system with some stations, and even maybe users
     *
     * @param args the command line arguments
     * @return the new system (with setup)
     */
    public static MyVelibSystem getInitialSetupSystem(String[] args) {

        if (args.length == 1) {
            MyVelibSystem system = MyVelibSystemFactory.createMyVelibSystem();
            system.setName(args[0]);
            return system;
        } else {
            // Creation of the myVelib system
            MyVelibSystem system = MyVelibSystemFactory.createMyVelibSystem();

            // Setting name of the myVelib system
            String name = args[0];
            system.setName(name);

            // Quantity of stations
            int numberOfStations = Integer.parseInt(args[1]);

            // Quantity of parking slots
            int numberOfSlots = Integer.parseInt(args[2]);

            // Area of the myVelib system
            double squareSide = Double.parseDouble(args[3]);

            // Number of bicycles
            int numberOfBicycles = Integer.parseInt(args[4]);

            // Station occupied percentage

            int numberOfOccupiedSlots = (int) (STATION_OCCUPIED_PERCENTAGE * numberOfSlots);

            int numberOfFreeSlots = numberOfSlots - numberOfOccupiedSlots;

            // If number of bicycles is larger than the number of occupied slots, we will create less bicycles
            if (numberOfBicycles > numberOfOccupiedSlots) {
                numberOfBicycles = numberOfOccupiedSlots;
            }


            // Percentage of electrical bicycle

            int numberOfPlusStations = (int) (PERCENTAGE_OF_PLUS_STATIONS * numberOfStations);

            int numberOfStandardStations = numberOfStations - numberOfPlusStations;

            int numberOfElectricalBicycleSlots = (int) (PERCENTAGE_OF_ELECTRICAL_BICYCLE * numberOfBicycles);

            int numberOfMechanicalBicycleSlots = numberOfBicycles - numberOfElectricalBicycleSlots;


            // Creating of input parameters to createMyVelibSystem

            // parkingSlots
            List<ParkingSlot> electricalSlots = ParkingSlotsFactory.createElectricalBicycleSlots(numberOfElectricalBicycleSlots);
            List<ParkingSlot> mechanicalSlots = ParkingSlotsFactory.createMechanicalBicycleSlots(numberOfMechanicalBicycleSlots);
            List<ParkingSlot> freeSlots = ParkingSlotsFactory.createFreeParkingSlots(numberOfFreeSlots);
            List<ParkingSlot> allSlots = Stream.concat(freeSlots.stream(), mechanicalSlots.stream()).collect(Collectors.toList());
            allSlots = Stream.concat(allSlots.stream(), electricalSlots.stream()).collect(Collectors.toList());

            // stations
            List<Station> stations = new ArrayList<Station>();
            Station station = null;
            Random rand = new Random();

            for (int i = 0; i < numberOfPlusStations; i++) {

                // Create the standard stations and be sure two stations are not at the same place
                while (station == null) {
                    // Coordinate x will be an integer between 0 and squareSide
                    // Coordinate y will be an integer between 0 and squareSide
                    int x = rand.nextInt((int) squareSide);
                    int y = rand.nextInt((int) squareSide);
                    station = StationFactory.addPlusStation(system, PointFactory.addPoint(x, y), true, allSlots);
                }
                station = null;
            }

            for (int i = 0; i < numberOfStandardStations; i++) {
                // Create the standard stations and be sure two stations are not at the same place
                while (station == null) {
                    // Coordinate x will be an integer between 0 and squareSide
                    // Coordinate y will be an integer between 0 and squareSide
                    int x = rand.nextInt((int) squareSide);
                    int y = rand.nextInt((int) squareSide);
                    station = StationFactory.addStandardStation(system, PointFactory.addPoint(x, y), true, allSlots);
                }
                station = null;


            }


            // Add User without card
            int x, y;
            x = rand.nextInt((int) squareSide);
            y = rand.nextInt((int) squareSide);
            UserFactory.addUser(system, USER_WITHOUT_CARD_NAME, PointFactory.addPoint(x, y), USER_WITHOUT_CARD_CREDITCARD, USER_WITHOUT_CARD_MONEY);

            // Add User with Vmax
            x = rand.nextInt((int) squareSide);
            y = rand.nextInt((int) squareSide);
            User user = UserFactory.addUser(system, USER_VMAX_NAME, PointFactory.addPoint(x, y), USER_VMAX_CREDITCARD, USER_VMAX_MONEY);
            CardFactory.addVmax(system, user);

            // Add User with Vlibre
            x = rand.nextInt((int) squareSide);
            y = rand.nextInt((int) squareSide);
            User user2 = UserFactory.addUser(system, USER_VLIBRE_NAME, PointFactory.addPoint(x, y), USER_VLIBRE_CREDITCARD, USER_VLIBRE_MONEY);
            CardFactory.addVlibre(system, user2);

            return system;
        }

    }

    /**
     * The main method that will just run the initial setup and save the system
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        MyVelibSystem system = getInitialSetupSystem(args);
    }

}
