package core.statistics.balance.user;

import core.components.Bicycle;
import core.components.ElectricalBicycle;
import core.components.MechanicalBicycle;
import core.components.User;
import core.system.MyVelibSystem;

public class Main {

    public static int getNumberOfRides(User user) {
        if (user.getBicycle() == null) {
            return user.getNumberOfRentings();
        } else {
            System.out.println("You last ride is still active!");
            return user.getNumberOfRentings();
        }
    }

    public static double getTimeSpentOnBicycle(User user, Bicycle bicycle) {
        if (bicycle instanceof ElectricalBicycle) {
            return getTimeSpentOnElectricalBicycle(user);
        } else if (bicycle instanceof MechanicalBicycle) {
            return getTimeSpentOnMechanicalBicycle(user);
        } else {
            return 0;
        }
    }

    public static double getTimeCreditEarned(User user) {
        return user.getTimeCreditBalance();
    }

    public static double getTimeSpentOnElectricalBicycle(User user) {
        return user.getTimeSpentOnElectricalBicycle();
    }

    public static double getTimeSpentOnMechanicalBicycle(User user) {
        return user.getTimeSpentOnMechanicalBicycle();
    }

    public static void userBalance(MyVelibSystem system) {

        // Calculate the average user balance
        double averageUserBalance = 0; // Initialize the average to zero

        for (User user : system.getUsers()) {
            averageUserBalance += user.getMoney();
        }
        averageUserBalance /= system.getUsers().size();

        System.out.println("The average user balance is: " + averageUserBalance + "!");
        System.out.println(); // skip line


        // Calculate the average of all charged money
        double averageOfAllChargedMoney = 0;

        for (User user : system.getUsers()) {
            averageOfAllChargedMoney += user.getAllMoneyCharged();
        }

        averageOfAllChargedMoney /= system.getUsers().size();

        System.out.println("The average of all charged money is: " + averageOfAllChargedMoney + "!");
        System.out.println();


        // Calculate the user that paid the most to the myVelib system
        User userWhoPaidTheMost = system.getUsers().get(0); // Take the first user

        for (User user : system.getUsers()) {

            // If user has a higher allChargedMoney parameter, we change
            if (user.getAllMoneyCharged() > userWhoPaidTheMost.getAllMoneyCharged()) {
                userWhoPaidTheMost = user;
            }

        }

        System.out.println("User who paid the most to the system is: " + userWhoPaidTheMost + "!");
        System.out.println();

        // Calculate other stuff

        // TODO: (Charlito) See if we can add more stuff here and maybe refactor the methods

    }
}
