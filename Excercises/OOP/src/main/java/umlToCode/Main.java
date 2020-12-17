package umlToCode;

import umlToCode.composition.Building;
import umlToCode.composition.Room;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        var rooms = new ArrayList<Room>();
        rooms.add(new Room("OG1"));
        Building b = new Building("FK", rooms);

  b = null;
        System.out.println(b);



    }
}
