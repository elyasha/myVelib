package core.statistics.balance.user;

import core.components.Bicycle;
import core.components.ElectricalBicycle;
import core.components.MechanicalBicycle;
import core.components.User;
import core.system.MyVelibSystem;

/**
 * The Main class in statistics.balance.user : This class has all the algorithms and methods that we need to calculate the statistics
 * in the application for users, that is to say, standard users or managers.
 */
public class UserApp {

    /**
     * Getter for the number of rides (or rentings). If the user is still with a bicycle, it will show here a message.
     *
     * @param user The user that is being studied
     * @return an integer that represents the number of rides (or rentings)
     */
    public static int getNumberOfRides(User user) {
        if (user.getBicycle() == null) {
            return user.getNumberOfRentings();
        } else {
            System.out.println("You last ride is still active!");
            return user.getNumberOfRentings();
        }
    }

    /**
     * Getter for the time spend on bicycle type (Electrical, Mechanical, or other future types due to the Design Patterns used)
     *
     * @param user    the user
     * @param bicycle an instance of the bicycle type that we need
     * @return a double that represents the time spent [in minutes]
     */
    public static double getTimeSpentOnBicycle(User user, Bicycle bicycle) {
        if (bicycle instanceof ElectricalBicycle) {
            return getTimeSpentOnElectricalBicycle(user);
        } else if (bicycle instanceof MechanicalBicycle) {
            return getTimeSpentOnMechanicalBicycle(user);
        } else {
            return 0;
        }
    }

    /**
     * Getter for the time credit earned by a user. It calls the getter in the user class
     *
     * @param user The used that is being studied
     * @return The time credit earned by the user in the current time of the application
     */
    public static double getTimeCreditEarned(User user) {
        return user.getTimeCreditBalance();
    }

    /**
     * This method is used to get the time spent on electrical bicycles.
     *
     * @param user the user that is being studied
     * @return the time spent on electrical bicycle
     */
    public static double getTimeSpentOnElectricalBicycle(User user) {
        return user.getTimeSpentOnElectricalBicycle();
    }

    /**
     * This method is used to get the time spent on mechanical bicycles.
     *
     * @param user the user that is being studied
     * @return the time spent on mechanical bicycle
     */
    public static double getTimeSpentOnMechanicalBicycle(User user) {
        return user.getTimeSpentOnMechanicalBicycle();
    }

    /**
     * This method is used to get the informations of users and compute relevant parameters for the users in a give system
     * parameter 1 : average user balance
     * parameter 2 : average of all charged money
     * parameter 3 : user who paid the most in the system
     *
     * @param system the system that will be studied
     */
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

    }
}
