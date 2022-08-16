package users;

import courses.Course;
import schools.School;

import java.util.List;

public class Master extends User{
    MasteryDegree masteryDegree;
    String roomNumber;

    public Master(String username, String password, String firstName, String lastName, String emailAddress, String nationalID, String phoneNumber, String universityCode, String imageURL, School school, List<Course> courses, MasteryDegree masteryDegree, String roomNumber) {
        super(username, password, firstName, lastName, emailAddress, nationalID, phoneNumber, universityCode, imageURL, school, courses);
        this.masteryDegree = masteryDegree;
        this.roomNumber = roomNumber;
    }

    public MasteryDegree getMasteryDegree() {
        return masteryDegree;
    }

    public void setMasteryDegree(MasteryDegree masteryDegree) {
        this.masteryDegree = masteryDegree;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Master{" +
                "masteryDegree=" + masteryDegree +
                ", roomNumber='" + roomNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", nationalID='" + nationalID + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", universityCode='" + universityCode + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", school=" + school +
                ", courses=" + courses +
                '}';
    }
}
