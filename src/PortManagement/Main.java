package PortManagement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;


// Java Program to Illustrate StudentRecordLinkedList Class



// Importing required classes


// Java Program to Illustrate StudentRecordManagement Class



// Importing required classes


import static PortManagement.Container.allContainer;
import static PortManagement.Port.allPort;
import static PortManagement.Trip.allTrip;
import static PortManagement.Vehicle.allVehicle;


public class Main {
    //    private static Port Port ;

    private static Scanner scanner = new Scanner(System.in);
    PortManagementSystem PortManagementSystem = new PortManagementSystem();
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
        System.out.print("Enter your choice(number): ");
    }

    private static void loginUser() {
        System.out.println("=== User Login ===");

        System.out.println("1. Login as System Admin");
        System.out.println("2. Login as Port Manager");
        System.out.print("Enter your choice(number): ");

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
        String user = null;

        // Hypothetical authentication logic.
        // In a real-world scenario, you'd validate the username and password against a database or data files.
        if (username.equals("admin") && password.equals("admin123") && roleChoice == 1) {
            user="admin";
             // Directly call the admin dashboard upon successful login as admin
        } else if (username.equals("manager") && password.equals("manager123") && roleChoice == 2) {
            user="manager"; // Directly call the manager dashboard upon successful login as manager
        } else {
            System.out.println("Invalid credentials or role choice. Please try again.");
            loginUser();
        }
        chooseChoices(user);
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
                    System.out.println("1. Add Port");
                    System.out.println("2. Remove Port");
                    System.out.println("3. Modify Port");
                    System.out.println("4. Calculate The Distance");

                    switch (option) {
                        case 1:
//                                Main m = new Main();
//                                List<Port> list = m.Port.readPorts();
//
//                                for (Port Port : list) {
//                                    System.out.println(Port);
//                                }

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

                case 2:

                    int option2 = scanner.nextInt();

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

                case 3:

                    int option3 = scanner.nextInt();

                    System.out.println("1. Add Vehicle");
                    System.out.println("2. Remove Vehicle");
                    System.out.println("3. Modify Vehicle");

                    switch (option3) {
                        case 1:
//                                Main m = new Main();
//                                List<Port> list = m.Port.readPorts();
//
//                                for (Port Port : list) {
//                                    System.out.println(Port);
//                                }

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

                case 4:

                    int option4 = scanner.nextInt();

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
                    Scanner scanner5 = new Scanner(System.in);
                    int option = scanner5.nextInt();

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

                case 2:
                    int option2 = scanner.nextInt();

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


    private static void chooseChoices(String user) {
        System.out.println("=== Choose Choices ===");
        System.out.println("1. Modify the data");
        System.out.println("2. Function");
        System.out.println("Enter your choice(number): ");

        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }

        if (choice == 1) {
            modifyOption(user);
        } else if (choice==2) {
            functionOption(user);
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
            chooseChoices(user);
        }
    }

    private static void modifyOption(String user) {
        System.out.println("=== Modify Option ===");

        if (user.equals("manager")) {
            System.out.println("1. Container");
            System.out.println("2. Trip");
        } else if (user.equals("admin")) {
            System.out.println("1. Container");
            System.out.println("2. Trip");
            System.out.println("3. Port");
            System.out.println("4. Vehicle");
        }

        System.out.println("Enter your choice(number): ");

        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }

        if (choice == 1) {
            ContainerModificationData();
        } else if (choice==2) {
            TripModificationData();
        } else if (choice==3) {
            PortModificationData();
        } else if (choice==4) {
            VehicleModificationData();
        } else {
            System.out.println("Invalid choice.");
            chooseChoices(user);
        }
    }

    private static void ContainerModificationData() {
        System.out.println("=== Container Modification data ===");
        System.out.println("1. Add container");
        System.out.println("2. Remove container");
        System.out.print("Enter your choice(number): ");

        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }
//        String a= "DryStorage";
//        String b="OpenTop";
//        String c="OpenSide";
//        String d="Refrigerated";
//        String e="Liquid";
        switch(choice){
            case 1:
               AddContainer();
            case 2:
                RemoveContainer();

        }

    }
    private static void AddContainer() {
        new Container();
        String id = "c" + Container.getIdCounter();
        System.out.println("Enter it's weight:");
        double weight = scanner.nextDouble();
        allContainer.get(id).setWeight(weight);
        System.out.println("Choose the type(number):");
        System.out.println("1.DryStorage");
        System.out.println("2.OpenTop");
        System.out.println("3.OpenSide");
        System.out.println("4.Refrigerated");
        System.out.println("5.Liquid");
        int i;
        do {
            System.out.println("Please enter a number:");
            try {
                i = scanner.nextInt();
                if (i >= 1 && i <= 5) {
                    break;  // If the input is valid, break the loop
                } else {
                    System.out.println("The number is not in the range from 1 to 5. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid number. Please try again.");
                scanner.next();  // Discard the invalid input
            }
        } while (true);
        switch (i) {
            case 1:
                allContainer.get(id).setType("DryStorage");
            case 2:
                allContainer.get(id).setType("OpenTop");

            case 3:
                allContainer.get(id).setType("OpenSide");
            case 4:
                allContainer.get(id).setType("Refrigerated");
            case 5:
                allContainer.get(id).setType("Liquid");

        }
        if (allPort != null){
            System.out.println("Where is it now? Enter a port or a vehicle ID:");
            System.out.println("Ports: ");
            for (Map.Entry<String, Port> entry : allPort.entrySet()) {
                System.out.print( entry.getKey()+"," +"/t");
            }
            System.out.println("Vehicle: ");
            for (Map.Entry<String, Vehicle> entry : allVehicle.entrySet()) {
                System.out.print( entry.getKey()+"," +"/t");
            }
            String posi= scanner.nextLine();
            allContainer.get(id).setPosition(posi);
            if (posi.charAt(0) == 'P') {
                allPort.get(posi).addContainer(allContainer.get(id));
            } else {
                allVehicle.get(posi).setContainer(allContainer.get(id));
            }}

        System.out.println("added:"+  allContainer.get(id));


    }
    private static void RemoveContainer(){
        if (allContainer != null){
            System.out.println("Containers: ");
            for (Map.Entry<String, Container> entry : allContainer.entrySet()) {
                System.out.print( entry.getKey()+"," +"/t");
            }
            System.out.println("Enter the ID of the container:");
            String id = scanner.nextLine();
//            if (allContainer.get(id).getPosition().charAt(0) == 'P'){
//                allPort.get(allContainer.get(id).getPosition()).removeContainer((allContainer.get(id)));
//            }else{allVehicle.get(allContainer.get(id).getPosition()).setContainer(null);}

                allContainer.remove(id);
            System.out.println("Removed"+id);

        }else{System.out.println("No container to remove");

        }
    }

    private static void TripModificationData() {
        System.out.println("=== Trip Modification data ===");
        System.out.println("1. Start trip");
        System.out.println("2. End trip");
        System.out.print("Enter your choice(number): ");
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }


        switch(choice){
            case 1:
                StartTrip();

            case 2:
                EndTrip();

        }
    }
    private static void StartTrip(){
        System.out.println("Ports available: ");
        for (Map.Entry<String, Port> entry : allPort.entrySet()) {
            System.out.print(entry.getKey() + "," + "/t");
        }
        System.out.println("Enter the starting Port:");
        String from=scanner.nextLine();
        System.out.println("Enter the destination Port:");
        String to=scanner.nextLine();
        System.out.println("Vehicle available: ");
        for (Vehicle vehicle : allPort.get(from).getVehicles() ) {
            System.out.println(vehicle);
        }
        System.out.println("Enter the vehicle:");
        String vehicle=scanner.nextLine();
        System.out.println("Containers available: ");
        for (Container container : allPort.get(from).getContainers()) {
            System.out.println(container);
        }
        System.out.println("Enter the container:");
        String container=scanner.nextLine();
        if (vehicle.charAt(0)=='t' && allPort.get(from).isLandingAbility() ==false ||allPort.get(to).isLandingAbility() ==false){
            System.out.println("The Port entered can't be reach by truck");
            return;
        };
        if(!allPort.get(from).getVehicles().contains(allContainer.get(vehicle))){
            System.out.println("This vehicle isn't here");
            return;
        }
        if(!allPort.get(from).getContainers().contains(allContainer.get(container))){
            System.out.println("This container isn't here");
            return;
        }
        if(allVehicle.get(vehicle).getContainer()!=null && allVehicle.get(vehicle).getContainer().getID() != allContainer.get(container).getID()) {
            System.out.println("This vehicle is having a container");
            return;
        }
        new Trip();
        String id = "Trip" + Trip.getIdCounter();
        if (allVehicle.get(vehicle).getContainer().getID() != allContainer.get(container).getID()){
            allPort.get(from).load(allVehicle.get(vehicle), allContainer.get(container));}
        if (allVehicle.get(vehicle).getContainer() == null) {
            allTrip.remove(id);
            return;
        }

        allTrip.get(id).startNewTrip();
        allTrip.get(id).setContainer(allContainer.get(container));
        allTrip.get(id).setFrom(allPort.get(to));
        allTrip.get(id).setTo(allPort.get(to));


        }

    private static void EndTrip(){
        if (!Trip.getOngoingTrips().isEmpty()) {
            System.out.println("Trips ongoing: ");
            for (Trip trip : Trip.getOngoingTrips()) {
                System.out.print(trip + "," + "/t");
            }
            System.out.println("Enter the tripID you want to end:");
            String ongoingtrip = scanner.nextLine();
            allTrip.get(ongoingtrip).completeTrip();
        }else {
            System.out.println("no ongoing trip");
        }
    }
    private static void PortModificationData() {
        System.out.println("=== Port Modification data ===");
        System.out.println("1. Add port");
        System.out.println("2. Remove port");
        System.out.print("Enter your choice(number): ");
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }

        switch(choice){
            case 1:
                AddPort();
            case 2:
                RemovePort();

        }
    }
    private static void AddPort(){
    new Port();

// Create a Scanner object for user input
    String id = "P" + Container.getIdCounter();

// Ask the user for input and set the values
    System.out.print("Enter port name (String): ");
    String name = scanner.nextLine();
    allPort.get(id).setName(name);

    System.out.print("Enter latitude (double): ");
    double latitude = scanner.nextDouble();
    allPort.get(id).setLatitude(latitude);

    System.out.print("Enter longitude (double): ");
    double longitude = scanner.nextDouble();
    allPort.get(id).setLongitude(longitude);

    System.out.print("Enter total capacity (double): ");
    double totalCapacity = scanner.nextDouble();
    allPort.get(id).setTotalCapacity(totalCapacity);

    System.out.print("Enter landing ability (boolean): ");
    boolean landingAbility = scanner.nextBoolean();
    allPort.get(id).setLandingAbility(landingAbility);


    }
    private static void RemovePort() {
        if (allPort != null) {
            System.out.println("Ports: ");
            for (Map.Entry<String, Port> entry : allPort.entrySet()) {
                System.out.print(entry.getKey() + "," + "/t");
            }
            System.out.println("Enter the ID of the container:");
            String id = scanner.nextLine();
            if (allPort.get(id).getContainers()!=null){
                for(Container container : allPort.get(id).getContainers()){
                container.setPosition(null);
            }}
            allPort.remove(id);
            System.out.println("Removed" + id);

        } else {
            System.out.println("No Port to remove");
        }
    }
    private static void VehicleModificationData() {
        System.out.println("=== Vehicle Modification data ===");
        System.out.println("1. Add vehicle");
        System.out.println("2. Remove vehicle");
        System.out.print("Enter your choice(number): ");
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }

        switch(choice){
            case 1:
                AddVehicle();
            case 2:
                RemoveVehicle();
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;

        }
    }
    public static void AddVehicle(){
        new Vehicle();

        Scanner scanner = new Scanner(System.in);
// Display the menu
        System.out.println("Enter the Vehicle's Type:");
        System.out.println("1. Ship");
        System.out.println("2. Truck");
        System.out.println("3. Reefer Truck");
        System.out.println("4. Tanker Truck");

// Get the user's choice
        int choice = scanner.nextInt();

// Convert the choice to a vehicle type
        String type;
        switch (choice) {
            case 1:
                type = "ship";
                break;
            case 2:
                type = "truck";
                break;
            case 3:
                type = "reefer_truck";
                break;
            case 4:
                type = "tanker_truck";
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                return;
        }
        String id =allVehicle.get("temp").setType(type);



        System.out.print("Enter fuel capacity (double): ");
        double fuelCapacity = scanner.nextDouble();
        allVehicle.get(id).setFuelCapacity(fuelCapacity);

        System.out.print("Enter current fuel capacity-must be smaller than it's capacity (double): ");
        double currentfuel = scanner.nextDouble();
        allVehicle.get(id).reFuel(currentfuel);


        System.out.print("Enter carrying capacity (double): ");
        double carryingCapacity = scanner.nextDouble();
        allVehicle.get(id).setCarryingCapacity(carryingCapacity);

        System.out.println("Ports available: ");
        int a =0;
        for (Port port : allPort.values()) {
            if (type!="ship"&& port.isLandingAbility()) {
                a+=1;
                System.out.println(port.getId()+","+"/t ");
            } else if (type=="ship") {
                a+=1;
            }
        }
        if (a==0){
            System.out.println("There is no Port available");
            return;
        }
        System.out.print("Enter it's current position (Port ID): ");
        String position = scanner.nextLine();
        allVehicle.get(id).moveTo(allPort.get(position));




    }

    public static void RemoveVehicle(){
        System.out.println("Ports: ");
     if(allVehicle!=null){
        for (Map.Entry<String, Vehicle> entry : allVehicle.entrySet()) {
            System.out.print(entry.getKey() + "," + "/t");
        }
        System.out.println("Enter the ID of the Vehicle:");
        String id = scanner.nextLine();
    if (allVehicle.get(id).getContainer()!=null){
        allVehicle.get(id).getContainer().setPosition(null);}
        System.out.println("Removed" + id );

    } else {
        System.out.println("No Vehicle to remove");
    }
        }
    public static void functionOption(String user){
        System.out.println("=== Function Option ===");
        System.out.println("1. Container");
        System.out.println("2. Port");
        System.out.println("3. Trip");
        System.out.print("Enter your choice(number): ");

        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }

        if (choice == 1) {
            ContainerFunctionData();
        } else if (choice==2) {
            TripFunctionData();
        } else if (choice==3) {
            PortFunctionData();
        } else {
            System.out.println("Invalid choice.");
            chooseChoices(user);
        }
    }

    private static void ContainerFunctionData() {
        System.out.println("=== Container Function ===");
        System.out.println("1. Load container");
        System.out.println("2. Unload container");
        System.out.println("3. Calculate weight of each type");
        System.out.print("Enter your choice(number): ");

        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }

        switch(choice){
            case 1:
                LoadContainer();
                break;
            case 2:
                UnLoad();
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;

        }

    }
    public static void LoadContainer(){
        System.out.println("Ports available: ");
        for (Map.Entry<String, Port> entry : allPort.entrySet()) {
            System.out.print(entry.getKey() + "," + "/t");
        }
        System.out.println("Enter the Port:");
        String from=scanner.nextLine();

        System.out.println("Vehicle available: ");
        for (Vehicle vehicle : allPort.get(from).getVehicles() ) {
            System.out.println(vehicle);
        }
        System.out.println("Enter the vehicle:");
        String vehicle=scanner.nextLine();
        System.out.println("Containers available: ");
        for (Container container : allPort.get(from).getContainers()) {
            System.out.println(container);
        }
        System.out.println("Enter the container:");
        String container=scanner.nextLine();


        if(!allPort.get(from).getVehicles().contains(allContainer.get(vehicle))){
            System.out.println("This vehicle isn't here");
            return;
        }
        if(!allPort.get(from).getContainers().contains(allContainer.get(container))){
            System.out.println("This container isn't here");
            return;
        }
        if(allVehicle.get(vehicle).getContainer()!=null) {
            System.out.println("This vehicle is having a container");
            return;
        }



        allPort.get(from).load(allVehicle.get(vehicle), allContainer.get(container));
        System.out.print("Function complete");

    }
    private static void UnLoad(){
        System.out.println("Vehicle available: ");
        int a =0;

        for (Vehicle vehicle : allVehicle.values()) {
            if (vehicle.getContainer() != null && vehicle.getContainer().getPosition()!=null) {
                a+=1;
                System.out.println(vehicle.getID()+"is having Container: "+vehicle.getContainer().getID() +" at "+vehicle.getContainer().getPosition());
            }
        }
        if (a==0){
            System.out.println("There is no vahicle available");
            return;
        }
        System.out.println("Enter the vehicle");
        String vehical=scanner.nextLine();
        allVehicle.get(vehical).unload();
    }


    private static void TripFunctionData() {
        System.out.println("=== Trip Function ===");
        System.out.println("1. Search trip by a date");
        System.out.println("2. Search trip between days");
        System.out.print("Enter your choice(number): ");
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }
        // Ask the user for input
        System.out.print("Enter a date (format: yyyy-mm-dd): ");
        String input = scanner.nextLine();

