package PortManagement;
import java.util.*;


// Java Program to Illustrate StudentRecordLinkedList Class



// Importing required classes


// Java Program to Illustrate StudentRecordManagement Class



// Importing required classes


import static PortManagement.Port.allPort;



public class Main {
//    private static Port Port ;
    private static Scanner scanner = new Scanner(System.in);
    static PortManagementSystem PortManagementSystem = new PortManagementSystem();
    public Main() {
        // Initialize the readPorts object here or in the constructor
//        Port  = new Port();
    }
        public static void main (String[]args) {

            Scanner scanner = new Scanner(System.in);

            while (true) {
                displayWelcomeScreen();
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
            System.out.println("2. View Containers");
            System.out.println("3. View Vehicles");
            System.out.println("4. View Trip");
            System.out.println("5. Log Out");


            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    int option = scanner.nextInt();
                    while (true) {
                        System.out.println("1. Add Port");
                        System.out.println("2. Remove Port");
                        System.out.println("3. Modify Port");
                        System.out.println("4. Calculate The Distance");

                        switch (option) {
                            case 1:


                                break;
                            case 2:
//                                removePort();
                                break;
                            case 3:
//                                modifyPorts();
                                break;
                            case 4:
//                                calculateDistance();
                                break;
                            case 5:
                                return;
                            default:
                                System.out.println("Invalid Option!");
                        }
                    }
                case 2:
                    int option2 = scanner.nextInt();
                    while (true){
                        System.out.println("1. Add Container");
                        System.out.println("2. Remove Container");
                        System.out.println("3. Modify Container");
                        System.out.println("4. Load Container");
                        System.out.println("5. Unload Container");
                        System.out.println("6. Calculate Weight Of Each Type");

                        switch (option2) {
                            case 1:
//                                Main m = new Main();
//                                List<Port> list = m.Port.readPorts();
//
//                                for (Port Port : list) {
//                                    System.out.println(Port);
//                                }

                                break;
                            case 2:
//                                removeContainer();
                                break;
                            case 3:
//                                modifyContainers();
                                break;
                            case 4:
//                                loadContainer();
                                break;
                            case 5:
//                                UnloadContainer();
                                break;
                            case 6:
//                                CalculateWeight();
                                break;
                            case 7:
                                return;
                            default:
                                System.out.println("Invalid Option!");
                        }
                    }
                case 3:
                    int option3 = scanner.nextInt();
                    while (true){
                        System.out.println("1. Add Vehicle");
                        System.out.println("2. Remove Vehicle");
                        System.out.println("3. Modify Vehicle");

                        switch (option3) {
                            case 1:
                                Main m = new Main();
                                List<Port> list = m.PortManagementSystem.readPorts();

                                for (Port Port : list) {
                                    System.out.println(Port);
                                }

                                break;
                            case 2:
//                                removeVehicle();
                                break;
                            case 3:
//                                modifyVehicles();
                                break;
                            case 4:
                                return;
                            default:
                                System.out.println("Invalid Option!");
                        }
                    }
                case 4:
                    int option4 = scanner.nextInt();
                    while (true){
                        System.out.println("1. Start Trip");
                        System.out.println("2. End Trip");
                        switch (option4){
                            case 1:
//                                StartTrip();
                                break;
                            case 2:
//                                EndTrip();
                                break;
                            case 3:
                                return;
                        }

                    }
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

//    private static void viewPorts() {
//        // This is a mock function. In reality, you'd fetch and display port details from your data source.
//        System.out.println("\n=== Ports ===");
//        System.out.println("Port 1: Location A");
//        System.out.println("Port 2: Location B");
//    }

//    private static void modifyContainers() {
//        // Mock function. You would have real logic to add, remove or modify container details.
//        System.out.println("\n=== Modify Containers ===");
//        System.out.println("Container 1: Type A, Weight: 100kg");
//        System.out.println("Container 2: Type B, Weight: 200kg");
//        System.out.println("Add, remove or modify containers as needed...");
//    }

//    private static void viewVehicles() {
//        // Another mock function. You'd display vehicle details fetched from your data source.
//        System.out.println("\n=== Vehicles ===");
//        System.out.println("Vehicle 1: Type Ship, Capacity: 1000 containers");
//        System.out.println("Vehicle 2: Type Truck, Capacity: 20 containers");
//    }

//    private static void modifyUsers() {
//        // Mock function. You'd provide functionalities to add, remove or modify user details.
//        System.out.println("\n=== Modify Users ===");
//        System.out.println("User 1: Role Admin, Username: admin");
//        System.out.println("User 2: Role Manager, Username: manager");
//        System.out.println("Add, remove or modify users as needed...");
//    }


    private static void managerDashboard() {
        System.out.println("Welcome Manager! You can manage Ports, Containers, and Vehicles.");

        while (true) {
            System.out.println("\n=== Manager Dashboard ===");
            System.out.println("1. View Ports");
            System.out.println("2. View Containers");
            System.out.println("3. View Vehicles");
            System.out.println("4. Search Trip");
            System.out.println("5. Log Out");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    int option = scanner.nextInt();
                    while (true) {
                        System.out.println("1. Add Port");
                        System.out.println("2. Remove Port");
                        System.out.println("3. Modify Port");
                        System.out.println("4. Calculate The Distance");

                        switch (option) {
                            case 1:
                                Main m = new Main();
                                List<Port> list = m.PortManagementSystem.readPorts();

                                for (Port Port : list) {
                                    System.out.println(Port);
                                }

                                break;
                            case 2:
//                                removePort();
                                break;
                            case 3:
//                                modifyPorts();
                                break;
                            case 4:
//                                calculateDistance();
                                break;
                            case 5:
                                return;
                            default:
                                System.out.println("Invalid Option!");
                        }
                    }
                case 2:
                    int option2 = scanner.nextInt();
                    while (true){
                        System.out.println("1. Add Container");
                        System.out.println("2. Remove Container");
                        System.out.println("3. Modify Container");
                        System.out.println("4. Load Container");
                        System.out.println("5. Unload Container");
                        System.out.println("6. Calculate Weight Of Each Type");

                        switch (option2) {
                            case 1:
//                                Main m = new Main();
//                                List<Port> list = m.Port.readPorts();
//
//                                for (Port Port : list) {
//                                    System.out.println(Port);
//                                }

                                break;
                            case 2:
//                                removeContainer();
                                break;
                            case 3:
//                                modifyContainers();
                                break;
                            case 4:
//                                loadContainer();
                                break;
                            case 5:
//                                UnloadContainer();
                                break;
                            case 6:
//                                CalculateWeight();
                                break;
                            case 7:
                                return;
                            default:
                                System.out.println("Invalid Option!");
                        }
                    }
                case 3:
                    int option3 = scanner.nextInt();
                    while (true){
                        System.out.println("1. Add Vehicle");
                        System.out.println("2. Remove Vehicle");
                        System.out.println("3. Modify Vehicle");

                        switch (option3) {
                            case 1:
                                Main m = new Main();
                                List<Port> list = m.PortManagementSystem.readPorts();

                                for (Port Port : list) {
                                    System.out.println(Port);
                                }

                                break;
                            case 2:
//                                removeVehicle();
                                break;
                            case 3:
//                                modifyVehicles();
                                break;
//                case 4:
//                    while (true){
//                        System.out.println("1. add Ports");
//                        System.out.println("2. remove Ports");
//                    int option = scanner.nextInt();
//                    scanner.nextLine();
//                    switch (option) {
//                        case 1:
//                            System.out.print("Enter the name for the new port: ");
//                            String name = scanner.nextLine().trim();
//                            if (name.equals("q")) {
//                                break;
//                            }
//                            System.out.print("Enter the latitude for the new port: ");
//                            double latitude = scanner.nextDouble();
//                            System.out.print("Enter the longitude for the new port: ");
//                            double longtitude = scanner.nextDouble();
//                            System.out.print("Enter the total capacity for the new port: ");
//                            double totalCapacity = scanner.nextDouble();
//                            System.out.print("Enter the landing ability for the new port: ");
//                            boolean landingAbility = scanner.nextBoolean();
//                            allPort.put(Port.Port());


                            // Write the new Port to the file
//                            writePorts(ports, "data.txt");

//                            break;
//                        default:
//                            System.out.println("Invalid choice. Please try again.");
//                        }
//                    }
                case 4:
                    int option4 = scanner.nextInt();
                    while (true){
                        System.out.println("1. Start Trip");
                        System.out.println("2. End Trip");
                        switch (option4){
                            case 1:
//                                StartTrip();
                                break;
                            case 2:
//                                EndTrip();
                                break;
                            case 3:
                                return;
                        }

                    }
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

//    private static void modifyPorts() {
//        // Mock function. You would have real logic to add, remove, or modify port details.
//        System.out.println("\n=== Modify Ports ===");
//        System.out.println("Port 1: Location A");
//        System.out.println("Port 2: Location B");
//        System.out.println("Add, remove, or modify ports as needed...");
//    }

//    private static void modifyVehicles() {
//        // Mock function. You would have real logic to add, remove, or modify vehicle details.
//        System.out.println("\n=== Modify Vehicles ===");
//        System.out.println("Vehicle 1: Type Ship, Capacity: 1000 containers");
//        System.out.println("Vehicle 2: Type Truck, Capacity: 20 containers");
//        System.out.println("Add, remove, or modify vehicles as needed...");
//    }


//    private static void statisticsOperations() {
//                while (true) {
//                    System.out.println("1. Calculate fuel used in a day");
//                    System.out.println("2. Calculate weight of each type of containers");
//                    System.out.println("3. List all ships in a port");
//                    System.out.println("4. List all trips in a given day");
//                    System.out.println("5. List all trips from day A to day B");
//                    System.out.println("6. Go back to the main menu");
//
//                    int choice = scanner.nextInt();
//                    scanner.nextLine(); // consume newline
//
//                    switch (choice) {
//                        case 1:
//                            // mock function
//                            System.out.println("Fuel used today: 2000L");
//                            break;
//                        case 2:
//                            // mock function
//                            System.out.println("Container weights: TypeA: 1000kg, TypeB: 500kg");
//                            break;
//                        case 3:
//                            // mock function
//                            System.out.println("Ships in port: Ship1, Ship2");
//                            break;
//                        case 4:
//                            // mock function
//                            System.out.println("Trips today: Trip1, Trip2");
//                            break;
//                        case 5:
//                            // mock function
//                            System.out.println("Trips from day A to day B: Trip3, Trip4, Trip5");
//                            break;
//                        case 6:
//                            return; // Exit statistics operations and go back to the main menu
//                        default:
//                            System.out.println("Invalid choice. Please try again.");
//                    }
//                }
//            }
        }
    }
}





