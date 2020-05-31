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
        userWithoutCard.rentBicyclePlanning(system0, PointFactory.addPoint(0, 0), PointFactory.addPoint(20, 20), BicycleFactory.createElectricalBicycle());


        // User with Vmax
        User userVmax = users.get(1);
        userVmax.rentBicyclePlanning(system0, PointFactory.addPoint(234, 234), PointFactory.addPoint(0, 0), BicycleFactory.createMechanicalBicycle());


        // User with Vlibre
        User userVlibre = users.get(2);
        userVlibre.rentBicyclePlanning(system0, PointFactory.addPoint(234, 234), PointFactory.addPoint(0, 0), BicycleFactory.createMechanicalBicycle());

        // TESTS
//        for (User user: users
//             ) {
//            System.out.println(user);
//            System.out.println(user.getRentTime());
//            System.out.println(user.getBicycle());
//        }


        //        2. the user returns the bike to another station after a given duration (expressed in
        //        minutes).

        // User without card
        double RENT_TIME_FOR_USER_WITHOUT_CARD = 200;
        userWithoutCard.dropBicyclePlanningWithIntervalOfTime(system0, PointFactory.addPoint(0, 0), PointFactory.addPoint(20, 20), RENT_TIME_FOR_USER_WITHOUT_CARD);


        // User with Vmax
        double RENT_TIME_FOR_USER_WITH_VMAX = 600;
        userVmax.dropBicyclePlanningWithIntervalOfTime(system0, PointFactory.addPoint(234, 234), PointFactory.addPoint(0, 0), RENT_TIME_FOR_USER_WITH_VMAX);


        // User with Vlibre
        double RENT_TIME_FOR_USER_WITH_VLIBRE = 240;
        userVlibre.dropBicyclePlanningWithIntervalOfTime(system0, PointFactory.addPoint(234, 234), PointFactory.addPoint(0, 0), RENT_TIME_FOR_USER_WITH_VLIBRE);


        //        3. the user get charged for the corresponding amount (possibly 0) and possibly receive
        //        a time-credit (possibly 0)


    }
}
