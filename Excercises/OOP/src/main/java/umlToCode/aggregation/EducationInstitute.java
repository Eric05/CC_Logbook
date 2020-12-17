package umlToCode.aggregation;

import java.util.ArrayList;
import java.util.List;

/**
 * Aggregation (uml -> empty diamond)
 * -> weak association
 * -> has a relationship. Institute can have one or more courses
 * -> both entities can live individually. Course can also occur without Institute ( Internet, privatly,...)
 */

public class EducationInstitute {
    private String name;
    private List<Course> courses;

    public EducationInstitute(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return name;
    }
}
