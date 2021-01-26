package museum;

import museum.persons.Person;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int number;
    private List<Artwork> artworks;
    private List<Person> persons;

    public Room(int number) {
        this.number = number;
        this.persons = new ArrayList<>();
        this.artworks = new ArrayList<>();
    }

    public Room(Room room) {
    }

    public void addPerson(Person person){
        persons.add(person);
    }
    public void deletePerson(Person person){
        persons.remove(person);
    }
    public void addArtwork(Artwork artwork){
        artworks.add(artwork);
    }
    public void removeArtwork(Artwork artwork){
        artworks.remove(artwork);
    }

    public int getNumber() {
        return number;
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public List<Person> getPersons() {
        return persons;
    }
}
