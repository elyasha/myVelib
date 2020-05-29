package core.setup;

import core.components.*;
import core.components.factories.CardFactory;
import core.components.factories.ParkingSlotsFactory;
import core.components.factories.StationFactory;
import core.components.factories.UserFactory;
import core.system.MyVelibSystem;
import core.system.MyVelibSystemFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InitialSetup {

    private static final double STATION_OCCUPIED_PERCENTAGE = 0.7;
    private static final double PERCENTAGE_OF_ELECTRICAL_BICYCLE = 0.3;
    private static final double PERCENTAGE_OF_PLUS_STATIONS = 0.5;

    public static void main(String[] args) {

        // Creation of the myVelib system
        MyVelibSystem system0 = MyVelibSystemFactory.createMyVelibSystem();

        // Name of the myVelib system
        String name = args[0];

        // Quantity of stations
        int numberOfStations = Integer.parseInt(args[1]);

        // Quantity of parking slots
        int numberOfSlots = Integer.parseInt(args[2]);

        // Station occupied percentage
        double stationOccupiedPercentage = STATION_OCCUPIED_PERCENTAGE;

        int numberOfOccupiedSlots = (int) (STATION_OCCUPIED_PERCENTAGE * numberOfSlots);

        int numberOfFreeSlots = numberOfSlots - numberOfOccupiedSlots;

        // Percentage of electrical bicycle
        double percentageOfElectricalBicycle = PERCENTAGE_OF_ELECTRICAL_BICYCLE;

        double percentageOfPlusStations = PERCENTAGE_OF_PLUS_STATIONS;

        int numberOfPlusStations = (int) (PERCENTAGE_OF_PLUS_STATIONS * numberOfStations);

        int numberOfStandardStations = numberOfStations - numberOfPlusStations;

        int numberOfElectricalBicycleSlots = (int) (PERCENTAGE_OF_ELECTRICAL_BICYCLE * numberOfOccupiedSlots);

        int numberOfMechanicalBicycleSlots = numberOfOccupiedSlots - numberOfElectricalBicycleSlots;

        // Area of the myVelib system
        double squareSide = Double.parseDouble(args[3]);

        // Number of bicycles
        int numberOfBicycles = Integer.parseInt(args[4]);


        // Creating of input parameters to createMyVelibSystem

        // parkingSlots
        List<ParkingSlot> electricalSlots = ParkingSlotsFactory.createElectricalBicycleSlots(numberOfElectricalBicycleSlots);
        List<ParkingSlot> mechanicalSlots = ParkingSlotsFactory.createElectricalBicycleSlots(numberOfMechanicalBicycleSlots);
        List<ParkingSlot> freeSlots = ParkingSlotsFactory.createFreeParkingSlots(numberOfFreeSlots);
        List<ParkingSlot> allSlots = Stream.concat(freeSlots.stream(), mechanicalSlots.stream()).collect(Collectors.toList());
        allSlots = Stream.concat(allSlots.stream(), electricalSlots.stream()).collect(Collectors.toList());

        // stations
        List<Station> stations = new ArrayList<Station>();

        for (int i = 0; i < numberOfPlusStations; i++) {
            // Create the point to random // TODO: Learn know to do the random stuff
            // TODO: Create a test to check if there is already a station when creating one

            // Create the plus stations
            Station station = StationFactory.addPlusStation(system0, new Point(0, 0), true, allSlots);

        }

        for (int i = 0; i < numberOfStandardStations; i++) {
            // Create the point to random // TODO: Learn know to do the random stuff
            // TODO: Create a test to check if there is already a station when creating one

            // Create the standard stations
            Station station = StationFactory.addStandardStation(system0, new Point(0, 0), true, allSlots);

        }










        // Add User without card
        UserFactory.addUser(system0,"Matheus" , new Point(0, 0),30109903, 100000000);

        // Add User with Vmax
        User user = UserFactory.addUser(system0, "Charlito", new Point(1, 1), 192340, 0);
        CardFactory.addVmax(system0, user);

        // Add User with Vlibre
        User user2 = UserFactory.addUser(system0, "Charlito2", new Point(1, 1), 192340, 0);
        CardFactory.addVlibre(system0, user2);


        System.out.println(system0);

    }

}
