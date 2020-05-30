package core.setup;

import core.components.Bicycle;
import core.components.User;
import core.components.factories.BicycleFactory;
import core.components.factories.PointFactory;
import core.system.MyVelibSystem;
import java.util.List;

public class RentalBicycle {

    public static void main(String[] args) {

        // Setup
        MyVelibSystem system0 = InitialSetup.getInitialSetupSystem(args);

        // Rental of a bike
        // 1. a user (card holder or not) rent a bike of a given type from a given station at a given
        //        moment in time

        // See the system
        System.out.println(system0);
        List<User> users = system0.getUsers();
        System.out.println(users);

        // User without card
        User userWithoutCard = users.get(0);
        userWithoutCard.rentBicyclePlanning(system0, PointFactory.addPoint(0,0), PointFactory.addPoint(20, 20), BicycleFactory.createElectricalBicycle());


        // User with Vmax
        User userVmax = users.get(1);


        // User with Vlibre
        User userVlibre = users.get(2);



        //        2. the user returns the bike to another station after a given duration (expressed in
        //        minutes).
        //        3. the user get charged for the corresponding amount (possibly 0) and possibly receive
        //        a time-credit (possibly 0)


    }
}
