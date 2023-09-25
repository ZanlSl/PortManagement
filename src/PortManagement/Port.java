package PortManagement;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;




public class Port implements  PortInterface {
    private String ID;

    private String name;
    private double latitude;
    private double longitude;
    private double currentCapacity;
    private double totalCapacity;
    private boolean landingAbility;
    private ArrayList<Container> containers;
    private ArrayList<Vehicle> vehicles;
    public static TreeMap<String, Port> allPort = new TreeMap<>();
    private static int idCounter;
    public Port(){
        if (!allPort.isEmpty()) {
            String lastKey = allPort.lastKey();
            idCounter = Integer.parseInt(lastKey.substring(1));

        } else
            idCounter = 100;
        this.ID = "P" + (++idCounter); // Increment the counter and prepend "Tr"
        containers = new ArrayList<>();
        vehicles = new ArrayList<>();
        allPort.put(this.ID, this); // Add the item to the map when it's created


    }


    public Port(String Id, String name, double latitude, double longitude, double totalCapacity, boolean landingAbility) {
        this.ID = Id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.totalCapacity = totalCapacity;
        this.landingAbility = landingAbility;
        containers = new ArrayList<>();
        vehicles = new ArrayList<>();
        updateCurrentCapacity();
        allPort.put(this.ID,this);
    }

    public void load(Vehicle vehicle, Container container) {
        if (containers.contains(container)) {
            container.setPosition(vehicle.getID());
            vehicle.load(container);
            containers.remove(container);
            updateCurrentCapacity();
        } else {
            System.out.println("This port does not have the specified container");
        }
    }

    public void updateCurrentCapacity() {
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
    public void removeContainer(Container container) {
        if (containers.contains(container)) {
            containers.remove(container);
            System.out.println("Container has been removed from the port.");
            updateCurrentCapacity();
        } else {
            System.out.println("This container is not at the port.");
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
    public static void removePort(String id) {
        if (allPort.containsKey(id)) {
            allPort.remove(id);
            System.out.println("Port with ID: " + id + " has been removed.");
        } else {
            System.out.println("No port found with ID: " + id);
        }
    }
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        if (vehicles.contains(vehicle)) {
            vehicles.remove(vehicle);
            System.out.println("Vehicle has been removed from the port.");
        } else {
            System.out.println("This vehicle is not at the port.");
        }
    }

    public void listContainers() {
        System.out.println("Listing all containers in the port:");
        for (Container container : this.containers) {
            System.out.println(container);
        }}
    public void listAllPort(){
        for (Map.Entry<String, Port> entry : allPort.entrySet()) {
            System.out.println("Port ID = " + entry.getKey() + ", Port = " + entry.getValue());
        }
    }
    public void listAllVehiclesOfType(String type){
        System.out.println("Listing all vehicles of input in the port:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals(type)){
                 System.out.println(vehicle);
            }
    }}




    public String getId() {
        return ID;
    }

    public void setId(String Id) {
        this.ID = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setCurrentCapacity(double currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public void setTotalCapacity(double totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public boolean isLandingAbility() {
        return landingAbility;
    }

    public void setLandingAbility(boolean landingAbility) {
        this.landingAbility = landingAbility;
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public void setContainers(ArrayList<Container> containers) {
        this.containers = containers;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public static int getIdCounter() {
        return idCounter;
    }




    // getters and setters for each field can be added here
    // getter for currentCapacity and totalCapacity
    public double getCurrentCapacity() {
        return currentCapacity;
    }

    public double getTotalCapacity() {
        return totalCapacity;
    }
    public static ArrayList<Port> getAllPortsAsList() {
        return new ArrayList<>(allPort.values());
    }

    @Override
    public String toString() {
        return "Port{" +

                "ID='" + ID + ";"+ name+ ";"+ latitude+ ";"  + longitude+ ";" + totalCapacity+ ";" + landingAbility +
                ";"+ containers +
                ";"+ vehicles ;

    }








}
