package core.renting;

import core.components.*;

import java.sql.Time;
import java.time.LocalTime;

/**
 * The Main class of renting module : This class contains all algorithms that are needed during the renting process.
 * This class is called when a User need to rent a bicycle
 */
public class Main {

    /**
     * A constant that represents the time added when a user drops its bicycle to a plus station
     */
    private static final double TIME_ADDED_BY_PLUS_STATION = 5;

    /**
     * Used to compute the cost according to some criteria
     * @param bicycle: Type of bicycle the user wants to rent
     * @param card: type of card the user is using
     * @param intervalOfTime: interval of renting time used to compute the cost
     * @return cost
     */
    public static double getCostWithoutTimeCredit(Bicycle bicycle, Card card, Time intervalOfTime) {

        double cost = 0;

        if (bicycle instanceof ElectricalBicycle) {
            if (card instanceof Vlibre) {
                if (intervalOfTime.getHours() >= 1) {
                    cost = 1 + (intervalOfTime.getHours() * 2);
                } else {
                    cost = 1; // TODO: Learn know to import CSV file
                }

            } else if (card instanceof Vmax) {
                if (intervalOfTime.getHours() >= 1) {
                    cost = (intervalOfTime.getHours() * 1);
                } else {
                    cost = 0;
                }

            } else {
                cost = intervalOfTime.getHours() * 2;
            }
        } else if (bicycle instanceof MechanicalBicycle) {
            if (card instanceof Vlibre) {
                if (intervalOfTime.getHours() >= 1) {
                    cost = (intervalOfTime.getHours() * 1);
                } else {
                    cost = 0; // TODO: Learn know to import CSV file
                }

            } else if (card instanceof Vmax) {
                if (intervalOfTime.getHours() >= 1) {
                    cost = (intervalOfTime.getHours() * 1);
                } else {
                    cost = 0; // TODO: Learn know to import CSV file
                }

            }

        }
        return cost;
    }

    /**
     * sed to compute the cost according to some criteria
     * @param bicycle: Type of bicycle the user wants to rent
     * @param card: type of card the user is using
     * @param intervalOfTime: interval of renting time used to compute the cost
     * @param timeCredit: User's time credit
     * @param user: user who wants to rent a bicycle
     * @return cost
     */
    public static double getCostWithTimeCredit(Bicycle bicycle, Card card, Time intervalOfTime, double timeCredit, User user) {

        double cost = 0;
        double hours;

        if (timeCredit < 0) {
            System.out.println("ERROR ! TIME CREDIT MUST BE POSITIVE");
        }
        if (timeCredit == 0) {
            cost = getCostWithoutTimeCredit(bicycle, card, intervalOfTime);
        } else {
            if (intervalOfTime.getHours() * 60 + intervalOfTime.getMinutes() - timeCredit > 0) {
                hours = (intervalOfTime.getHours() * 60 + intervalOfTime.getMinutes() - timeCredit) / 60;

                cost = getCostWithoutTimeCredit(bicycle, card, new Time((int) hours, 0, 0));

                user.setTimeCreditBalance(0);

            } else if (intervalOfTime.getHours() * 60 + intervalOfTime.getMinutes() - timeCredit == 0) {
                cost = 0; //
                // the new timeCredit = 0
                user.setTimeCreditBalance(0);

            } else if (intervalOfTime.getHours() * 60 + intervalOfTime.getMinutes() - timeCredit < 0) {
                cost = 0;
                // the new timeCredit < the old timeCredit
                user.setTimeCreditBalance((float) (timeCredit - (intervalOfTime.getHours() * 60 + intervalOfTime.getMinutes())));
            }

        }
        return cost;
    }

    /**
     * Used to compute the duration of the location
     * @param user a user
     * @return an interval of time used to compute the cost
     */
    public static double computeRentTime(User user) {
        LocalTime startTime;
        startTime = user.getRentTime();
        // Save endTime
        LocalTime endTime;
        endTime = LocalTime.now();

        if (startTime == null) {
            System.out.println("User did not rent any bicycle.");
            return 0;
        }

        double intervalOfTime;
        intervalOfTime = endTime.getHour() * 60 + endTime.getMinute() - startTime.getHour() * 60 - startTime.getMinute();

        return intervalOfTime;

    }

    /**
     * Charging the user after he dropped the bicycle
     * @param user a user
     * @param priceToBePayed: compute by the cost function
     * @param station: station where he dropped the bicycle
     */
    public static void chargingUser(User user, double priceToBePayed, Station station) {
        // We assume the client is rich
        user.setAllMoneyCharged((float) (user.getAllMoneyCharged() + priceToBePayed));
        user.removeMoney(priceToBePayed);
        station.addMoney(priceToBePayed);
        if (station instanceof PlusStation) {
            user.addTimeCredit(TIME_ADDED_BY_PLUS_STATION);
        }
    }


}