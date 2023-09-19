# PortManagement
# Here will be the system outline given by the requirement of the assignment
User Interface: This interface defines the methods for user-related operations, such as login, viewing/modifying information, and processing entities. It should be implemented by both SystemAdmin and PortManager classes.

SystemAdmin Class: This class represents the system administrator and implements the User interface. It has full access to all system functionalities.

PortManager Class: This class represents a port manager and also implements the User interface. It can only perform operations related to the port it manages.

Port Class: Represents a port with attributes like ID, name, location, storing capacity, landing ability, and methods for calculating distance to another port. It should also keep track of containers, vehicles, and past/current traffic.

Vehicle Class: Represents a vehicle with attributes like ID, name, current fuel, carrying capacity, and fuel capacity. It should have methods to load/unload containers, move to a port, and refuel.

Ship Class: Extends the Vehicle class and includes methods to handle containers.

Truck Class: Extends the Vehicle class and includes methods to handle containers.

Container Class: Represents a container with attributes like ID, weight, and fuel consumption rates for ships and trucks.

Trip Class: Represents a trip with attributes like vehicle information, departure/arrival date, departure/arrival port, and status.

File Structure:

You need to design a file structure that efficiently stores and updates system data. Consider using CSV, JSON, or a database depending on your preferences and project requirements.

Sample Data:

You mentioned that you need sample data for testing. You should create data files that contain at least 20 vehicles, 5 ports, 30 containers, and 25 trips with realistic data for testing your application.

Basic Features:

Create, Read, Update, and Delete (CRUD) operations for Vehicles, Ports, Containers, and Managers.
Load/unload containers from vehicles.
Check if a vehicle can move to a port with its current load.
Move a vehicle to a port.
Refuel a vehicle.
User authentication and permissions based on roles (System Admin, Port Manager).
Statistics operations:
Calculate daily fuel consumption.
Calculate the total weight of each type of container.
List all ships in a port.
List all trips on a given day.
List all trips within a date range.
