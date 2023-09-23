package PortManagement;

import PortManagement.Container;

import java.util.ArrayList;

public class Vehicle {
    private String ID;
    private String Type;
    private ArrayList<Container> Containers;
    private double carryingCapacity;
    private double fuelCapacity;
    private double currentFuel;
    private Port currentPort;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public ArrayList<Container> getContainers() {
        return Containers;
    }

    public void setContainers(ArrayList<Container> containers) {
        Containers = containers;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public Port getCurrentPort() {
        return currentPort;
    }

    public void setCurrentPort(Port currentPort) {
        this.currentPort = currentPort;
    }

    public Vehicle(String ID, String Type, double carryingCapacity, double fuelCapacity, double currentFuel, Port currentPort) {
        this.ID = ID;
        this.Type = Type;
        Containers = new ArrayList<>();
        this.carryingCapacity = carryingCapacity;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = currentFuel;
        this.currentPort = currentPort;

    }

    public void load(Container container) {
        double totalWeight = 0.0;
        for (Container c : Containers) {
            totalWeight += c.getWeight();
        }

        if (totalWeight + container.getWeight() <= carryingCapacity) {
            if (Type.equals("ship")) {
                Containers.add(container);
            } else if (Type.equals("truck")) {
                String containerType = container.getType();
                if (containerType.equals("DryStorage") || containerType.equals("OpenTop") || containerType.equals("OpenSide")) {
                    Containers.add(container);
                } else {
                    System.out.println("This truck can only carry dry storage, open top, and open side containers");
                }
            } else if (Type.equals("reefer truck")) {
                if (container.getType().equals("Refrigerated") || container.getType().equals("DryStorage") || container.getType().equals("OpenTop") || container.getType().equals("OpenSide")) {
                    Containers.add(container);
                } else {
                    System.out.println("This reefer truck cannot carry this type of container");
                }
            } else if (Type.equals("tanker truck")) {
                if (container.getType().equals("Liquid") || container.getType().equals("DryStorage") || container.getType().equals("OpenTop") || container.getType().equals("OpenSide")) {
                    Containers.add(container);
                } else {
                    System.out.println("This tanker truck cannot carry this type of container");
                }
            } else {
                System.out.println("Invalid vehicle type");
            }
        } else {
            System.out.println("Vehicle is at full capacity");
        }
    }
    public void unload(Container container) {
        if (Containers.contains(container)) {
            if (currentPort.getCurrentCapacity() + container.getWeight() <= currentPort.getTotalCapacity()) {
                Containers.remove(container);
                carryingCapacity += container.getWeight();
                currentPort.addContainer(container);
            } else {
                System.out.println("The port is at full capacity");
            }
        } else {
            System.out.println("This vehicle does not have the specified container");
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "ID='" + ID + '\'' +
                ", Type='" + Type + '\'' +
                ", Containers=" + Containers +
                ", carryingCapacity=" + carryingCapacity +
                ", fuelCapacity=" + fuelCapacity +
                ", currentFuel=" + currentFuel +
                ", currentPort=" + currentPort +
                '}';
    }
    // getters and setters for each field can be added here
}
