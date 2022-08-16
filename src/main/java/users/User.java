package users;

import courses.Course;
import schools.School;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String emailAddress;
    protected String nationalID;
    protected String phoneNumber;
    protected String universityCode;
    protected String imageURL;
    protected School school;
    protected List<Course> courses;

    public User(String username, String password, String firstName, String lastName, String emailAddress, String nationalID, String phoneNumber, String universityCode, String imageURL, School school, List<Course> courses) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.nationalID = nationalID;
        this.phoneNumber = phoneNumber;
        this.universityCode = universityCode;
        this.imageURL = imageURL;
        this.school = school;
        this.courses = courses;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getImageURL() {
        return imageURL;
    }

    public School getSchool() {
        return school;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniversityCode() {
        return universityCode;
    }

    public void setUniversityCode(String universityCode) {
        this.universityCode = universityCode;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
