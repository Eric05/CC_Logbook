package umlToCode.isA;

/***
 * Is A Relationship (keyword 'extends')
 * -> Teacher is a Person
 * -> he inherits all Person properties and extends it with subject
 */

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
