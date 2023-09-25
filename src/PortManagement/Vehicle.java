package PortManagement;



import PortManagement.Container;

import java.util.ArrayList;
import java.util.TreeMap;


public class Vehicle implements  VehicleInterface {
    private String ID;
    private String Type;

    private Container container;

    private double carryingCapacity;
    private double fuelCapacity;
    private double currentFuel;
    private Port currentPort;

    public static TreeMap<String, Vehicle> allVehicle = new TreeMap<>();
    private static int idCounter;


    public Vehicle() {
        this.container = null;
        this.setCurrentFuel(0);

        allVehicle.put("temp", this);


        // If the vehicle doesn't have the container, try to load it

    }

    public Vehicle(String ID, String Type, double carryingCapacity, double fuelCapacity, double currentFuel, Port currentPort, Container container) {
        this.ID = ID;
        this.Type = Type;
        this.container = container;
        this.carryingCapacity = carryingCapacity;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = currentFuel;
        this.currentPort = currentPort;
        allVehicle.put(this.ID, this);


    }


    public void moveTo(Port port) {
        if (this.currentPort != null) {
            this.currentPort.removeVehicle(this);
        }
        this.currentPort = port;
        port.addVehicle(this);

    }

    public void checkFuel() {
        if (this.getCurrentFuel() < 2.0) {
            System.out.println("The vehicle does not have enough fuel for this trip");
        } else {
            return;
        }
    }

    public void reFuel(double fuelAmount) {
        double after = this.currentFuel + fuelAmount;
        if (after <= this.fuelCapacity){
            setCurrentFuel(fuelAmount);
    }else {
            System.out.println("Exceed total fuel capacity");
        }
}
    public void load(Container container) {
        if (this.container == null) {
            if (container.getWeight() <= carryingCapacity) {
                if (Type.equals("ship")) {
                    this.container = container;
                } else if (Type.equals("truck")) {
                    String containerType = container.getType();
                    if (containerType.equals("DryStorage") || containerType.equals("OpenTop") || containerType.equals("OpenSide")) {
                        this.container = container;
                    } else {
                        System.out.println("This truck can only carry dry storage, open top, and open side containers");
                    }
                } else if (Type.equals("reefer_truck")) {
                    if (container.getType().equals("Refrigerated") || container.getType().equals("DryStorage") || container.getType().equals("OpenTop") || container.getType().equals("OpenSide")) {
                        this.container = container;
                    } else {
                        System.out.println("This reefer truck cannot carry this type of container");
                    }
                } else if (Type.equals("tanker_truck")) {
                    if (container.getType().equals("Liquid") || container.getType().equals("DryStorage") || container.getType().equals("OpenTop") || container.getType().equals("OpenSide")) {
                        this.container = container;
                    } else {
                        System.out.println("This tanker truck cannot carry this type of container");
                    }
                } else {
                    System.out.println("Invalid vehicle type");
                }
            } else {
                System.out.println("Vehicle is at full capacity");
            }
        } else {
            System.out.println("This vehicle already has a container");
        }
    }

    public void unload() {
        if (container != null) {
            if (currentPort.getCurrentCapacity() + container.getWeight() <= currentPort.getTotalCapacity()) {
                currentPort.addContainer(container);
                container.setPosition(currentPort.getId());
                this.container = null;
            } else {
                System.out.println("The port is at full capacity");
            }
        } else {
            System.out.println("This vehicle does not have a container");
        }
    }

    public String getID() {
                return ID;
            }

    public void setID() {
        if (allVehicle.size()!=1) {
            String lastKey = allVehicle.lastKey();
            idCounter = Integer.parseInt(lastKey.substring(2));

        } else
            idCounter = 100;
        if (this.Type.equals("ship")){
            this.ID = "sh" + (++idCounter); // Increment the counter and prepend "Tr"

        }else {
            this.ID = "tr" + (++idCounter); // Increment the counter and prepend "Tr"
        }
        System.out.println("thisID is:"+this.ID);
        allVehicle.put( this.ID, allVehicle.get("temp"));
        allVehicle.remove("temp");


    }


    public String getType() {
        return Type;
    }

    public String setType(String type) {
        Type = type;
        setID();
        return this.ID;
    }


    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
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

    public static int getIdCounter() {
        return idCounter;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "ID='" + ID +
                ", Type='" + Type  +
                ", container=" + container +
                ", carryingCapacity=" + carryingCapacity +
                ", fuelCapacity=" + fuelCapacity +
                ", currentFuel=" + currentFuel +
                ", currentPort=" + currentPort+
                '}';
    }

    public void unload(Container container1) {
    }

    // getters and setters for each field can be added here
}

