package PortManagement;
import java.util.*;


// Java Program to Illustrate StudentRecordLinkedList Class



// Importing required classes


// Java Program to Illustrate StudentRecordManagement Class



// Importing required classes


import java.time.LocalDateTime;

import static PortManagement.Port.allPort;
import static PortManagement.Vehicle.allVehicle;


public class Main {
    private final Port Port;
    private static Scanner scanner = new Scanner(System.in);
    public Main() {
        // Initialize the readPorts object here or in the constructor
        Port  = new Port();
    } 
        public static void main (String[]args) {
            Main m = new Main();
            List<Port> list = m.Port.readPorts();

            for (Port Port : list) {
                System.out.println(Port);
            }
            Scanner scanner = new Scanner(System.in);

            while (true) {
                displayMainMenu();

                int choice = scanner.nextInt();
                scanner.nextLine();  // consume newline

                switch (choice) {
                    case 1:
                        // Handle user login
                        loginUser();
                        break;
                    case 2:
                        // Handle other functionalities like viewing ports, vehicles, etc.
                        // For demonstration, I'm just showing a message.
                        System.out.println("Functionality not yet implemented.");
                        break;
                    case 3:
                        // Exit the application
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    private static void displayWelcomeScreen() {
        System.out.println("COSC2081 GROUP ASSIGNMENT");
        System.out.println("CONTAINER PORT MANAGEMENT SYSTEM");
        System.out.println("Instructor: Mr. Minh Vu & Dr. Phong Ngo");
        System.out.println("Group: [Your Group Name]");
        System.out.println("sXXXXXXX, [Student Name]");
        System.out.println("sXXXXXXX, [Student Name]");
        System.out.println("sXXXXXXX, [Student Name]");
        System.out.println("=========================================");
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    private static void displayMainMenu() {
        System.out.println("=== Container Port Management System ===");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void loginUser() {
        System.out.println("=== User Login ===");

        System.out.println("1. Login as System Admin");
        System.out.println("2. Login as Port Manager");
        System.out.print("Enter your choice: ");

        int roleChoice;
        try {
            roleChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        // Note: For demonstration purposes only. Not a secure way to read passwords.
        String password = scanner.nextLine();

        // Hypothetical authentication logic.
        // In a real-world scenario, you'd validate the username and password against a database or data files.
        if (username.equals("admin") && password.equals("admin123") && roleChoice == 1) {
            adminDashboard(); // Directly call the admin dashboard upon successful login as admin
        } else if (username.equals("manager") && password.equals("manager123") && roleChoice == 2) {
            managerDashboard(); // Directly call the manager dashboard upon successful login as manager
        } else {
            System.out.println("Invalid credentials or role choice. Please try again.");
        }
    }
    private static void adminDashboard() {
        System.out.println("Welcome Admin! You can manage everything here.");

        while (true) {
            System.out.println("\n=== Admin Dashboard ===");
            System.out.println("1. View Ports");
            System.out.println("2. Modify Containers");
            System.out.println("3. View Vehicles");
            System.out.println("4. Modify Users");
            System.out.println("5. Statistics Operations");
            System.out.println("6. Log Out");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewPorts();
                    break;
                case 2:
                    modifyContainers();
                    break;
                case 3:
                    viewVehicles();
                    break;
                case 4:
                    modifyUsers();
                    break;
                case 5:
                    statisticsOperations();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewPorts() {
        // This is a mock function. In reality, you'd fetch and display port details from your data source.
        System.out.println("\n=== Ports ===");
        System.out.println("Port 1: Location A");
        System.out.println("Port 2: Location B");
    }

    private static void modifyContainers() {
        // Mock function. You would have real logic to add, remove or modify container details.
        System.out.println("\n=== Modify Containers ===");
        System.out.println("Container 1: Type A, Weight: 100kg");
        System.out.println("Container 2: Type B, Weight: 200kg");
        System.out.println("Add, remove or modify containers as needed...");
    }

    private static void viewVehicles() {
        // Another mock function. You'd display vehicle details fetched from your data source.
        System.out.println("\n=== Vehicles ===");
        System.out.println("Vehicle 1: Type Ship, Capacity: 1000 containers");
        System.out.println("Vehicle 2: Type Truck, Capacity: 20 containers");
    }

    private static void modifyUsers() {
        // Mock function. You'd provide functionalities to add, remove or modify user details.
        System.out.println("\n=== Modify Users ===");
        System.out.println("User 1: Role Admin, Username: admin");
        System.out.println("User 2: Role Manager, Username: manager");
        System.out.println("Add, remove or modify users as needed...");
    }


    private static void managerDashboard() {
        System.out.println("Welcome Manager! You can manage Ports, Containers, and Vehicles.");

        while (true) {
            System.out.println("\n=== Manager Dashboard ===");
            System.out.println("1. View Ports");
            System.out.println("2. Modify Containers");
            System.out.println("3. View Vehicles");
            System.out.println("4. Modify Ports");
            System.out.println("5. Modify Vehicles");
            System.out.println("6. Statistics Operations");
            System.out.println("7. Log Out");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewPorts();
                    break;
                case 2:
                    modifyContainers();
                    break;
                case 3:
                    viewVehicles();
                    break;
                case 4:
                    modifyPorts();
                    break;
                case 5:
                    modifyVehicles();
                    break;
                case 6:
                    statisticsOperations();
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void modifyPorts() {
        // Mock function. You would have real logic to add, remove, or modify port details.
        System.out.println("\n=== Modify Ports ===");
        System.out.println("Port 1: Location A");
        System.out.println("Port 2: Location B");
        System.out.println("Add, remove, or modify ports as needed...");
    }

    private static void modifyVehicles() {
        // Mock function. You would have real logic to add, remove, or modify vehicle details.
        System.out.println("\n=== Modify Vehicles ===");
        System.out.println("Vehicle 1: Type Ship, Capacity: 1000 containers");
        System.out.println("Vehicle 2: Type Truck, Capacity: 20 containers");
        System.out.println("Add, remove, or modify vehicles as needed...");
    }


    private static void statisticsOperations() {
        while (true) {
            System.out.println("1. Calculate fuel used in a day");
            System.out.println("2. Calculate weight of each type of containers");
            System.out.println("3. List all ships in a port");
            System.out.println("4. List all trips in a given day");
            System.out.println("5. List all trips from day A to day B");
            System.out.println("6. Go back to the main menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // mock function
                    System.out.println("Fuel used today: 2000L");
                    break;
                case 2:
                    // mock function
                    System.out.println("Container weights: TypeA: 1000kg, TypeB: 500kg");
                    break;
                case 3:
                    // mock function
                    System.out.println("Ships in port: Ship1, Ship2");
                    break;
                case 4:
                    // mock function
                    System.out.println("Trips today: Trip1, Trip2");
                    break;
                case 5:
                    // mock function
                    System.out.println("Trips from day A to day B: Trip3, Trip4, Trip5");
                    break;
                case 6:
                    return; // Exit statistics operations and go back to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}




