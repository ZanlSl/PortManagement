package PortManagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// Class
public class PortRecordLinkedList {
    static PortManagementSystem portManagementSystem = new PortManagementSystem();
    private static Scanner scanner = new Scanner(System.in);
    static List<Port> list = new ArrayList<>();
    // Main driver method
    public static void main(String[] args) {
////        public static void addPort() {
//            LocalDateTime now = LocalDateTime.now();
//            LocalDateTime threshold = now.minusDays(7); // Calculate the threshold date
//
//            // Remove the record if it's older than 7 days
//            list.removeIf(port -> port.getTimestamp().isBefore(threshold));
//
//            List<Port> list = new ArrayList<>();
//            System.out.print("Enter the Id for the new port: ");
//            String ID = scanner.nextLine();
//            System.out.print("Enter the name for the new port: ");
//            String name = scanner.nextLine();
//            System.out.print("Enter the latitude for the new port: ");
//            double latitude = scanner.nextDouble();
//            System.out.print("Enter the longitude for the new port: ");
//            double longtitude = scanner.nextDouble();
//            System.out.print("Enter the total capacity for the new port: ");
//            double totalCapacity = scanner.nextDouble();
//            System.out.print("Enter the landing ability for the new port: ");
//            boolean landingAbility = scanner.nextBoolean();
//            Port port = new Port(ID, name, latitude, longtitude, totalCapacity, landingAbility);
//            list.add(port);
//            PortManagementSystem.writePorts(list, "ports.txt");
//        }



        Main m = new Main();
        List<Vehicle> list = m.PortManagementSystem.readVehicles();

        for (Vehicle o : list) {
            System.out.println(o);
        }
//        PortManagementSystem.addVehicle();
    }
}
