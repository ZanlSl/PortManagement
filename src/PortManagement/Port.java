package PortManagement;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;




public class Port implements ContainerPosition, PortInterface {
    private String ID;

    private String name;
    private double latitude;
    private double longitude;
    private double currentCapacity;
    private double totalCapacity;
    private boolean landingAbility;
    private ArrayList<Container> containers;
    private ArrayList<Vehicle> vehicles;
    public static TreeMap<String, Port> allPort = new TreeMap<>();
    private static int idCounter;
    public Port(){
        if (!allPort.isEmpty()) {
            String lastKey = allPort.lastKey();
            idCounter = Integer.parseInt(lastKey.substring(1));

        } else
            idCounter = 100;
        this.ID = "P" + (++idCounter); // Increment the counter and prepend "Tr"
        containers = new ArrayList<>();
        vehicles = new ArrayList<>();
        allPort.put(this.ID, this); // Add the item to the map when it's created


    }


    public Port(String Id, String name, double latitude, double longitude, double totalCapacity, boolean landingAbility) {
        this.ID = Id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.totalCapacity = totalCapacity;
        this.landingAbility = landingAbility;
        containers = new ArrayList<>();
        vehicles = new ArrayList<>();
        updateCurrentCapacity();
        allPort.put(this.ID,this);
    }
    public void listContainers() {
        System.out.println("Listing all containers in the port:");
        for (Container container : this.containers) {
            System.out.println(container);
        }}
    public void listAllPort(){
        for (Map.Entry<String, Port> entry : allPort.entrySet()) {
            System.out.println("Port ID = " + entry.getKey() + ", Port = " + entry.getValue());
        }
    }
    public void listAllVehiclesOfType(String type){
        System.out.println("Listing all vehicles of input in the port:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals(type)){
                 System.out.println(vehicle);
            }
    }}



    public String getId() {
        return ID;
    }

    public void setId(String Id) {
        this.ID = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setCurrentCapacity(double currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public void setTotalCapacity(double totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public boolean isLandingAbility() {
        return landingAbility;
    }

    public void setLandingAbility(boolean landingAbility) {
        this.landingAbility = landingAbility;
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public void setContainers(ArrayList<Container> containers) {
        this.containers = containers;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void load(Vehicle vehicle, Container container) {
        if (containers.contains(container)) {
            container.setPosition(vehicle);
            vehicle.load(container);
            containers.remove(container);
            updateCurrentCapacity();
        } else {
            System.out.println("This port does not have the specified container");
        }
    }

    public void updateCurrentCapacity() {
        currentCapacity = 0.0;
        for (Container container : containers) {
            currentCapacity += container.getWeight();
        }
    }
    public void addContainer(Container container) {
        if (currentCapacity + container.getWeight() <= totalCapacity) {
            containers.add(container);
            updateCurrentCapacity();
        } else {
            System.out.println("The port is at full capacity");
        }
    }
    public double calculateDistance(Port other) {
        double R = 6371.0; // Radius of the earth in km
        double latDistance = Math.toRadians(other.latitude - this.latitude);
        double lonDistance = Math.toRadians(other.longitude - this.longitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(other.latitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        return distance;
    }
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


    // getters and setters for each field can be added here
    // getter for currentCapacity and totalCapacity
    public double getCurrentCapacity() {
        return currentCapacity;
    }

    public double getTotalCapacity() {
        return totalCapacity;
    }

    @Override
    public String toString() {
        return "Port{" +

                "ID='" + ID + ";"+ name+ ";"+ latitude+ ";"  + longitude+ ";" + totalCapacity+ ";" + landingAbility +
                ";"+ containers +
                ";"+ vehicles ;

    }







    @Override
    public String getContainerPosition() {
        return "Port: " + name +'\'' +
        " ID: " + ID;
    }

}
