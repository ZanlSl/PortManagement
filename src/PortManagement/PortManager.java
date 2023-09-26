package PortManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

// Class representing a Port Manager
class PortManager implements Serializable {
    // Implement the User interface methods
    private String accountName;
    private String password;

    private Port portResponsible;

    public static TreeMap<String,PortManager> allManager=new TreeMap<>();
    public static ArrayList<Port> portTaken= new ArrayList<>();
    public PortManager(String accountName, String password,Port portResponsible){
        this.accountName=accountName;
        this.password=password;
        this.portResponsible=portResponsible;
        portTaken.add(portResponsible);
        allManager.put(accountName,this);
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Port getPortResponsible() {
        return portResponsible;
    }

    public void setPortResponsible(Port portResponsible) {
        this.portResponsible = portResponsible;
    }

    public static ArrayList<Port> getPortTaken() {
        return portTaken;
    }

    public static void setPortTaken(ArrayList<Port> portTaken) {
        PortManager.portTaken = portTaken;
    }

    @Override
    public String toString() {
        return "PortManager{" +
                "accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                ", portResponsible=" + portResponsible +
                '}';
    }
}
