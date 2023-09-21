package PortManagement;

// Interface for users
interface User {
    void login(String username, String password);

    void viewInformation();

    void modifyInformation();

    void processEntities();
}
