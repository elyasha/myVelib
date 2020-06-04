package core.renting;

import core.components.*;
import core.components.factories.BicycleFactory;
import org.junit.Test;

import java.awt.*;
import java.sql.Time;
import java.time.LocalTime;

import static core.renting.RentingApp.*;
import static org.junit.Assert.*;

public class RentingAppTest {

    @Test
    public void getCostWithoutTimeCreditTest() {
        // Bicycle bicycle, Card card, Time intervalOfTime)
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        Card card = new Vmax();
        Time interval = new Time(0, 60, 0);

        assertEquals(1.0, getCostWithoutTimeCredit(bicycle, card, interval), 1e-3);
    }

    @Test
    public void getCostWithoutTimeCreditTest2() {
        // Bicycle bicycle, Card card, Time intervalOfTime)
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        Card card = new Vmax();
        Time interval = new Time(0, 59, 0);

        assertEquals(0.0, getCostWithoutTimeCredit(bicycle, card, interval), 1e-3);
    }

    @Test
    public void getCostWithoutTimeCreditTest3() {
        // Bicycle bicycle, Card card, Time intervalOfTime)
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        Card card = new Vmax();
        Time interval = new Time(0, 120, 0);

        assertEquals(2.0, getCostWithoutTimeCredit(bicycle, card, interval), 1e-3);
    }

    @Test
    public void getCostWithoutTimeCreditTest4() {
        // Bicycle bicycle, Card card, Time intervalOfTime)
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        Card card = new Vlibre();
        Time interval = new Time(0, 120, 0);

        assertEquals(2.0, getCostWithoutTimeCredit(bicycle, card, interval), 1e-3);
    }

    @Test
    public void getCostWithoutTimeCreditTest5() {
        // Bicycle bicycle, Card card, Time intervalOfTime)
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        Card card = null;
        Time interval = new Time(0, 120, 0);

        assertEquals(2.0, getCostWithoutTimeCredit(bicycle, card, interval), 1e-3);
    }

    @Test
    public void getCostWithoutTimeCreditTest6() {
        // Bicycle bicycle, Card card, Time intervalOfTime)
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        Card card = null;
        Time interval = new Time(0, 120, 0);

        assertEquals(4.0, getCostWithoutTimeCredit(bicycle, card, interval), 1e-3);
    }

    @Test
    public void getCostWithoutTimeCreditTest7() {
        // Bicycle bicycle, Card card, Time intervalOfTime)
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        Card card = new Vlibre();
        Time interval = new Time(0, 120, 0);

        assertEquals(5.0, getCostWithoutTimeCredit(bicycle, card, interval), 1e-3);
    }

    @Test
    public void getCostWithoutTimeCreditTest8() {
        // Bicycle bicycle, Card card, Time intervalOfTime)
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        Card card = new Vmax();
        Time interval = new Time(0, 120, 0);

        assertEquals(2.0, getCostWithoutTimeCredit(bicycle, card, interval), 1e-3);
    }


    @Test
    public void getCostWithTimeCreditTest1() {
        // Bicycle bicycle, Card card, Time intervalOfTime, double timeCredit, User user
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        Card card = new Vmax();
        Time interval = new Time(0, 120, 0);
        User user = new User("Paolo", new Point(0, 0), 0000, 50);
        user.setCard(card);
        user.setTimeCreditBalance(100); // 100 minutes

        assertEquals(0, getCostWithTimeCredit(bicycle, card, interval, user.getTimeCreditBalance(), user), 1e-3);
    }

    @Test
    public void getCostWithTimeCreditTest2() {
        // Bicycle bicycle, Card card, Time intervalOfTime, double timeCredit, User user
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        Card card = new Vmax();
        Time interval = new Time(0, 120, 0);
        User user = new User("Paolo", new Point(0, 0), 0000, 50);
        user.setCard(card);
        user.setTimeCreditBalance(5); // 100 minutes

        assertEquals(1, getCostWithTimeCredit(bicycle, card, interval, user.getTimeCreditBalance(), user), 1e-3);
    }

    @Test
    public void computeRentTimeTest() {
        User user = new User("Paolo", new Point(0, 0), 0000, 50);
        user.setRentTime(LocalTime.MIDNIGHT);
        LocalTime nowTime = LocalTime.now();
        double nowTime2 = nowTime.getHour() * 60 + nowTime.getMinute();

        assertEquals(nowTime2, computeRentTime(user), 1e-3);
    }

    @Test
    public void chargingUserTest() {
        // TODO

    }

}