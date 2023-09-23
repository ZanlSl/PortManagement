package PortManagement;


import java.time.LocalDateTime;
import java.util.TreeMap;

public class Trip {
    private String ID;
    private LocalDateTime departTime;
    private LocalDateTime arrivalTime;
    private Port from;
    private Port to;
    private double estimatedFuel;
    private Vehicle vehicle;
    private Container container;

    private TripStatus Status;
    private enum TripStatus {
        CANCELED,
        ONGOING,
        COMPLETED
    };
    public static TreeMap<String, Trip> allTrip = new TreeMap<>();
    private int idCounter;


    public Trip() {
        if (!allTrip.isEmpty()) {
            String lastKey = allTrip.lastKey();
            idCounter = Integer.parseInt(lastKey.substring(2));

        } else
            idCounter = 100;
        this.ID = "Tr" + (++idCounter); // Increment the counter and prepend "Tr"
        // If the vehicle doesn't have the container, try to load it
        if (!vehicle.getContainers().contains(container)) {
            from.load(vehicle, container);
        }
        else {break;}

        // Calculate the distance between the two ports
        double distance = from.calculateDistance(to);

        // Calculate the estimated fuel based on the type of vehicle and the distance
        if (vehicle.getType().equals("ship")) {
            estimatedFuel = distance * container.getShipFuelWeightKm();
        } else {
            estimatedFuel = distance * container.getTruckFuelWeightKm();
        }
        if (vehicle.getCurrentFuel() < 1.0) {
            System.out.println("The vehicle does not have enough fuel for this trip");
            Status = TripStatus.CANCELED;
            allTrip.put(this.ID, this); // Add the item to the map when it's created

        }
    }

    public Trip(String ID, LocalDateTime departTime, LocalDateTime arrivalTime, Port from, Port to, double estimatedFuel, Vehicle vehicle, Container container) {
        this.ID = ID;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.from = from;
        this.to = to;
        this.estimatedFuel = estimatedFuel;
        this.vehicle = vehicle;
        this.container = container;



//        // If the estimated fuel exceeds the current fuel of the vehicle, print a message
//
//            allTrip.put(ID, this);
//            if (!allTrip.isEmpty()) {
//                String lastKey = allTrip.lastKey();
//                idCounter = Integer.parseInt(lastKey.substring(2));


            }





    public void completeTrip(){
        // Unload the Container from the Vehicle
        vehicle.unload(container);

        // Set the status of the trip to "completed"
        Status = TripStatus.COMPLETED;
    }


    // getters and setters for each field can be added here

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public LocalDateTime getDepartTime() {
        return departTime;
    }

    public void setDepartTime(LocalDateTime departTime) {
        this.departTime = departTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Port getFrom() {
        return from;
    }

    public void setFrom(Port from) {
        this.from = from;
    }

    public Port getTo() {
        return to;
    }

    public void setTo(Port to) {
        this.to = to;
    }

    public double getEstimatedFuel() {
        return estimatedFuel;
    }

    public void setEstimatedFuel(double estimatedFuel) {
        this.estimatedFuel = estimatedFuel;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public String getStatus() {
        return TripStatus;
    }

    public void setStatus(TripStatus Status) {
        TripStatus = TripStatus;
    }

    public static TreeMap<String, Trip> getAllTrip() {
        return allTrip;
    }

    public static void setAllTrip(TreeMap<String, Trip> allTrip) {
        Trip.allTrip = allTrip;
    }
}