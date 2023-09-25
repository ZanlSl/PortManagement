package PortManagement;

public interface VehicleInterface {
    void moveTo(Port port);
    void checkFuel();
    void reFuel(double fuelAmount);
    void unload();
    String setType(String type);

}
