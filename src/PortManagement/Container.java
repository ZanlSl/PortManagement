package PortManagement;


public class Container {
    private String ID;
    private double weight;
    private String type;
    private double shipFuelWeightKm;
    private double truckFuelWeightKm;

    public Container(String ID, double weight, String type) {
        this.ID = ID;
        this.weight = weight;
        this.type = type;
        setFuelWeightKm();
    }

    private void setFuelWeightKm() {
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

    @Override
    public String toString() {
        return "Container{" +
                "ID='" + ID + '\'' +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                ", shipFuelWeightKm=" + shipFuelWeightKm +
                ", truckFuelWeightKm=" + truckFuelWeightKm +
                '}';
    }
    // getters and setters for each field can be added here

}
