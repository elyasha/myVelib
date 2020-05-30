package core.components;
import core.rides.planning.Main;
import core.system.MyVelibSystem;

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
        }
        else if (cardType.equals("Vmax")) {
            this.card = new Vmax();
        }
        else {
            System.out.println("Error! The type does not exist.");
        }
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public void removeMoney(double money){
        if (this.money - money < 0) {
            System.out.println("ATTENTION! You are negative.");
        }
        this.money -= money;

    }

    public void addTimeCredit(double time){
        this.timeCreditBalance += time;
    }

    public void removeTimeCredit(double time) {
        if (this.timeCreditBalance - time < 0) {
            System.out.println("You cannot have a negative time credit balance!");
        }
        else {
            this.timeCreditBalance -= time;
        }

    }
    
    public void rentBicyclePlanning(MyVelibSystem system, Point coordsStart, Point coordsEnd, Bicycle bicycle) {
    	List<Station> allStations;
    	Terminal termStart;
    	
    	// Get best start and end stations
    	allStations = Main.getBestStation(system, coordsStart,coordsEnd,bicycle);
//        System.out.println(allStations);  // [null, null]
    	// Get terminals of start and end stations 
    	termStart = allStations.get(0).getStationTerminal();
//        System.out.println(termStart);
    	// Rent on terminal start
    	termStart.rentBicycle(bicycle, this, allStations.get(0));
    	
    	// Drop on terminal end ? How can we know the time ? 
    }

    public void dropBicyclePlanning(MyVelibSystem system, Point coordsStart, Point coordsEnd, Bicycle bicycle) {
        List<Station> allStations;
        Terminal termEnd;

        // Get best start and end stations
        allStations = Main.getBestStation(system, coordsStart,coordsEnd,bicycle);

        // Get terminals of start and end stations
        termEnd = allStations.get(1).getStationTerminal();
        // Rent on terminal start
        termEnd.dropBicycle(bicycle, this, allStations.get(1));

        // Drop on terminal end ? How can we know the time ?
    }



}