// Parse the input into a LocalDate
        LocalDate date;
        try {
            date = LocalDate.parse(input);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter a date in the format yyyy-mm-dd.");
            return;
        }

// Convert the LocalDate to a LocalDateTime at the start of the day
        LocalDateTime dateTime = date.atStartOfDay();

        System.out.println("You entered: " + dateTime);

        switch(choice){
            case 1:

                Trip.listAllTripHappeningAt(dateTime);
            case 2:
                // Ask the user for input
                System.out.print("Enter another date after the date you just entered (format: yyyy-mm-dd): ");
                String input1 = scanner.nextLine();

// Parse the input into a LocalDate
                LocalDate date1;
                try {
                    date1 = LocalDate.parse(input1);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter a date in the format yyyy-mm-dd.");
                    return;
                }

// Convert the LocalDate to a LocalDateTime at the start of the day
                LocalDateTime dateTime1 = date1.atStartOfDay();

                System.out.println("You entered: " + dateTime1);
                Trip.getTripsBetweenDates(dateTime,dateTime1);
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;
        }
    }

    private static void PortFunctionData() {
        System.out.println("=== Port Function ===");
        System.out.println("1. List al vehicle of type:");


        System.out.print("Enter your choice(number): ");
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }
        System.out.println("Ports available: ");
        for (Map.Entry<String, Port> entry : allPort.entrySet()) {
            System.out.print(entry.getKey() + "," + "/t");
        }
        String port=scanner.nextLine();

        switch(choice){
            case 1:

                Scanner scanner = new Scanner(System.in);
// Display the menu
                System.out.println("Enter the Vehicle's Type:");
                System.out.println("1. Ship");
                System.out.println("2. Truck");
                System.out.println("3. Reefer Truck");
                System.out.println("4. Tanker Truck");

// Get the user's choice
                int choice1 = scanner.nextInt();

// Convert the choice to a vehicle type
                String type;
                switch (choice1) {
                    case 1:
                        type = "ship";
                        break;
                    case 2:
                        type = "truck";
                        break;
                    case 3:
                        type = "reefer_truck";
                        break;
                    case 4:
                        type = "tanker_truck";
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        return;
                }
                allPort.get(port).listAllVehiclesOfType(type);


            case 2:
                break;
            case 3:
                return;
        }
    }

    private static void VehicleFunctionData() {
        System.out.println("=== Vehicle Function ===");
        System.out.println("1. Move Port");
        System.out.println("2. Load container");
        System.out.println("3. Unload container");
        System.out.println("4. Refuel");
        System.out.print("Enter your choice(number): ");
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            return; // Return to the main menu
        }

        switch(choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                return;
        }
    }
}

