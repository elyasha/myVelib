package core.renting;

import core.components.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;

import java.sql.Time;
import java.util.Date;

public class Main {

    public double getCost(Bicycle bicycle, Card card, Time intervalOfTime) {

        double cost = 0;

        if (bicycle instanceof ElectricalBicycle) {
            if (card instanceof Vlibre) {
                if (intervalOfTime.getHours() >= 1) {
                    cost += 2;
                }
                else {
                    cost += 1; // TODO: Learn know to import CSV file
                }

            } else if (card instanceof Vmax) {
                if (intervalOfTime.getHours() >= 1) {
                    return 1;
                }
                return 0;
            } else {
                return 2;
            }
        }

        else if (bicycle instanceof MechanicalBicycle) {
            if (card instanceof Vlibre) {
                if (intervalOfTime.getHours() >= 1) {
                    return 1;
                }
                return 0; // TODO: Learn know to import CSV file

            } else if (card instanceof Vmax) {
                if (intervalOfTime.getHours() >= 1) {
                    return 1;
                }
                return 0;
            } else {
                return 1;
            }

            return cost;
        }

        else {
            return -9999; // TODO: See if we can make this better
        }


    }

    public double getCost(Bicycle bicycle, Card card, Time intervalOfTime) {
        double cost = intervalOfTime.getHours()*
    }

}