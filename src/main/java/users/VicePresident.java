package users;

import courses.Course;
import schools.School;

import java.util.List;

public class VicePresident extends Master{
    public VicePresident(String username, String password, String firstName, String lastName, String emailAddress, String nationalID, String phoneNumber, String universityCode, String imageURL, School school, List<Course> courses, MasteryDegree masteryDegree, String roomNumber) {
        super(username, password, firstName, lastName, emailAddress, nationalID, phoneNumber, universityCode, imageURL, school, courses, masteryDegree, roomNumber);
    }
}
