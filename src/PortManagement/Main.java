package PortManagement;


import PortManagement.Data.writePorts;
import PortManagement.Data.readPorts;


import java.util.ArrayList;
import java.util.List;

public class Main {
    private readPorts readPorts;

    public Main() {
        // Initialize the readPorts object here or in the constructor
        readPorts = new readPorts(); // Replace 'ReadPorts' with your actual class name
    }
    public static void main(String[] args) {
        // Data to write as a list



        Main m = new Main();
        List<Port> list = m.readPorts.readDataFromFileToList();

        for (Port Port : list){
            System.out.println(Port);
        }
    }


}