package PortManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class PortManagementSystem {

        // Sample data initialization
        List<Port> ports = Port.getAllPortsAsList();
        List<Vehicle> vehicles = new ArrayList<>();
        List<Container> containers = new ArrayList<>();
        List<Trip> trips = new ArrayList<>();
        public static void writePorts(List<Port> list, String file) {
                try {
                        FileWriter fw = new FileWriter("data.txt");
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
        public static List<Port> readPorts() {
                List<Port> list= new ArrayList<>();
                try {
                        FileReader fr = new FileReader("data.txt");
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
}
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

