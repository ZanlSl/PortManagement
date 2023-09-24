package PortManagement;
import java.util.LinkedList;


import java.util.List;
import java.util.Objects;
import java.util.Scanner;


// Java Program to Illustrate StudentRecordLinkedList Class



// Importing required classes


// Java Program to Illustrate StudentRecordManagement Class



// Importing required classes


import java.time.LocalDateTime;
import java.util.Map;

import static PortManagement.Port.allPort;
import static PortManagement.Vehicle.allVehicle;


public class Main {
    private final Port Port;

    public Main() {
        // Initialize the readPorts object here or in the constructor
        Port  = new Port();
    } 
        public static void main (String[]args){
            Main m = new Main();
            List<Port> list = PortManagement.Port.readPorts();

            for (Port Port : list) {
                System.out.println(Port);
            }


        Container container = new Container("101", 13.0, "OpenSide");
        Vehicle vehicle = new Vehicle("1", "reefer truck", 100.0, 100.0, 100.0,null);
        System.out.println(vehicle);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current date and time: " + now);

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



        Container container1 = new Container("c101", 1000.0, "Refrigerated",null);
        System.out.println(container1);
        // Create a new Port
        Port port1 = new Port("P101", "Port1", 10.0, 10.0, 2000000, true);
        Vehicle reeferTruck = new Vehicle("tr101", "reefer truck", 2000.0, 100.0, 50.0, port1,null);
        System.out.println(reeferTruck);
        // Add the Container to the Port
        port1.addContainer(container1);
        System.out.println(port1);

        // Load the Container onto the Reefer Truc
        // Unload the Container from the Reefer Truck
        vehicle.load(container);
        port1.load(reeferTruck, container1);
        reeferTruck.unload();



        Port port2= new Port();
        System.out.println("This is port list");
        System.out.println(allPort);
        for (Map.Entry<String, Port> entry : allPort.entrySet()) {
            System.out.println("Port ID = " + entry.getKey() + ", Port = " + entry.getValue());
        }

        System.out.println("This is vehicle");
        Vehicle vehicle2= new Vehicle();
        vehicle2.setType("ship");
        vehicle2.setID();

        System.out.println(allVehicle);
//        System.out.println("This is port");
////        port1.addContainer(container1);
//        System.out.println(port1);
//        port1.listContainers();
        System.out.println("vehicle before move");
//        port2.addVehicle(vehicle2);
        vehicle2.moveTo(port2);
        System.out.println(vehicle2);

        port2.listAllVehiclesOfType("ship");

        port2.listContainers();
        port2.listAllPort();


    }


