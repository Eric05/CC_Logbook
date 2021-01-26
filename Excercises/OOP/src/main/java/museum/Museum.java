package museum;

import museum.data.InMemoryData;
import museum.data.Repository;
import museum.persons.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Museum {

    private final Repository repo = new InMemoryData();
    private String name;
    private List<Room> rooms = new ArrayList<>();
    private final List<Person> allPersons;

    public Museum(String name, int rooms, int arts) {
        this.name = name;
        initializeMuseum(rooms, arts);
        allPersons = new ArrayList<>();
    }

    public void printInfo() {
        System.out.println("\tWeclome to " + name.toUpperCase(Locale.ROOT));
        System.out.println("Rooms: " + rooms.size());
        System.out.println("Artworks per room: " + rooms.get(rooms.size() - 1).getArtworks().size());

        var lastRoomArts = rooms.get(rooms.size() - 1).getArtworks();
        System.out.println("Most valuable artwork: " + lastRoomArts.get(lastRoomArts.size() - 1).getName());
        System.out.println( "Price is: " + lastRoomArts.get(lastRoomArts.size() - 1).getValue());

    }

    private void initializeMuseum(int roomNumber, int arts) {
        int id = 1;
        var price = 14000.0;
        rooms = repo.getRooms(roomNumber);

        for (Room room : rooms) {
            price += 4000;
            for (int i = 1; i <= arts; i++) {
                price += 1200;
                id++;
                room.addArtwork(new Artwork("art_" + id, price));
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }
    public List<Person> getAllPersons(){
        return allPersons;
    }
}
