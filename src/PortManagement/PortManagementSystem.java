package PortManagement;

import java.util.ArrayList;
import java.util.List;

public class PortManagementSystem {

        // Sample data initialization
        List<Port> ports = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        List<Container> containers = new ArrayList<>();
        List<Trip> trips = new ArrayList<>();}

        // Implement the main application logic here
//        public void deletePortById(String id) {
//            Port portToRemove = null;
//            for (Port port : ports) {
//                if (port.getId().equals(id)) {
//                    portToRemove = port;
//                    break; // Exit the loop once the matching Port is found
//                }
//            }
//
//            if (portToRemove != null) {
//                ports.remove(portToRemove);
//                System.out.println("Port with ID " + id + " has been removed.");
//                writePorts.writePorts(); // Update the file after removing the Port
//            } else {
//                System.out.println("Port with ID " + id + " not found.");
//            }
//        }
//
//    // Load existing Ports from the file
//    private void loadPortsFromFile() {
//        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(",");
//                if (parts.length >= 2) {
//                    String id = parts[0];
//                    String name = parts[1];
//                    // Create a Port object and add it to the list
//                    ports.add(new Port(id, name));
//                }
//            }
//        } catch (FileNotFoundException e) {
//            // Handle file not found exception
//        }
//    }
//}

