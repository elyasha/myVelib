package core.setup;

import core.components.*;
import core.components.factories.CardFactory;
import core.components.factories.ParkingSlotsFactory;
import core.components.factories.StationFactory;
import core.components.factories.UserFactory;
import core.components.factories.PointFactory;
import core.system.MyVelibSystem;
import core.system.MyVelibSystemFactory;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Random;

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
        Station station = null;
    	Random rand = new Random();
        
        for (int i = 0; i < numberOfPlusStations; i++) {
        	
            // Create the standard stations and be sure two stations are not at the same place
        	while (station.equals(null)) {
        		// Coordinate x will be an integer between 0 and squareSide
            	// Coordinate y will be an integer between 0 and squareSide
        		int x = rand.nextInt((int) squareSide);
            	int y = rand.nextInt((int) squareSide);
        		station = StationFactory.addPlusStation(system0, PointFactory.addPoint(x, y), true, allSlots);
        	}
        	station = null;
        }
        
        for (int i = 0; i < numberOfStandardStations; i++) {
            // Create the standard stations and be sure two stations are not at the same place
        	while (station.equals(null)) {
        		// Coordinate x will be an integer between 0 and squareSide
            	// Coordinate y will be an integer between 0 and squareSide
        		int x = rand.nextInt((int) squareSide);
            	int y = rand.nextInt((int) squareSide);
        		station = StationFactory.addStandardStation(system0, PointFactory.addPoint(x, y), true, allSlots);
        	}
        	station = null;
            
         
        }


        // Add User without card
        int x,y;
        x = rand.nextInt((int) squareSide);
    	y = rand.nextInt((int) squareSide);
        UserFactory.addUser(system0,"Matheus" , PointFactory.addPoint(x, y),30109903, 1000);

        // Add User with Vmax
        x = rand.nextInt((int) squareSide);
    	y = rand.nextInt((int) squareSide);
        User user = UserFactory.addUser(system0, "Charlito", PointFactory.addPoint(x, y), 192340, 0);
        CardFactory.addVmax(system0, user);

        // Add User with Vlibre
        x = rand.nextInt((int) squareSide);
    	y = rand.nextInt((int) squareSide);
        User user2 = UserFactory.addUser(system0, "Valdisa", PointFactory.addPoint(x, y), 124340, 0);
        CardFactory.addVlibre(system0, user2);


        System.out.println(system0);

    }

}
