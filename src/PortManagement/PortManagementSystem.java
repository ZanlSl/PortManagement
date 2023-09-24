package PortManagement;

import com.sun.jdi.Value;

import javax.swing.text.Position;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PortManagementSystem {

        // Sample data initialization
        List<Port> ports = Port.getAllPortsAsList();
        List<Vehicle> vehicles = new ArrayList<>();
        List<Container> containers = new ArrayList<>();
        List<Trip> trips = new ArrayList<>();
        public static void writePorts(List<Port> list, String file) {
                try {
                        FileWriter fw = new FileWriter("ports.txt");
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
                        FileWriter fw = new FileWriter("containers.txt");
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (Container Container: list){
                                bw.write(Container.toString());
                                bw.write();
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
                                String txt[] = line.split(";");
                                String Id = txt[0];
                                String name = txt[1];
                                double latitude = Double.parseDouble (txt [2]);
                                double longtitude = Double.parseDouble (txt [3]);
                                int totalCapacity = Integer.parseInt (txt [4]);
                                boolean landingAbility = Boolean.parseBoolean (txt[5]);
                                list.add(new Port(Id, name, latitude, longtitude, totalCapacity, landingAbility));
                        }
                }catch (Exception e){}
                return list;
        }
                public static List<Vehicle> readVehicles() {
                        List<Vehicle> list= new ArrayList<>();
                        try {
                                FileReader fr = new FileReader("ports.txt");
                                BufferedReader br = new BufferedReader(fr);
                                String line = "";
                                while (true){
                                        line = br.readLine();
                                        if (line == null) {
                                                break;
                                        }
                                        String txt[] = line.split(";");
                                        String ID = txt[0];
                                        String Type = txt[1];
                                        double carryingCapacity = Double.parseDouble (txt [2]);
                                        double fuelCapacity = Double.parseDouble (txt [3]);
                                        double currentFuel = Double.parseDouble (txt [4]);
                                        String currentPort = (txt [5]);
                                        String container =  (txt [6]);

                                        list.add(new Vehicle(ID, Type,  carryingCapacity,  fuelCapacity,  currentFuel, currentPort, container));
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
                                String txt[] = line.split(";");
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

