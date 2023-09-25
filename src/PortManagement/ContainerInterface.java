package PortManagement;

public interface ContainerInterface {
    void setPosition(String position);
    void setFuelWeightKm();
    double totalWeightCalculateByType(String type);
    void setWeight(double weight);
    void setType(String type);
}
