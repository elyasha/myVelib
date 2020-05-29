package core.setup;

import core.components.User;
import core.components.factories.CardFactory;
import core.components.factories.UserFactory;
import core.system.MyVelibSystem;
import core.system.MyVelibSystemFactory;

import java.awt.*;
import java.util.Scanner;

public class InitialSetup {

    private static final double STATION_OCCUPIED_PERCENTAGE = 0.7;
    private static final double PERCENTAGE_OF_ELECTRICAL_BICYCLE = 0.3;

    public static void main(String[] args) {

        // Name of the myVelib system
        String name = args[0];

        // Quantity of stations
        int numberOfStations = Integer.parseInt(args[1]);

        // Quantity of parking slots
        int numberOfSlots = Integer.parseInt(args[2]);

        // Station occupied percentage
        double stationOccupiedPercentage = STATION_OCCUPIED_PERCENTAGE;

        // Percentage of electrical bicycle
        double percentageOfElectricalBicycle = PERCENTAGE_OF_ELECTRICAL_BICYCLE;

        // Area of the myVelib system
        double squareSide = Double.parseDouble(args[3]);

        // Number of bicycles
        int numberOfBicycles = Integer.parseInt(args[4]);


        // Creating of input parameters to createMyVelibSystem
        // ALGOS

        // Creation of the myVelib system
        MyVelibSystem system0 = MyVelibSystemFactory.createMyVelibSystem();



        // Add User without card
        UserFactory.addUser(system0,"Matheus" , new Point(0, 0),30109903, 100000000);

        // Add User with Vmax
        User user = UserFactory.addUser(system0, "Charlito", new Point(1, 1), 192340, 0);
        CardFactory.addVmax(system0, user);

        // Add User with Vlibre
        User user2 = UserFactory.addUser(system0, "Charlito2", new Point(1, 1), 192340, 0);
        CardFactory.addVlibre(system0, user2);




    }

}
