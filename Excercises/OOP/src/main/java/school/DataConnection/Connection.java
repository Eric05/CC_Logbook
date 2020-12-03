package school.DataConnection;

import school.SchoolModels.Course;

import java.io.IOException;
import java.util.List;

public interface Connection {

    List<Course> getAllCourses() throws IOException;

    void createCourse(Course course) throws IOException;

    String[] getCourseNames();

    List<String> getNamesAndAdresses() throws IOException;

}
