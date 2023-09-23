package PortManagement;

import java.util.ArrayList;

public class Port {
    private String ID;
    private String name;
    private double latitude;
    private double longitude;
    private double currentCapacity;
    private double totalCapacity;
    private boolean landingAbility;
    private ArrayList<Container> containers;
    private ArrayList<Vehicle> vehicles;

    public Port(String ID, String name, double latitude, double longitude, double totalCapacity, boolean landingAbility) {
        this.ID = ID;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.totalCapacity = totalCapacity;
        this.landingAbility = landingAbility;
        this.containers = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        updateCurrentCapacity();
    }


    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void load(Vehicle vehicle, Container container) {
        if (containers.contains(container)) {
            vehicle.load(container);
            containers.remove(container);
            updateCurrentCapacity();
        } else {
            System.out.println("This port does not have the specified container");
        }
    }

    private void updateCurrentCapacity() {
        currentCapacity = 0.0;
        for (Container container : containers) {
            currentCapacity += container.getWeight();
        }
    }
    public void addContainer(Container container) {
        if (currentCapacity + container.getWeight() <= totalCapacity) {
            containers.add(container);
            updateCurrentCapacity();
        } else {
            System.out.println("The port is at full capacity");
        }
    }
    public double calculateDistance(Port other) {
        double R = 6371.0; // Radius of the earth in km
        double latDistance = Math.toRadians(other.latitude - this.latitude);
        double lonDistance = Math.toRadians(other.longitude - this.longitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(other.latitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        return distance;
    }



    // getters and setters for each field can be added here
    // getter for currentCapacity and totalCapacity
    public double getCurrentCapacity() {
        return currentCapacity;
    }

    public double getTotalCapacity() {
        return totalCapacity;
    }

    @Override
    public String toString() {
        return "Port{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", currentCapacity=" + currentCapacity +
                ", totalCapacity=" + totalCapacity +
                ", landingAbility=" + landingAbility +
                ", containers=" + containers +
                ", vehicles=" + vehicles +
                '}';
    }
}