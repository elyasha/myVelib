package core.components;


import java.util.Objects;

public class User {
    private final int id = generateUniqueID();
    private static int numberOfUsers = 0;

    private int generateUniqueID() {
        return ++numberOfUsers;
    }

    private String name;
    private String lastName;
    private double latitude;
    private double longitude;
    private Card userCard;
    private int creditCardNumber;
    private int registrationCard;
    private float timeCreditBalance = 0;  // [minutes]
    private float allMoneyCharged = 0;
    private float currentMoneyCharged;

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

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Card getUserCard() {
        return userCard;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getRegistrationCard() {
        return registrationCard;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setUserCard(Card userCard) {
        this.userCard = userCard;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setRegistrationCard(int registrationCard) {
        this.registrationCard = registrationCard;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", userCard=" + userCard +
                ", creditCardNumber=" + creditCardNumber +
                ", registrationCard=" + registrationCard +
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
        return id == user.id &&
                Double.compare(user.latitude, latitude) == 0 &&
                Double.compare(user.longitude, longitude) == 0 &&
                creditCardNumber == user.creditCardNumber &&
                registrationCard == user.registrationCard &&
                Float.compare(user.timeCreditBalance, timeCreditBalance) == 0 &&
                Float.compare(user.allMoneyCharged, allMoneyCharged) == 0 &&
                Float.compare(user.currentMoneyCharged, currentMoneyCharged) == 0 &&
                Objects.equals(name, user.name) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userCard, user.userCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, latitude, longitude, userCard, creditCardNumber, registrationCard, timeCreditBalance, allMoneyCharged, currentMoneyCharged);
    }
}
