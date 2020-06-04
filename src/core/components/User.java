package core.components;

import core.rides.planning.PlanningApp;
import core.system.MyVelibSystem;

import java.awt.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

/**
 * The User class : This class defines what a user is, what a user has and how he will behave in the application
 */
public class User {

    /**
     * Id of the User
     */
    private final int id = generateUniqueID();

    /**
     * Number of Users in the system
     */
    private static int numberOfUsers = 0;

    private int generateUniqueID() {
        return ++numberOfUsers;
    }

    /**
     * Name of the User
     */
    private String name;

    /**
     * Coordinate of the User
     */
    private Point coordinate;

    /**
     * Registration card (Vilbre/Vmax/none) of the User
     */
    private Card card;

    /**
     * CreditCardNumnber of the User
     */
    private long creditCardNumber;

    /**
     * Time credit balance given by some type of station for the User
     * Expressed in minutes
     */
    private float timeCreditBalance = 0;

    /**
     * All money the user paid for its location
     */
    private float allMoneyCharged = 0;

    /**
     * Current money charged for the actual location
     */
    private float currentMoneyCharged = 0;

    /**
     * Money balance of the user
     */
    private double money;

    /**
     * Type of Bicycle rented by the user
     */
    private Bicycle bicycle;

    /**
     * Renting Station ID of the actual location
     */
    private int rentStationID;

    /**
     * Renting time used to compute the cost of the actual location
     * Expressed in minutes
     */
    private LocalTime rentTime;

    /**
     * Number of rentings used to compute user's statistics
     */
    private int numberOfRentings = 0;

    /**
     * Time spend on electical bicycle used to compute user's
     * statistics
     * Expressed in minutes
     */
    private double timeSpentOnElectricalBicycle = 0;

    /**
     * Time spend on mechanical bicycle used to compute user's
     * statistics
     * Expressed in minutes
     */
    private double timeSpentOnMechanicalBicycle = 0;


    // Constructor

    /**
     * The User contructor
     *
     * @param name:             name of the user
     * @param coordinate:       coordinate of the user
     * @param creditCardNumber: credit card number of the user
     * @param money:            inital money balance of the user
     */
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

    /**
     * @return the id of the user
     */
    public int getId() {
        return id;
    }

    /**
     * @return the number of Users in the system
     */
    public static int getNumberOfUsers() {
        return numberOfUsers;
    }

    /**
     * @return the name of the User
     */
    public String getName() {
        return name;
    }

    /**
     * @return the coordinate of the user
     */
    public Point getCoordinate() {
        return coordinate;
    }

    /**
     * @return the Card of the User (Vlibre/Vmax/none)
     */
    public Card getCard() {
        return card;
    }

    /**
     * @return the credit card number of the user
     */
    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * @return the time credit balance of the user
     */
    public float getTimeCreditBalance() {
        return timeCreditBalance;
    }

    /**
     * @return All the money the user has been charged
     */
    public float getAllMoneyCharged() {
        return allMoneyCharged;
    }

    /**
     * @return the current money charged for the user
     */
    public float getCurrentMoneyCharged() {
        return currentMoneyCharged;
    }

    /**
     * @return the bicycle the user is using if he
     * is in a location
     */
    public Bicycle getBicycle() {
        return bicycle;
    }

    /**
     * @return the station ID where the user rented the
     * bicycle he is using right now. None if he does not.
     */
    public int getRentStationID() {
        return rentStationID;
    }

    /**
     * @return the time when he rented his last bicycle
     */
    public LocalTime getRentTime() {
        return rentTime;
    }

    /**
     * @return the money balace of the user
     */
    public double getMoney() {
        return money;
    }

    /**
     * @return the user's number of rentings
     */
    public int getNumberOfRentings() {
        return numberOfRentings;
    }

    /**
     * @return the time the user spent on a electical bicycle
     */
    public double getTimeSpentOnElectricalBicycle() {
        return timeSpentOnElectricalBicycle;
    }

    /**
     * @return the time the user spent on a mechanical bicycle
     */
    public double getTimeSpentOnMechanicalBicycle() {
        return timeSpentOnMechanicalBicycle;
    }

    // Setters

    /**
     * Update the name of the user
     *
     * @param name name for the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Update the coordinate of the user
     *
     * @param coordinate coordinate that the user will be created
     */
    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Update the card of the user
     *
     * @param card a card that will be used to set the user's card
     */
    public void setCard(Card card) {
        this.card = card;
    }

