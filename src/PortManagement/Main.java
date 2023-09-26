package PortManagement;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

import static PortManagement.Container.allContainer;
import static PortManagement.Port.allPort;
import static PortManagement.PortManager.allManager;
import static PortManagement.Trip.allTrip;
import static PortManagement.Vehicle.allVehicle;


public class Main {
    public static HashMap<LocalDateTime, Double> fuelUsedInADay;
    // Add a key-value pair to the map
    public static LocalDateTime today = LocalDate.now().atStartOfDay();
    private static Scanner scanner = new Scanner(System.in);
    //region Methods
    private static void displayWelcomeScreen() {
        System.out.println("COSC2081 GROUP ASSIGNMENT");
        System.out.println("CONTAINER PORT MANAGEMENT SYSTEM");
        System.out.println("Instructor: Mr. Minh Vu & Dr. Phong Ngo");
        System.out.println("Group: [Your Group Name]");
        System.out.println("s3979126, [Hoang Tho Anh]");
        System.out.println("s3978814, [Student Name]");
        System.out.println("s3891735, [Student Name]");
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
        } else if (allManager.containsKey(username)&& roleChoice == 2){
            if (allManager.get(username).getPassword().equals(password) ){
                user=username; // Directly call the manager dashboard upon successful login as manager
            }
        } else {
            System.out.println("Invalid credentials or role choice. Please try again.");
            loginUser();
        }
        chooseChoices(user);
    }
    private static void chooseChoices(String user) {
        System.out.println("=== Choose Choices ===");
        System.out.println("1. Modify the data");
        System.out.println("2. Function");
        System.out.println("3.Exit application");

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
        } else if (choice==3) {
            System.out.println("Exiting...");
            System.exit(0);
        }else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
        chooseChoices(user);

    }

    private static void modifyOption(String user) {
        System.out.println("=== Modify Option ===");

        if (!user.equals("admin")) {
            System.out.println("1. Container");
            System.out.println("2. Trip");
        } else {
            System.out.println("1. Container");
            System.out.println("2. Trip");
            System.out.println("3. Port");
            System.out.println("4. Vehicle");
            System.out.println("5. Manager");
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
        if (user.equals("admin")){
            if (choice == 1) {
                ContainerModificationData(user);
            } else if (choice==2) {
                TripModificationData(user);
            } else if (choice==3) {
                PortModificationData();
            } else if (choice==4) {
                VehicleModificationData();
            } else if (choice==5) {
                ManagermModificationData();}

        }else {
            if (choice == 1) {
                ContainerModificationData(user);
            } else if (choice == 2) {
                TripModificationData(user);
            }
        }
        chooseChoices(user);

    }

    private static void ContainerModificationData(String user) {
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
                if(user.equals("admin")){
                    AddContainer();
                    scanner.nextLine();  // Consume the leftover newline
                }else{
                    AddContainerForManager(allManager.get(user));
                    scanner.nextLine();  // Consume the leftover newline

                }


                break;
            case 2:
                if(user.equals("admin")){
                    RemoveContainer();
                    scanner.nextLine();  // Consume the leftover newline
                }else{
                    RemoveContainerForManager(allManager.get(user));
                    scanner.nextLine();  // Consume the leftover newline

                }

                break;

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
                break;
            case 2:
                allContainer.get(id).setType("OpenTop");
                break;

            case 3:
                allContainer.get(id).setType("OpenSide");
                break;

            case 4:
                allContainer.get(id).setType("Refrigerated");
                break;

            case 5:
                allContainer.get(id).setType("Liquid");
                break;


        }
        if (allPort != null && !allPort.isEmpty()){
            System.out.println("Where is it now? Enter a port or a vehicle ID:");
            System.out.println("Ports: ");
            for (Map.Entry<String, Port> entry : allPort.entrySet()) {
                System.out.print( entry.getKey()+"," +"\t");
            }

            if (allVehicle != null && !allVehicle.isEmpty()){
                System.out.println(" ");
                System.out.println("Vehicle: ");
            for (Map.Entry<String, Vehicle> entry : allVehicle.entrySet()) {
                System.out.print(entry.getKey() + "," + "\t");
            }
        }
        System.out.println(" ");
        scanner.nextLine();  // Consume the leftover newline
        String posi= scanner.nextLine();
        allContainer.get(id).setPosition(posi);
        if (posi.charAt(0) == 'P') {
            allPort.get(posi).addContainer(allContainer.get(id));
        } else {
            allVehicle.get(posi).setContainer(allContainer.get(id));
        }}

        System.out.println("added:"+  allContainer.get(id));


    }
    private static void AddContainerForManager(PortManager manager){
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
                break;
            case 2:
                allContainer.get(id).setType("OpenTop");
                break;

            case 3:
                allContainer.get(id).setType("OpenSide");
                break;

            case 4:
                allContainer.get(id).setType("Refrigerated");
                break;

            case 5:
                allContainer.get(id).setType("Liquid");
                break;


        }
        manager.getPortResponsible().addContainer(allContainer.get(id));
        allContainer.get(id).setPosition(manager.getPortResponsible().getId());


    }
    private static void RemoveContainer(){
        if (allContainer != null && !allContainer.isEmpty()){
            System.out.println("Containers: ");
            for (Map.Entry<String, Container> entry : allContainer.entrySet()) {
                System.out.print( entry.getKey()+"," +"\t");
            }
            System.out.println(" ");
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
    private static void RemoveContainerForManager(PortManager manager){
        if (manager.getPortResponsible().getContainers() != null && !manager.getPortResponsible().getContainers().isEmpty()){
            System.out.println("Containers: ");
            for (Container container : manager.getPortResponsible().getContainers()) {
                System.out.print( container.getID()+"," +"\t");
            }
            System.out.println(" ");
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

    private static void TripModificationData(String user) {
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
                if(user.equals("admin")){
                    StartTrip();
                    scanner.nextLine();  // Consume the leftover newline
                }else{
                    StartTripForManager(allManager.get(user));
                    scanner.nextLine();  // Consume the leftover newline

                }

                scanner.nextLine();  // Consume the leftover newline

                break;

            case 2:
                if(user.equals("admin")){
                    EndTrip();
                    scanner.nextLine();  // Consume the leftover newline
                }else{
                    EndTripForManager(allManager.get(user));
                    scanner.nextLine();  // Consume the leftover newline

                }
                scanner.nextLine();  // Consume the leftover newline

        }
    }
    private static void StartTrip(){
        System.out.println("Ports available: ");
        for (Map.Entry<String, Port> entry : allPort.entrySet()) {
            System.out.print(entry.getKey() + "," + "\t");
        }
        System.out.println(" ");
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
    private static void StartTripForManager(PortManager manager){

        System.out.println("Enter the starting Port:");
        String from=manager.getPortResponsible().getId();
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
                System.out.print(trip + "," + "\t");
            }
            System.out.println(" ");
            System.out.println("Enter the tripID you want to end:");
            String ongoingtrip = scanner.nextLine();
            allTrip.get(ongoingtrip).completeTrip();
        }else {
            System.out.println("no ongoing trip");
        }
    }
    private static void EndTripForManager(PortManager manager){
        if (!Trip.getOngoingTrips().isEmpty()) {
            System.out.println("Trips to your Port: ");
            for (Trip trip : Trip.getOngoingTrips()) {
                if (trip.getTo().equals(manager.getPortResponsible())) {
                    System.out.print(trip + "," + "\t");
                }
            }
            System.out.println(" ");
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
                scanner.nextLine();  // Consume the leftover newline

                break;
            case 2:
                RemovePort();
                scanner.nextLine();  // Consume the leftover newline



        }
    }
    private static void AddPort(){
    new Port();

// Create a Scanner object for user input
    String id = "P" + Port.getIdCounter();

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
    if (allPort != null && !allPort.isEmpty()) {
        System.out.println("Ports: ");
        for (Map.Entry<String, Port> entry : allPort.entrySet()) {
            System.out.print(entry.getKey() + "," + "\t");
        }
        System.out.println(" ");
    }

    }
    private static void RemovePort() {
        if (allPort != null && !allPort.isEmpty()){
            System.out.println("Ports: ");
            for (Map.Entry<String, Port> entry : allPort.entrySet()) {
                System.out.print(entry.getKey() + "," + "\t");
            }
            System.out.println(" ");
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
                scanner.nextLine();  // Consume the leftover newline

                break;
            case 2:
                RemoveVehicle();
                scanner.nextLine();  // Consume the leftover newline

                break;
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
            if (!type.equals("ship")&& port.isLandingAbility()) {
                a+=1;
                System.out.println(port.getId()+","+"\t" );
            } else if (type.equals("ship")) {
                a+=1;
            }
        }
        System.out.println(" ");

        if (a==0){
            System.out.println("There is no Port available");
            return;
        }else {
            System.out.print("Enter it's current position (Port ID): ");
            scanner.nextLine();  // Consume the leftover newline
            String position = scanner.nextLine();
            allVehicle.get(id).moveTo(allPort.get(position));
        }



    }

    public static void RemoveVehicle(){
        System.out.println("Vehicles: ");
        if (allVehicle != null && !allVehicle.isEmpty()){
        for (Map.Entry<String, Vehicle> entry : allVehicle.entrySet()) {
            System.out.print(entry.getKey() + "," + "\t");
        }
        System.out.println(" ");
        System.out.println("Enter the ID of the Vehicle:");
        String id = scanner.nextLine();
    if (allVehicle.get(id).getContainer()!=null){
        allVehicle.get(id).getContainer().setPosition(null);}
        System.out.println("Removed " + id );

    } else {
        System.out.println("No Vehicle to remove");
    }
        }

    public static void ManagermModificationData(){
        int a=0;
        if (allPort != null || !allPort.isEmpty()) {
            System.out.println("Ports: ");
            for (Map.Entry<String, Port> entry : allPort.entrySet()) {
                if(PortManager.portTaken != null || PortManager.portTaken.isEmpty() && !PortManager.portTaken.contains(entry.getKey())){
                    System.out.print(entry.getKey() + "," + "\t");
                    a+=1;
                }
            }
        System.out.println(" ");
        }
        if(a==0) {
            System.out.println("Add the Port first");
            return;
        }

        System.out.println(" ");
        System.out.print("Enter the ID of the port responsible: ");
        String id = scanner.nextLine();
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        // Assuming Port class has a method to get a Port by its name


        Port portResponsible = allPort.get(id);

        // Create a new PortManager with the input data
        new PortManager(accountName, password, portResponsible);

        System.out.println("PortManager created successfully!");
    }
    public static void functionOption(String user){
        System.out.println("=== Function Option ===");
        System.out.println("1. Container");
        System.out.println("2. Trip");
        System.out.println("3. Port");
        System.out.println("4. Vehicle");
        if (user.equals("admin")){
            System.out.println("5. Allocate Manager");
        }

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
            ContainerFunctionData(user);
        } else if (choice==2) {
            TripFunctionData();
        } else if (choice==3) {
            PortFunctionData();
        } else if (choice==4) {
            VehicleFunctionData();
        } else if (choice==5) {
            AllocateManager();
        } else {
            System.out.println("Invalid choice.");
            chooseChoices(user);
        }
    }
    private static void AllocateManager(){

        int a=0;
        if (allManager != null && !allManager.isEmpty()) {
            System.out.println("Manager available: ");
            for (Map.Entry<String, PortManager> entry : allManager.entrySet()) {
                if(entry.getValue().getPortResponsible()==null) {
                    a+=1;
                    System.out.print(entry.getKey() + "," + "\t");
                }
            }
        }else{
            System.out.println("No manager");
            return;}
        System.out.println(" ");
        if (a==0){
            System.out.println("All allocated");
        }
        System.out.println("Enter the manager account name:");
        String manager=scanner.nextLine();

        a=0;
        if (allPort != null && !allPort.isEmpty()) {
            System.out.println("Ports available: ");
            for (Map.Entry<String, Port> entry : allPort.entrySet()) {
                if ( !PortManager.portTaken.contains(entry.getKey())) {
                    a+=1;
                    System.out.print(entry.getKey() + "," + "\t");
                }
            }
            System.out.println(" ");
        }else{
            System.out.println("No Port");
            return;}

        if (a==0){
            System.out.println("All allocated");

        }
        System.out.println("Enter the Port:");
        String to=scanner.nextLine();

        PortManager.portTaken.add(allPort.get(to));
        allManager.get(manager).setPortResponsible(allPort.get(to));
    }
    private static void ContainerFunctionData(String user) {

        System.out.println("=== Container Function ===");
        System.out.println("1. Calculate weight of each type");
        System.out.println("2. List all container");
        if (user.equals("admin")) {
            System.out.println("3. Load container");
            System.out.println("4. Unload container");
            System.out.println("5. Allocate container to Port");
        }
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
                CalculateContainerWrightByType();
                scanner.nextLine();  // Consume the leftover newline

                break;
            case 2:
                System.out.println("Container available: ");
                for (Map.Entry<String, Container> entry : allContainer.entrySet()) {
                    System.out.print(entry.getKey() + "," + entry.getValue());
                }
                scanner.nextLine();  // Consume the leftover newline
                break;
            case 3:
                if (user.equals("admin")){
                    LoadContainer();
                }else{
                    System.out.println("Invalid choice. Returning to main menu.");
                }
                scanner.nextLine();  // Consume the leftover newline
                break;
            case 4:
                if (user.equals("admin")){
                    UnLoad();
                }else{
                    System.out.println("Invalid choice. Returning to main menu.");
                }
                break;
            case 5:
                if (user.equals("admin")){
                    AllocateContainer();
                }else{
                    System.out.println("Invalid choice. Returning to main menu.");
                }
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;

        }

    }
    public static void LoadContainer(){
        if (allPort != null && !allPort.isEmpty()) {

            System.out.println("Ports available: ");
            for (Map.Entry<String, Port> entry : allPort.entrySet()) {
                System.out.print(entry.getKey() + "," + "\t");
            }
        System.out.println(" ");
        }else{return;}
        System.out.println(" ");

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

    private static void CalculateContainerWrightByType() {
        System.out.println("Choose the type(number):");
        System.out.println("1.DryStorage");
        System.out.println("2.OpenTop");
        System.out.println("3.OpenSide");
        System.out.println("4.Refrigerated");
        System.out.println("5.Liquid");
        int i;
        String type=" ";

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
                type = "DryStorage";
                break;
            case 2:
                type = "OpenTop";
                break;
            case 3:
                type = "OpenSide";
                break;
            case 4:
                type = "Refrigerated";
                break;
            case 5:
                type = "Liquid";
                break;
        }
        System.out.println("Total weight of type"+ type +" is "+Container.totalWeightCalculateByType(type));

    }
    private static void AllocateContainer(){
        if (allPort != null && !allPort.isEmpty()) {
            System.out.println("Ports available: ");
            for (Map.Entry<String, Port> entry : allPort.entrySet()) {
                System.out.print(entry.getKey() + "," + "\t");
            }
        System.out.println(" ");
        }else{return;}
        int a=0;
        if (allContainer != null && !allContainer.isEmpty()) {

            System.out.println("Container available: ");
            for (Map.Entry<String, Container> entry : allContainer.entrySet()) {
                if(entry.getValue().getPosition()==null) {
                    a+=1;
                    System.out.print(entry.getKey() + "," + "\t");
                }
            }
            System.out.println(" ");
            if (a==0){
                System.out.println("All Container allocated");}
        }else{
            System.out.println("No container");}
        System.out.println("Enter the Port:");
        String to=scanner.nextLine();
        System.out.println("Enter the container:");
        String container=scanner.nextLine();
        allContainer.get(container).setPosition(to);
        allPort.get(to).addContainer(allContainer.get(container));



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
                scanner.nextLine();  // Consume the leftover newline

                break;
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
                scanner.nextLine();  // Consume the leftover newline

            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;
        }
    }

    private static void PortFunctionData() {
        System.out.println("=== Port Function ===");
        System.out.println("1. List al vehicle of type:");
        System.out.println("2. List all Port");


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
        if (allPort != null && !allPort.isEmpty()) {

            System.out.println("Ports available: ");
            for (Map.Entry<String, Port> entry : allPort.entrySet()) {
                System.out.print(entry.getKey() + "," + "\t");
            }
            System.out.println(" ");
        }else{
            System.out.println("No Port");
            return;}
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
                System.out.println("Ports available: ");
                for (Map.Entry<String, Port> entry : allPort.entrySet()) {
                    System.out.print(entry.getKey() + "," + entry.getValue());
                }
                break;
            case 3:
                return;
        }
    }

    private static void VehicleFunctionData() {
        System.out.println("=== Vehicle Function ===");
        System.out.println("1. Allocate a vehicle");
        System.out.println("2. Refuel");
        System.out.println("3. List all vehicle");
        System.out.println("4. Fuel used in a day:");
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
        System.out.println("Vehicles: ");
        if (allVehicle != null && !allVehicle.isEmpty()){
            for (Map.Entry<String, Vehicle> entry : allVehicle.entrySet()) {
                System.out.print(entry.getKey() + "," + "\t");
            }
            System.out.println(" ");
        }else {
            System.out.println("No vehicle");
            return;

        }
            System.out.println("Enter the ID of the Vehicle:");
            String id = scanner.nextLine();

        switch(choice){
            case 1:

                    if (allVehicle.get(id).getCurrentPort()!=null){
                        System.out.println("This Vehicle had already allocated, generate a Trip to move it to another Port");}


                scanner.nextLine();  // Consume the leftover newline

                break;
            case 2:
                double a =allVehicle.get(id).getCurrentFuel();
                System.out.println("Fuel Capacity: "+allVehicle.get(id).getFuelCapacity()+"Current fuel: "+a);
                System.out.println("Enter refuel amount");
                double refuel = scanner.nextDouble();
                allVehicle.get(id).reFuel(refuel);
                if (a >allVehicle.get(id).getCurrentFuel()) {
                    refuel=a+refuel;
                    fuelUsedInADay.put(today, refuel);
                }
                System.out.println("Total fuel used: "+ fuelUsedInADay);
                scanner.nextLine();  // Consume the leftover newline

                break;
            case 3:
                System.out.println("Vehicle available: ");
                for (Map.Entry<String, Vehicle> entry : allVehicle.entrySet()) {
                    System.out.println(entry.getKey() + "," + entry.getValue());
                }
                break;
            case 4:
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
                System.out.println("Amount of fuel refueled this day:"+fuelUsedInADay.get(dateTime));
        }
    }
    public static void saveData(){
        try {
            FileOutputStream fos = new FileOutputStream("fuel.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(fuelUsedInADay);
            oos.close();
            fos.close();
            System.out.println("Serialized data is saved in fuel.ser");

             fos = new FileOutputStream("port.ser");
             oos = new ObjectOutputStream(fos);
            oos.writeObject(allPort);
            oos.close();
            fos.close();
            System.out.println("Serialized data is saved in port.ser");

            fos = new FileOutputStream("container.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(allContainer);
            oos.close();
            fos.close();
            System.out.println("Serialized data is saved in container.ser");

            fos = new FileOutputStream("Vehicle.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(allVehicle);
            oos.close();
            fos.close();
            System.out.println("Serialized data is saved in vehicle.ser");

            TreeMap<String, Trip> filteredTrips = Trip.allTrip.entrySet().stream()
                    .filter(entry -> entry.getValue().getArrivalTime().isBefore(LocalDateTime.now().minusDays(7)))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, TreeMap::new));

            // Write the filtered trips to a file
            fos = new FileOutputStream("trips.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(filteredTrips);
            oos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public static void readData() {
        try {
            FileInputStream fis = new FileInputStream("fuel.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            fuelUsedInADay = (HashMap<LocalDateTime, Double>) ois.readObject();
            ois.close();
            fis.close();

             fis = new FileInputStream("port.ser");
             ois = new ObjectInputStream(fis);
            allPort = (TreeMap) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Deserialized data is read from port.ser");

            fis = new FileInputStream("container.ser");
            ois = new ObjectInputStream(fis);
            allContainer = (TreeMap) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Deserialized data is read from container.ser");

            fis = new FileInputStream("vehicle.ser");
            ois = new ObjectInputStream(fis);
            allVehicle = (TreeMap) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Deserialized data is read from vehicle.ser");

            fis = new FileInputStream("trips.ser");
            ois = new ObjectInputStream(fis);
            TreeMap<String, Trip> trips = (TreeMap<String, Trip>) ois.readObject();
            ois.close();

            // Print the size of the deserialized TreeMap
            System.out.println("Number of trips: " + trips.size());

            // Print each trip
            for (Map.Entry<String, Trip> entry : trips.entrySet()) {
                System.out.println("Trip ID: " + entry.getKey() + ", Arrival Time: " + entry.getValue().getArrivalTime());
            }

        } catch(IOException ioe){
            ioe.printStackTrace();
        } catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
        }

        // Displaying the TreeMap
        for (Map.Entry<String, Port> entry : Port.allPort.entrySet()) {
            System.out.println("Port ID: " + entry.getKey()+" "+entry.getValue());
        }

        for (Map.Entry<String, Container> entry : Container.allContainer.entrySet()) {
            System.out.println("Container ID: " + entry.getKey()+" "+entry.getValue());
        }

        for (Map.Entry<String, Vehicle> entry : allVehicle.entrySet()) {
            System.out.println("Vehicle ID:"+entry.getKey() +" "+entry.getValue());
        }
    }

    //endregion
    public static void main (String[]args) {
        readData();
//region ResetData
////generate 20 vehicle
//        Vehicle[] vehicles = new Vehicle[20];
//        String[] types = {"ship", "truck", "reefer_truck", "tanker_truck"};
//        Random random = new Random();
//        for (int i = 0; i < vehicles.length; i++) {
//            // Generate a random type index
//            int typeIndex = random.nextInt(types.length);
//
//            // Generate a random ID
//            String id = (types[typeIndex].equals("ship") ? "sh" : "tr") + (101 + i);
//
//            // Generate random fuel and carrying capacities
//            double fuelCapacity = 100 + (500 - 100) * random.nextDouble();
//            double carryingCapacity = 150 + (250 - 150) * random.nextDouble();
//
//            // Create a new Vehicle object with the generated values
//            vehicles[i] = new Vehicle(id, types[typeIndex], carryingCapacity, fuelCapacity, 0.0, null, null);
//        }
////generate 30 container
//
//// Create an array to store the containers
//        Container[] containers = new Container[30];
//        String[] types1 = {"DryStorage", "OpenTop", "OpenSide", "Refrigerated", "Liquid"};
//        for (int i = 0; i < containers.length; i++) {
//            // Generate a random type index
//            int typeIndex = random.nextInt(types.length);
//
//            // Generate a random ID
//            String id = "c" + (101 + i);
//
//            // Generate a random weight
//            double weight = 100 + (150 - 100) * random.nextDouble();
//
//            // Create a new Container object with the generated values
//            containers[i] = new Container(id, weight, types1[typeIndex], null);
//        }
//
//
//
//
//        // Create 5 ports
//        Port[] ports = new Port[05];
//        for (int i = 0; i < ports.length; i++) {
//            String id = "P" + (101 + i);
//            String portName = "PortName" + (101 + i);
//            double totalCapacity = 500 + (1000 - 500) * random.nextDouble();
//            double latitude = -90 + (90 - (-90)) * random.nextDouble();
//            double longitude = -180 + (180 - (-180)) * random.nextDouble();
//           boolean landingAbility = random.nextBoolean();
//           ports[i] = new Port(id, portName, latitude, longitude, totalCapacity, landingAbility);
//}
        //endregion
        System.out.println(" ");
        fuelUsedInADay = new HashMap<>();
        today = LocalDate.now().atStartOfDay();
        fuelUsedInADay.put(today,0.0);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                saveData();
            }
        });
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
                    // Exit the application
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }

    }
}



