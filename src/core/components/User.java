package core.components;

import core.rides.planning.Main;
import core.system.MyVelibSystem;
import jdk.swing.interop.SwingInterOpUtils;

import java.awt.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class User {
    private final int id = generateUniqueID();
    private static int numberOfUsers = 0;

    private int generateUniqueID() {
        return ++numberOfUsers;
    }

    private String name;
    private Point coordinate;
    private Card card; // registration card
    private long creditCardNumber;
    private float timeCreditBalance = 0;  // [minutes]
    private float allMoneyCharged = 0;
    private float currentMoneyCharged = 0;
    private double money;
    private Bicycle bicycle;
    private int rentStationID;
    private LocalTime rentTime; // [minutes]
    private int numberOfRentings = 0;
    private double timeSpentOnElectricalBicycle = 0;
    private double timeSpentOnMechanicalBicycle = 0;


    // Constructor

    public User(String name, Point coordinate, long creditCardNumber, double money) {
        this.name = name;
        this.coordinate = coordinate;
        this.creditCardNumber = creditCardNumber;
        this.card = null;
        this.timeCreditBalance = 0;
        this.allMoneyCharged = 0;
        this.currentMoneyCharged = 0;
        this.bicycle = null;
        this.money = money;
    }


    // Getters


    public int getId() {
        return id;
    }

    public static int getNumberOfUsers() {
        return numberOfUsers;
    }

    public String getName() {
        return name;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public Card getCard() {
        return card;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public float getTimeCreditBalance() {
        return timeCreditBalance;
    }

    public float getAllMoneyCharged() {
        return allMoneyCharged;
    }

    public float getCurrentMoneyCharged() {
        return currentMoneyCharged;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public int getRentStationID() {
        return rentStationID;
    }

    public LocalTime getRentTime() {
        return rentTime;
    }

    public double getMoney() {
        return money;
    }

    public int getNumberOfRentings() {
        return numberOfRentings;
    }

    public double getTimeSpentOnElectricalBicycle() {
        return timeSpentOnElectricalBicycle;
    }

    public double getTimeSpentOnMechanicalBicycle() {
        return timeSpentOnMechanicalBicycle;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setTimeCreditBalance(float timeCreditBalance) {
        this.timeCreditBalance = timeCreditBalance;
    }

    public void setAllMoneyCharged(float allMoneyCharged) {
        this.allMoneyCharged = allMoneyCharged;
    }

    public void setCurrentMoneyCharged(float currentMoneyCharged) {
        this.currentMoneyCharged = currentMoneyCharged;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public void setRentStationID(int rentStationID) {
        this.rentStationID = rentStationID;
    }

    public void setRentTime(LocalTime rentTime) {
        this.rentTime = rentTime;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setNumberOfRentings(int numberOfRentings) {
        this.numberOfRentings = numberOfRentings;
    }

    public void setTimeSpentOnElectricalBicycle(double timeSpentOnElectricalBicycle) {
        this.timeSpentOnElectricalBicycle = timeSpentOnElectricalBicycle;
    }

    public void setTimeSpentOnMechanicalBicycle(double timeSpentOnMechanicalBicycle) {
        this.timeSpentOnMechanicalBicycle = timeSpentOnMechanicalBicycle;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinate=" + coordinate +
                ", card=" + card +
                ", creditCardNumber=" + creditCardNumber +
                ", timeCreditBalance=" + timeCreditBalance +
                ", allMoneyCharged=" + allMoneyCharged +
                ", currentMoneyCharged=" + currentMoneyCharged +
                ", money=" + money +
                ", bicycle=" + bicycle +
                ", rentStationID=" + rentStationID +
                ", rentTime=" + rentTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinate, card, creditCardNumber, timeCreditBalance, allMoneyCharged, currentMoneyCharged);
    }

    // Written methods

    public void addCard(String cardType) {

        if (cardType.equals("Vlible")) {
            this.card = new Vlibre();
        } else if (cardType.equals("Vmax")) {
            this.card = new Vmax();
        } else {
            System.out.println("Error! The type does not exist.");
        }
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public void removeMoney(double money) {
        if (this.money - money < 0) {
            System.out.println("ATTENTION! You are negative.");
        }
        this.money -= money;

    }

    public void addTimeCredit(double time) {
        this.timeCreditBalance += time;
    }

    public void removeTimeCredit(double time) {
        if (this.timeCreditBalance - time < 0) {
            System.out.println("You cannot have a negative time credit balance!");
        } else {
            this.timeCreditBalance -= time;
        }

    }

    public void rentBicyclePlanning(MyVelibSystem system, Point coordsStart, Point coordsEnd, Bicycle bicycle) {
        List<Station> allStations;
        Terminal termStart;

        // Get best start and end stations
        allStations = Main.getBestStation(system, coordsStart, coordsEnd, bicycle);
//        System.out.println(allStations);  // [null, null]
        // Get terminals of start and end stations
        termStart = allStations.get(0).getStationTerminal();
//        System.out.println(termStart);
        // Rent on terminal start
        termStart.rentBicycle(bicycle, this, allStations.get(0));

        // Drop on terminal end ? How can we know the time ?
    }

    // TODO: Refactor this method (we need to divide this method - start and end stations)
    // TODO: Remove bicycle, because
    public void dropBicyclePlanning(MyVelibSystem system, Point coordsStart, Point coordsEnd) {
        List<Station> allStations;
        Terminal termEnd;
        Bicycle bicycle = this.bicycle;

        // Check if the user has indeed a bicycle
        if (this.bicycle == null) {
            System.out.println("You have not a bicycle!!!");
        } else {
            // Get best start and end stations
            allStations = Main.getBestStation(system, coordsStart, coordsEnd, this.bicycle);

            // Get terminals of start and end stations
            termEnd = allStations.get(1).getStationTerminal();
            // Rent on terminal start
            termEnd.dropBicycle(bicycle, this, allStations.get(1));

            // Drop on terminal end ? How can we know the time ?
        }


    }

    public void dropBicyclePlanningWithIntervalOfTime(MyVelibSystem system, Point coordsStart, Point coordsEnd, double intervalOfTime) {
        List<Station> allStations;
        Terminal termEnd;
        Bicycle bicycle = this.bicycle;

        // Check if the user has indeed a bicycle
        if (this.bicycle == null) {
            System.out.println("You have not a bicycle!!!");
        } else {
            // Get best start and end stations
            allStations = Main.getBestStation(system, coordsStart, coordsEnd, this.bicycle);

            // Get terminals of start and end stations
            termEnd = allStations.get(1).getStationTerminal();
            // Rent on terminal start
            termEnd.dropBicycleWithIntervalOfTime(bicycle, this, allStations.get(1), intervalOfTime);

            // Drop on terminal end ? How can we know the time ?
        }


    }

    public void addRenting() {
        this.numberOfRentings += 1;
    }

    public void addSpentTimeOnElectricalBicycle(double intervalOfTime) {
        this.timeSpentOnElectricalBicycle += intervalOfTime;
    }

    public void addSpentTimeOnMechanicalBicycle(double intervalOfTime) {
        this.timeSpentOnMechanicalBicycle += intervalOfTime;
    }

    public void seeMyStatus() {
        System.out.println(this);
    }

    public void seeCurrentStatus(MyVelibSystem system, int userID) {
        if (this.id == userID) {
            this.seeMyStatus();
            System.out.println();
        } else {
            System.out.println("You are not allowed to see other people information!");
            System.out.println("Please ask a manager for this information!");
            System.out.println();
        }

    }

    public void seeCurrentStationState(MyVelibSystem system, int stationID) {
        // user can only see what is in its system
        if (system.getUsers().contains(this)) {

            Station currentStation = null;
            // Check to see if the station exists
            for (Station station : system.getStations()
            ) {
                if (station.getId() == stationID) {
                    currentStation = station;
                    break;
                }
            }

            if (currentStation == null) {
                System.out.println("The station does not exist in our system!");
            } else {
                System.out.println();
                System.out.println("STATION REPORT");
                System.out.println(currentStation);
                System.out.println();
            }

        }
    }

    public void displaySystemReport(MyVelibSystem system) {
        if (system.getUsers().contains(this)) {
            System.out.println();
            System.out.println("SYSTEM REPORT");
            System.out.println(system);
            System.out.println();
        }
    }


}
