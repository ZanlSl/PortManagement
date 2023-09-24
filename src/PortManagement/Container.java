package PortManagement;
import java.util.ArrayList;
import java.util.TreeMap;






public class Container implements ContainerInterface{

    private String ID;
    private double weight;
    private String type;
    private double shipFuelWeightKm;
    private double truckFuelWeightKm;
    private String position;
    public static TreeMap<String, Container> allContainer = new TreeMap<>();
    private static int idCounter;



    public Container(){
        if (!allContainer.isEmpty()) {
            String lastKey = allContainer.lastKey();
            idCounter = Integer.parseInt(lastKey.substring(1));

        } else
            idCounter = 100;
        this.ID = "c" + (++idCounter); // Increment the counter and prepend "Tr"
        allContainer.put(this.ID, this); // Add the item to the map when it's created

    }
    public Container(String ID, double weight, String type, String position) {
        this.ID = ID;
        this.weight = weight;
        this.type = type;
        this.position= position;
        setFuelWeightKm();
        allContainer.put(this.ID, this); // Add the item to the map when it's created

    }



    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void setFuelWeightKm() {
        switch (type) {
            case "DryStorage":
                shipFuelWeightKm = 3.5;
                truckFuelWeightKm = 4.6;
                break;
            case "OpenTop":
                shipFuelWeightKm = 2.8;
                truckFuelWeightKm = 3.2;
                break;
            case "OpenSide":
                shipFuelWeightKm = 2.7;
                truckFuelWeightKm = 3.2;
                break;
            case "Refrigerated":
                shipFuelWeightKm = 4.5;
                truckFuelWeightKm = 5.4;
                break;
            case "Liquid":
                shipFuelWeightKm = 4.8;
                truckFuelWeightKm = 5.3;
                break;
            default:
                System.out.println("Invalid container type");
        }
    }
    public double totalWeightCalculateByType(String type){
        double totalWeight = 0;
        for (Container container : allContainer.values()) {
            if (container.type.equals(type)) {
                totalWeight += container.weight;
            }
        }
        return totalWeight;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        setFuelWeightKm();
    }

    public double getShipFuelWeightKm() {
        return shipFuelWeightKm;
    }

    public void setShipFuelWeightKm(double shipFuelWeightKm) {
        this.shipFuelWeightKm = shipFuelWeightKm;
    }

    public double getTruckFuelWeightKm() {
        return truckFuelWeightKm;
    }

    public void setTruckFuelWeightKm(double truckFuelWeightKm) {
        this.truckFuelWeightKm = truckFuelWeightKm;
    }

    public static int getIdCounter() {
        return idCounter;
    }
    public static ArrayList<Container> getAllContainersAsList(){
        return new ArrayList<>(allContainer.values());
    }

    @Override
    public String toString() {
        return "Container{" +
                "ID='" + ID + '\'' +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                ", shipFuelWeightKm=" + shipFuelWeightKm +
                ", truckFuelWeightKm=" + truckFuelWeightKm +
                ", position=" + (position) +
                '}';
    }

    // getters and setters for each field can be added here



}
    // getters and setters for each field can be added here

