package PortManagement.Data;

import PortManagement.Port;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class readPorts {
    public static List<Port> readDataFromFileToList() {
        List<Port> list= new ArrayList<>();
        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true){
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                String ID = txt[0];
                String name = txt[1];
                double latitude = Double.parseDouble (txt [2]);
                double longtitude = Double.parseDouble (txt [3]);
                int storingCapacity = Integer.parseInt (txt [4]);
                boolean landingAbility = Boolean.parseBoolean (txt[5]);
                list.add(new Port(ID, name, latitude, longtitude, storingCapacity, landingAbility));
            }
        }catch (Exception e){}
        return list;

    }
}
