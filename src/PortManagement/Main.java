package PortManagement;
import java.util.LinkedList;


import java.util.List;
import java.util.Objects;
import java.util.Scanner;


// Java Program to Illustrate StudentRecordLinkedList Class



// Importing required classes


// Java Program to Illustrate StudentRecordManagement Class



// Importing required classes


public class Main {
    private final Port Port;

    public Main() {
        // Initialize the readPorts object here or in the constructor
        Port  = new Port();
    } // Replace 'ReadPorts' with your actual class name
        public static void main (String[]args){
            Main m = new Main();
            List<Port> list = PortManagement.Port.readPorts();

            for (Port Port : list) {
                System.out.println(Port);
            }


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