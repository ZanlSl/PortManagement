package PortManagement;

// Class representing a Port Manager
class PortManager implements User {
    // Implement the User interface methods
    
    private String username;
    private String password;

    // Constructor to set username and password during object creation
    public PortManager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Implement the User interface method for login
    @Override
    public void login(String enteredUsername, String enteredPassword) {
        // Check if the entered username and password match the Port Manager's credentials
        if (username.equals(enteredUsername) && password.equals(enteredPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
    }
  
        
    

    @Override
    public void viewInformation() {
        // Implement viewInformation for the port manager
    }

    @Override
    public void modifyInformation() {
        // Implement modifyInformation for the port manager
    }

    @Override
    public void processEntities() {
        // Implement processEntities for the port manager
    }

}