    /**
     * Update the credit card number of the user
     *
     * @param creditCardNumber a credit card number
     */
    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * Update the time credit balance of the user
     *
     * @param timeCreditBalance a double that represents the time credit balance (in minutes)
     */
    public void setTimeCreditBalance(float timeCreditBalance) {
        this.timeCreditBalance = timeCreditBalance;
    }

    /**
     * Update the value of all money the user has been charged
     *
     * @param allMoneyCharged the value of all money the user has been charged
     */
    public void setAllMoneyCharged(float allMoneyCharged) {
        this.allMoneyCharged = allMoneyCharged;
    }

    /**
     * Update the current money the user is charged
     *
     * @param currentMoneyCharged the current money the user is charged
     */
    public void setCurrentMoneyCharged(float currentMoneyCharged) {
        this.currentMoneyCharged = currentMoneyCharged;
    }

    /**
     * Update the bicycle of the user
     *
     * @param bicycle the bicycle of the user (can be none)
     */
    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    /**
     * Update the last renting station ID of the user
     *
     * @param rentStationID the last renting station ID of the user
     */
    public void setRentStationID(int rentStationID) {
        this.rentStationID = rentStationID;
    }

    /**
     * Update the actual renting time of the user
     *
     * @param rentTime the actual renting time of the user
     */
    public void setRentTime(LocalTime rentTime) {
        this.rentTime = rentTime;
    }

    /**
     * Update the money balance of the user
     *
     * @param money the money balance of the user
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * Update the number of rentings of the user
     *
     * @param numberOfRentings the number of rentings of the user
     */
    public void setNumberOfRentings(int numberOfRentings) {
        this.numberOfRentings = numberOfRentings;
    }

    /**
     * Update the time spent by the user on electrical bicycle
     *
     * @param timeSpentOnElectricalBicycle the time spent by the user on electrical bicycle
     */
    public void setTimeSpentOnElectricalBicycle(double timeSpentOnElectricalBicycle) {
        this.timeSpentOnElectricalBicycle = timeSpentOnElectricalBicycle;
    }

    /**
     * Update the time spent by the user on mechanical bicycle
     *
     * @param timeSpentOnMechanicalBicycle the time spent by the user on mechanical bicycle
     */
    public void setTimeSpentOnMechanicalBicycle(double timeSpentOnMechanicalBicycle) {
        this.timeSpentOnMechanicalBicycle = timeSpentOnMechanicalBicycle;
    }

    /**
     * toString method for user
     *
     * @return a message that represent the user object
     */
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

    /**
     * equals method for the user
     *
     * @param o an object
     * @return true, if the two objects are "equal". false, otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    /**
     * hashCode method for user
     *
     * @return hash(id, name, coordinate, card, creditCardNumber, timeCreditBalance, allMoneyCharged, currentMoneyCharged)
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinate, card, creditCardNumber, timeCreditBalance, allMoneyCharged, currentMoneyCharged);
    }

    // Written methods

    /**
     * Add a new card for the user
     *
     * @param cardType a string for the card type (Can be Vmax, Vlibre or none)
     */
    public void addCard(String cardType) {

        if (cardType.equals("Vlible")) {
            this.card = new Vlibre();
        } else if (cardType.equals("Vmax")) {
            this.card = new Vmax();
        } else {
            System.out.println("Error! The type does not exist.");
        }
    }

    /**
     * Add money balance
     *
     * @param money the money that will be added
     */
    public void addMoney(double money) {
        this.money += money;
    }

    /**
     * Remove money balance after droping the bicycle
     *
     * @param money the money that will be removed
     */
    public void removeMoney(double money) {
        if (this.money - money < 0) {
            System.out.println("ATTENTION! You are negative.");
        }
        this.money -= money;

    }

    /**
     * Add some time credit after the user had dropped the bicycle in a good station
     *
     * @param time some time credit (in minutes)
     */
    public void addTimeCredit(double time) {
        this.timeCreditBalance += time;
    }

    /**
     * Remove time balance after the computation of the location cost
     *
     * @param time time balance after the computation of the location cost
     */
    public void removeTimeCredit(double time) {
        if (this.timeCreditBalance - time < 0) {
            System.out.println("You cannot have a negative time credit balance!");
        } else {
            this.timeCreditBalance -= time;
        }

    }

    /**
     * Renting a bicycle
     *
     * @param system:      the system the user is using
     * @param coordsStart: the coordinate where the user want to start
     * @param coordsEnd:   the coordinate wher the user want to finish his location
     * @param bicycle:     the bicycle the user wants to rent
     */
    public void rentBicyclePlanning(MyVelibSystem system, Point coordsStart, Point coordsEnd, Bicycle bicycle) {
        List<Station> allStations;
        Terminal termStart;

        // Get best start and end stations
        allStations = PlanningApp.getBestStation(system, coordsStart, coordsEnd, bicycle);
//        System.out.println(allStations);  // [null, null]
        // Get terminals of start and end stations
        termStart = allStations.get(0).getStationTerminal();
//        System.out.println(termStart);
        // Rent on terminal start
        termStart.rentBicycle(bicycle, this, allStations.get(0));

        // Drop on terminal end ? How can we know the time ?
    }

