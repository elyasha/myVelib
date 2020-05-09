package core.components;


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
    
    
}
