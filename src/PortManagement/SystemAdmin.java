package PortManagement;

import java.util.HashMap;

// Class representing the System Administrator
class SystemAdmin implements User {
   private HashMap<String, String> userCredentials; // Store user credentials (username and password)

    public SystemAdmin() {
        // Initialize the user credentials
        userCredentials = new HashMap<>();
        // Add a sample admin user (replace with real credentials)
        userCredentials.put("admin", "adminPassword");
    }
    // Implement the User interface methods
    @Override
    public void login(String username, String password) {
        // Implement login logic for the admin
        if (userCredentials.containsKey(username)) {
            // Check if the entered username exists
            String storedPassword = userCredentials.get(username);
            if (storedPassword.equals(password)) {
                // Check if the entered password matches the stored password
                System.out.println("Login successful. Welcome, " + username + "!");
            } else {
                System.out.println("Login failed. Incorrect password.");
            }
        } else {
            System.out.println("Login failed. User not found.");
        }
    
        
    }

    @Override
    public void viewInformation() {
        // Implement viewInformation for the admin
    }

    @Override
    public void modifyInformation() {
        // Implement modifyInformation for the admin
    }

    @Override
    public void processEntities() {
        // Implement processEntities for the admin
    }
}