    // TODO: Refactor this method (we need to divide this method - start and end stations)
    // TODO: Remove bicycle, because it is redundant

    /**
     * Dropping a bicycle after using it
     *
     * @param system:      the system the user is using
     * @param coordsStart: the coordinate where the user want to start
     * @param coordsEnd:   the coordinate wher the user want to finish his location
     */
    public void dropBicyclePlanning(MyVelibSystem system, Point coordsStart, Point coordsEnd) {
        List<Station> allStations;
        Terminal termEnd;
        Bicycle bicycle = this.bicycle;

        // Check if the user has indeed a bicycle
        if (this.bicycle == null) {
            System.out.println("You have not a bicycle!!!");
        } else {
            // Get best start and end stations
            allStations = PlanningApp.getBestStation(system, coordsStart, coordsEnd, this.bicycle);

            // Get terminals of start and end stations
            termEnd = allStations.get(1).getStationTerminal();
            // Rent on terminal start
            termEnd.dropBicycle(bicycle, this, allStations.get(1));

            // Drop on terminal end ? How can we know the time ?
        }


    }

    /**
     * Droping a bicycle after using it
     *
     * @param system:         the system the user is using
     * @param coordsStart:    the coordinate where the user want to start
     * @param coordsEnd:      the coordinate wher the user want to finish his location
     * @param intervalOfTime: the interval of time the user used the bicycle between the renting and the droping
     */
    public void dropBicyclePlanningWithIntervalOfTime(MyVelibSystem system, Point coordsStart, Point coordsEnd, double intervalOfTime) {
        List<Station> allStations;
        Terminal termEnd;
        Bicycle bicycle = this.bicycle;

        // Check if the user has indeed a bicycle
        if (this.bicycle == null) {
            System.out.println("You have not a bicycle!!!");
        } else {
            // Get best start and end stations
            allStations = PlanningApp.getBestStation(system, coordsStart, coordsEnd, this.bicycle);

            // Get terminals of start and end stations
            termEnd = allStations.get(1).getStationTerminal();
            // Rent on terminal start
            termEnd.dropBicycleWithIntervalOfTime(bicycle, this, allStations.get(1), intervalOfTime);

            // Drop on terminal end ? How can we know the time ?
        }


    }

    /**
     * Increment number of rentings by one
     * It used to compute statistics
     */
    public void addRenting() {
        this.numberOfRentings += 1;
    }

    /**
     * Update the time spent on electrical bicycles
     *
     * @param intervalOfTime an interval of time (in minutes)
     */
    public void addSpentTimeOnElectricalBicycle(double intervalOfTime) {
        this.timeSpentOnElectricalBicycle += intervalOfTime;
    }

    /**
     * Update the time spent on mechanical bicycles
     *
     * @param intervalOfTime an interval of time (in minutes)
     */
    public void addSpentTimeOnMechanicalBicycle(double intervalOfTime) {
        this.timeSpentOnMechanicalBicycle += intervalOfTime;
    }

    /**
     * Used to see the status of the user
     * @return
     */
    public String seeMyStatus() {
        System.out.println(this);
        return this.toString();
    }

    /**
     * @param system: the system the user is using
     * @param userID: the ID the user wants to see
     */
    public String seeCurrentStatus(MyVelibSystem system, int userID) {
        if (this.id == userID) {
            this.seeMyStatus();
            System.out.println();
        } else {
            System.out.println("You are not allowed to see other people information!");
            System.out.println("Please ask a manager for this information!");
            System.out.println();
        }

        return this.toString();

    }

    /**
     * Used to see the state of an existing station
     *
     * @param system:    the system the user is using
     * @param stationID: the station id the user wants to see
     */
    public String seeCurrentStationState(MyVelibSystem system, int stationID) {
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
        return currentStation.toString();
        }

        return "";

    }

    /**
     * Used to display the system the user is using
     *
     * @param system: the system the user is using
     */
    public String displaySystemReport(MyVelibSystem system) {
        if (system.getUsers().contains(this)) {
            System.out.println();
            System.out.println("SYSTEM REPORT");
            System.out.println(system);
            System.out.println();

            return system.toString();
        }
        return "";
    }


}
