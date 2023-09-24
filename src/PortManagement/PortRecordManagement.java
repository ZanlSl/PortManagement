package PortManagement;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

// Class
public class PortRecordManagement {

    // Creating an empty LinkedList
    LinkedList<Port> list;

    // Default Constructor
    public void portRecordManagement() {
        list = new LinkedList<>();
    }

    // Method 1
    // Adding Record
    // @param record
    public void add(Port port) {

        // Checking if a record already exists or not,
        // if not add it to Record list, Otherwise
        // error display message
        if (!find(port.getId())) {
            list.add(port);
        } else {

            // Print statement
            System.out.println(
                    "Record already exists in the Record list");
        }
    }

    // Method 2
    // Searching Record
    // @param idNumber
    // @return
    public boolean find(String Id) {

        // Iterating record list
        // using for each loop
        for (Port l : list) {

            // Checking record by id Number
            if (Objects.equals(l.getId(), "Id")) {

                System.out.println(l);
                return true;
            }
        }
        return false;
    }

    // Method 3
    // Delete Record
    // @param recIdNumber
    public void delete(int recIdNumber) {
        Port recordDel = null;

        // Iterating record list
        for (Port ll : list) {

            // Finding record to be deleted by id Number
            if (Objects.equals(ll.getId(), "recIdNumber")) {
                recordDel = ll;
            }
        }

        // If recordDel is null, then show error message,
        // otherwise remove the record from Record list
        if (recordDel == null) {

            // Displaying no record found
            System.out.println("Invalid record Id");
        } else {

            list.remove(recordDel);

            // Display message for successful deletion of
            // record
            System.out.println(
                    "Successfully removed record from the list");
        }
    }

    // Method 4
    // Finding Record
    // @param idNumber
    // @return
    public Port findRecord(int idNumber) {

        // Iterate Record list
        // using for each loop
        for (Port l : list) {

            // Checking record by id Number.
            if (Objects.equals(l.getId(), "Id")) {
                return l;
            }
        }

        return null;
    }

    // Method 5
    // Update Record
    // @param id
    // @param input
    public void update(String Id, Scanner input) {

        if (find(String.valueOf(Integer.parseInt(Id)))) {
            Port rec = findRecord(Integer.parseInt(Id));

            // Display message only
            System.out.print(
                    "What is the new Port id Number ? ");
            Id = input.nextLine();

            // Display message only
            System.out.print(
                    "What is the new Port Name ? ");
            String name = input.nextLine();

            rec.setId(Id);
            rec.setName(name);
            System.out.println(
                    "Record Updated Successfully");
        } else {

            // Print statement
            System.out.println(
                    "Record Not Found in the Student list");
        }
    }

    // Method 6
    // Display Records
    public void display() {

        // If record list is empty then
        // print the message below
        if (list.isEmpty()) {

            // Print statement
            System.out.println("The list has no records\n");
        }
        // Iterating Record list
        // using for each loop
        for (Port record : list) {

            // Printing the list
            System.out.println(record.toString());
        }
    }
}
