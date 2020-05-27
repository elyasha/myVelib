package core.components;

public final class Terminal {

    private boolean onService;

    public Terminal() {
        this.onService = false; // It won't work by default
    }

    public Terminal(boolean onService) {
        this.onService = onService;
    }


    // Getters and setters

    public boolean isOnService() {
        return onService;
    }

    public void setOnService(boolean onService) {
        this.onService = onService;
    }


    // Written methods

    public void rentBicycle(Bicycle bicycle, User user) {
        // Planning checks if there is a bicycle, we don't need to check again

        // If there is a bicycle available
        System.out.println("Here you go!" + user);
        if (bicycle instanceof ElectricalBicycle) {
            System.out.println("A electrical bicycle!");
        } else if (bicycle instanceof MechanicalBicycle) {
            System.out.println("A mechanical bicycle!");
        }

    }

    public void dropBicycle(Bicycle bicycle, User user) {
        // No need to check if there is a free spot


        // Return bicycle
        System.out.println(user + "You rent is finalized!");
    }

}
