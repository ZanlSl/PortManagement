package PortManagement.Data;


import PortManagement.Port;

import java.io.*;
import java.util.List;

public class writePorts {
    public static void writeDataListToFile(List<Port> list, String file) {
        try {
            FileWriter fw = new FileWriter("data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Port Port: list){
                bw.write(Port.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

