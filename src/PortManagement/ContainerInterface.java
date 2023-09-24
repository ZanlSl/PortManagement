package PortManagement;

public interface ContainerInterface {
    void setPosition(ContainerPosition position);
    void setFuelWeightKm();
    double totalWeightCalculateByType(String type);
}
