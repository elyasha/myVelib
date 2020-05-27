package core.renting;

import core.components.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;

import java.sql.Time;
import java.util.Date;

public class Main {

    public double getCostWithoutTimeCredit(Bicycle bicycle, Card card, Time intervalOfTime) {

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
                }
                else {
                    cost = 0;
                }

            } else {
                cost = intervalOfTime.getHours() * 2;
            }
        }

        else if (bicycle instanceof MechanicalBicycle) {
            if (card instanceof Vlibre) {
                if (intervalOfTime.getHours() >= 1) {
                    cost = (intervalOfTime.getHours() * 1);
                }
                else {
                    cost = 0; // TODO: Learn know to import CSV file
                }

            } else if (card instanceof Vmax) {
                if (intervalOfTime.getHours() >= 1) {
                    cost = (intervalOfTime.getHours() * 1);
                }
                else {
                    cost = 0; // TODO: Learn know to import CSV file
                }

            }

        }
        return cost;
    }

    public double getCostWithTimeCredit(Bicycle bicycle, Card card, Time intervalOfTime, double timeCredit, User user){

        double cost = 0;
        double hours;

        if (timeCredit < 0) {
            System.out.println("ERROR ! TIME CREDIT MUST BE POSITIVE");
        }
        if (timeCredit == 0) {
            cost = getCostWithoutTimeCredit(bicycle,card,intervalOfTime);
        }
        else {
            if (intervalOfTime.getHours()*60 + intervalOfTime.getMinutes() - timeCredit > 0) {
                hours = (intervalOfTime.getHours()*60 + intervalOfTime.getMinutes() - timeCredit)/60;

                cost = getCostWithoutTimeCredit(bicycle, card, new Time((int) hours, 0, 0));

                user.setTimeCreditBalance(0);

            }
            else if (intervalOfTime.getHours()*60 + intervalOfTime.getMinutes() - timeCredit == 0) {
                cost = 0; //
                // the new timeCredit = 0
                user.setTimeCreditBalance(0);

            }
            else if (intervalOfTime.getHours()*60 + intervalOfTime.getMinutes() - timeCredit < 0) {
                cost = 0;
                // the new timeCredit < the old timeCredit
                user.setTimeCreditBalance((float) (timeCredit - (intervalOfTime.getHours()*60 + intervalOfTime.getMinutes())));
            }

        }
        return cost;
    }



}