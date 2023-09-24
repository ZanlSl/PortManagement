package PortManagement;

import java.util.ArrayList;

public interface PortInterface {
    void listContainers();
    void listAllPort();
    void listAllVehiclesOfType(String type);
    void addVehicle(Vehicle vehicle);
    void load(Vehicle vehicle, Container container);
    void updateCurrentCapacity();
    void addContainer(Container container);
    double calculateDistance(Port other);
    void removeVehicle(Vehicle vehicle);
    void removeContainer(Container container);
}
