package PortManagement;

import com.sun.jdi.Value;

import javax.swing.text.Position;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PortManagementSystem {

        // Sample data initialization
        List<Port> ports = Port.getAllPortsAsList();
        List<Vehicle> vehicles = new ArrayList<>();
        List<Container> containers = new ArrayList<>();
        List<Trip> trips = new ArrayList<>();
        static List<Port> list = new ArrayList<>();
        private static final Scanner scanner = new Scanner(System.in);
//        public static void addPort() {
//
//                LocalDateTime now = LocalDateTime.now();
//                LocalDateTime threshold = now.minusDays(7); // Calculate the threshold date
//
//                // Remove the record if it's older than 7 days
//                list.removeIf(port -> port.getTimestamp().isBefore(threshold));
//
//                List<Port> list = new ArrayList<>();
//                System.out.print("Enter the Id for the new port: ");
//                String ID = scanner.nextLine();
//                System.out.print("Enter the name for the new port: ");
//                String name = scanner.nextLine();
//                System.out.print("Enter the latitude for the new port: ");
//                double latitude = scanner.nextDouble();
//                System.out.print("Enter the longitude for the new port: ");
//                double longtitude = scanner.nextDouble();
//                System.out.print("Enter the total capacity for the new port: ");
//                double totalCapacity = scanner.nextDouble();
//                System.out.print("Enter the landing ability for the new port: ");
//                boolean landingAbility = scanner.nextBoolean();
//                Port port = new Port(ID, name, latitude, longtitude, totalCapacity, landingAbility);
//                list.add(port);
//                PortManagementSystem.writePorts(list, "ports.txt");
//        }
        public static void addVehicle() {

//                LocalDateTime now = LocalDateTime.now();
//                LocalDateTime threshold = now.minusDays(7); // Calculate the threshold date
//
//                // Remove the record if it's older than 7 days
//                list.removeIf(port -> port.getTimestamp().isBefore(threshold));

                List<Vehicle> list = new ArrayList<>();
                System.out.print("Enter the Id for the new vehicle: ");
                String ID = scanner.nextLine();
                System.out.print("Enter the type for the new vehicle: ");
                String type = scanner.nextLine();
                System.out.print("Enter the carrying capacity for the new vehicle: ");
                double carryingCapacity = scanner.nextDouble();
                System.out.print("Enter the fuel capacity for the new vehicle: ");
                double fuelCapacity = scanner.nextDouble();
                System.out.print("Enter the current fuel for the new vehicle: ");
                double currentFuel = scanner.nextDouble();
                System.out.print("Enter the current port for the new vehicle: ");
                int currentPortID = scanner.nextInt();
                System.out.print("Enter the container for the new vehicle: ");
                int containerID = scanner.nextInt();

                Port currentPort = Port.getAllPortsAsList().get(currentPortID);
                Container container = Container.getAllContainersAsList().get(containerID);
                Vehicle vehicle = new Vehicle(ID, type, carryingCapacity ,fuelCapacity, currentFuel, currentPort, container);
                list.add(vehicle);
                PortManagementSystem.writeVehicles(list, "vehicles.txt");
        }

        public static void writePorts(List<Port> list, String file) {
                try {
                        FileWriter fw = new FileWriter("ports.txt",true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (Port Port: list){
                                bw.write(Port.toString());
                                bw.newLine();
                        }
                        bw.close();
                        fw.close();
                }
                catch (Exception e) {
                        throw new RuntimeException(e);
                }
        }
        public static void writeVehicles(List<Vehicle> list, String file) {
                try {
                        FileWriter fw = new FileWriter("vehicles.txt");
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (Vehicle Vehicle: list){
                                bw.write(Vehicle.toString());
                                bw.newLine();
                        }
                        bw.close();
                        fw.close();
                }
                catch (Exception e) {
                        throw new RuntimeException(e);
                }
        }
        public static void writeContainers(List<Container> list, String file) {

                try {
                        FileWriter fw = new FileWriter("containers.txt",true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (Container Container: list){
                                bw.write(Container.toString());
                                bw.newLine();
                        }
                        bw.close();
                        fw.close();
                }
                catch (Exception e) {
                        throw new RuntimeException(e);
                }
        }

        public static List<Port> readPorts() {
                List<Port> list= new ArrayList<>();
                try {
                        FileReader fr = new FileReader("ports.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String line = "";
                        while (true){
                                line = br.readLine();
                                if (line == null) {
                                        break;
                                }
                                String[] txt = line.split(";");
                                String ID = txt[0];
                                String name = txt[1];
                                double latitude = Double.parseDouble (txt [2]);
                                double longtitude = Double.parseDouble (txt [3]);
                                double totalCapacity = Double.parseDouble (txt [4]);
                                boolean landingAbility = Boolean.parseBoolean (txt[5]);
                                Port port = new Port(ID, name, latitude, longtitude, totalCapacity, landingAbility);
                                list.add(port);
                        }
                }catch (Exception e){}
                return list;
        }
                public static List<Vehicle> readVehicles() {
                        List<Vehicle> list= new ArrayList<>();
                        try {
                                FileReader fr = new FileReader("vehicles.txt");
                                BufferedReader br = new BufferedReader(fr);
                                String line = "";
                                while (true) {
                                        line = br.readLine();
                                        if (line == null) {
                                                break;
                                        }
                                        String[] txt = line.split(";");
                                        String ID = txt[0];
                                        String Type = txt[1];
                                        String containerID = (txt[2]);
                                        double carryingCapacity = Double.parseDouble(txt[3]);
                                        double fuelCapacity = Double.parseDouble(txt[4]);
                                        double currentFuel = Double.parseDouble(txt[5]);
                                        String currentPortID = (txt[6]);


                                        Port currentPort = null;
                                        for (Port port : Port.getAllPortsAsList()) {
                                                if (port.getId().equals(currentPortID)) {
                                                        currentPort = port;
                                                        break;
                                                }
                                        }

                                        Container container = null;
                                        for (Container c : Container.getAllContainersAsList()) {
                                                if (c.getID().equals(containerID)) {
                                                        container = c;
                                                        break;
                                                }
                                        }

                                        if (currentPort != null && container != null) {
                                                list.add(new Vehicle(ID, Type, carryingCapacity, fuelCapacity, currentFuel, currentPort, container));
                                        } else {
                                                // Handle cases where Port or Container objects are not found


                                                list.add(new Vehicle(ID, Type, carryingCapacity, fuelCapacity, currentFuel, currentPort, container));
                                        }
                                }
                        }catch (Exception e){}
                        return list;
        }
        public static List<Container> readContainers() {
                List<Container> list= new ArrayList<>();

                try {
                        FileReader fr = new FileReader("containers.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String line = "";
                        while (true){
                                line = br.readLine();
                                if (line == null) {
                                        break;
                                }
                                String[] txt = line.split(";");
                                String ID = txt[0];
                                double weight = Double.parseDouble(txt[1]);
                                String type = txt [2];
                                double fuelCapacity = Double.parseDouble (txt [3]);
                                double currentFuel = Double.parseDouble (txt [4]);
                                String position =   txt[5];


                                list.add(new Container( ID,  weight,  type, fuelCapacity, currentFuel, position));
                        }
                }catch (Exception e){}
                return list;
        }


//         Implement the main application logic here
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
//                writePorts(ports, "data.txt"); // Update the file after removing the Port
//            } else {
//                System.out.println("Port with ID " + id + " not found.");
//            }
//        }

    // Load existing Ports from the file
//    private void loadPortsFromFile() {
//        try (Scanner scanner = new Scanner(new File("data.txt")) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(",");
//                if (parts.length >= 6) {
//                    String Id = parts[0];
//                    String name = parts[1];
//                    double latitude = Double.parseDouble(parts[2]);
//                    double longtitude = Double.parseDouble(parts[3]);
//                    double totalCapacity = Double.parseDouble(parts[4]);
//                    boolean landingAbility = Boolean.parseBoolean(parts [5]);
//                    // Create a Port object and add it to the list
//                    ports.add(new Port(Id, name,latitude,longtitude,totalCapacity,landingAbility));
//                }
//            }
//        } catch (FileNotFoundException e) {
//            // Handle file not found exception
//        }
//            private String portToString(Port port) {
//                    // Convert the Port object to a string format
//                    return port.getId() + "," + port.getName() + /* add other attributes */;
//            }

}

