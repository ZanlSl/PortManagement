package PortManagement;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

//        Container container = new Container("101", 13.0, "OpenSide");
//        Vehicle vehicle = new Vehicle("1", "reefer truck", 100.0, 100.0, 100.0,null);
//        vehicle.load(container);
//        System.out.println(vehicle);
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println("Current date and time: " + now);
        Container container1 = new Container("C1", 1000.0, "Refrigerated");

        // Create a new Port
        Port port1 = new Port("P1", "Port1", 10.0, 10.0, 2.0, true);

        // Add the Container to the Port
        port1.addContainer(container1);
        System.out.println(port1);

        // Create a new Reefer Truck
        Vehicle reeferTruck = new Vehicle("T1", "reefer truck", 2000.0, 100.0, 50.0, port1);

        // Load the Container onto the Reefer Truck
        port1.load(reeferTruck, container1);
        System.out.println(port1);
        // Unload the Container from the Reefer Truck
        reeferTruck.unload(container1);
    }
}