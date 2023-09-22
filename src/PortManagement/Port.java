package PortManagement;

// Class representing a Port
public class Port {
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private int storingCapacity;
    private boolean landingAbility;

    // Constructor, getters, and setters for Port
    public Port (String id, String name, double latitude, double longitude, int storingCapacity, boolean landingAbility){
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.storingCapacity = storingCapacity;
        this.landingAbility = landingAbility;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setStoringCapacity(int storingCapacity) {
        this.storingCapacity = storingCapacity;
    }

    public void setLandingAbility(boolean landingAbility) {
        this.landingAbility = landingAbility;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getStoringCapacity() {
        return storingCapacity;
    }

    public boolean isLandingAbility() {
        return landingAbility;
    }

    public String toString() {
        return id + ";"+ name+ ";"+ latitude+ ";"  + longitude+ ";" + storingCapacity+ ";" + landingAbility ;
    }
}
