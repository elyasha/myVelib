package core.components;


import java.awt.*;
import java.time.LocalTime;
import java.util.Objects;

public class User {
    private final int id = generateUniqueID();
    private static int numberOfUsers = 0;

    private int generateUniqueID() {
        return ++numberOfUsers;
    }

    private String name;
    private String lastName;
    private Point coordinate;
    private Card card; // registration card
    private int creditCardNumber;
    private float timeCreditBalance = 0;  // [minutes]
    private float allMoneyCharged = 0;
    private float currentMoneyCharged = 0;
    private boolean hasBicycle;
    private int rentStationID;
    private LocalTime rentTime; // [minutes]


    // Constructor

    public User(String name, String lastName, Point coordinate, int creditCardNumber) {
        this.name = name;
        this.lastName = lastName;
        this.coordinate = coordinate;
        this.creditCardNumber = creditCardNumber;
        this.card = null;
        this.timeCreditBalance = 0;
        this.allMoneyCharged = 0;
        this.currentMoneyCharged = 0;
        this.hasBicycle = false;
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

    public String getLastName() {
        return lastName;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public Card getCard() {
        return card;
    }

    public int getCreditCardNumber() {
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

    public boolean isHasBicycle() {
        return hasBicycle;
    }

    public int getRentStationID() {
        return rentStationID;
    }

    public LocalTime getRentTime() {
        return rentTime;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setCreditCardNumber(int creditCardNumber) {
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

    public void setHasBicycle(boolean hasBicycle) {
        this.hasBicycle = hasBicycle;
    }

    public void setRentStationID(int rentStationID) {
        this.rentStationID = rentStationID;
    }

    public void setRentTime(LocalTime rentTime) {
        this.rentTime = rentTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
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
        return Objects.hash(id, name, lastName, coordinate, card, creditCardNumber, timeCreditBalance, allMoneyCharged, currentMoneyCharged);
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




}
