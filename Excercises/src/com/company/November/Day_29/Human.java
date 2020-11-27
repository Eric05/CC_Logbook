package com.company.November.Day_29;

/***
 * overwrite toString , equals and hashcode
 * with overwrititn equals we can check to objects which otherwise would always be wrong
 *  due to different references
 * just start typing to... or eq... and make your own method
 */

import java.util.Objects;

public class Human {

   private String firstName;
   private String lastName;
   private int year;
   private String location;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private boolean isMale;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYear() {
        return year;
    }

    public String getLocation() {
        return location;
    }

    public boolean isMale() {
        return isMale;
    }

    public Human(String firstName, String lastName, int year, String location, boolean isMale) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.location = location;
        this.isMale = isMale;
    }


    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +

                ", isMale=" + isMale +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return year == human.year &&
                isMale == human.isMale &&
                Objects.equals(firstName, human.firstName) &&
                Objects.equals(lastName, human.lastName) &&
                Objects.equals(location, human.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, year, location, isMale);
    }
}
