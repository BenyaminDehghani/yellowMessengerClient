package users;

import courses.Course;
import schools.School;

import java.sql.Time;
import java.util.List;

public class Student extends User{
    protected EducationalStatus educationalStatus;
    protected Master supervisor;
    protected boolean isEligibleToRegister;
    protected boolean confirmedBySupervisor;
    protected String registrationTime;
    protected StudentDegree studentDegree;
    protected String enteringYear;
    protected String averageScore;
    protected String unitsPassed;

    public Student(String username, String password, String firstName, String lastName, String emailAddress, String nationalID, String phoneNumber, String universityCode, String imageURL, School school, List<Course> courses, EducationalStatus educationalStatus, Master supervisor, boolean isEligibleToRegister, boolean confirmedBySupervisor, String registrationTime, StudentDegree studentDegree, String enteringYear, String averageScore,String unitsPassed) {
        super(username, password, firstName, lastName, emailAddress, nationalID, phoneNumber, universityCode, imageURL, school, courses);
        this.educationalStatus = educationalStatus;
        this.supervisor = supervisor;
        this.isEligibleToRegister = isEligibleToRegister;
        this.confirmedBySupervisor = confirmedBySupervisor;
        this.registrationTime = registrationTime;
        this.studentDegree = studentDegree;
        this.enteringYear = enteringYear;
        this.averageScore = averageScore;
        this.unitsPassed = unitsPassed;
    }

    public EducationalStatus getEducationalStatus() {
        return educationalStatus;
    }

    public void setEducationalStatus(EducationalStatus educationalStatus) {
        this.educationalStatus = educationalStatus;
    }

    public Master getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Master supervisor) {
        this.supervisor = supervisor;
    }

    public boolean isEligibleToRegister() {
        return isEligibleToRegister;
    }

    public void setEligibleToRegister(boolean eligibleToRegister) {
        isEligibleToRegister = eligibleToRegister;
    }

    public boolean isConfirmedBySupervisor() {
        return confirmedBySupervisor;
    }

    public void setConfirmedBySupervisor(boolean confirmedBySupervisor) {
        this.confirmedBySupervisor = confirmedBySupervisor;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public StudentDegree getStudentDegree() {
        return studentDegree;
    }

    public void setStudentDegree(StudentDegree studentDegree) {
        this.studentDegree = studentDegree;
    }

    public String  getEnteringYear() {
        return enteringYear;
    }

    public void setEnteringYear(String enteringYear) {
        this.enteringYear = enteringYear;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }

    public String getUnitsPassed() {
        return unitsPassed;
    }

    public void setUnitsPassed(String unitsPassed) {
        this.unitsPassed = unitsPassed;
    }

    @Override
    public String toString() {
        return "Student{" +
                "educationalStatus=" + educationalStatus +
                ", supervisor=" + supervisor +
                ", isEligibleToRegister=" + isEligibleToRegister +
                ", confirmedBySupervisor=" + confirmedBySupervisor +
                ", registrationTime='" + registrationTime + '\'' +
                ", studentDegree=" + studentDegree +
                ", enteringYear='" + enteringYear + '\'' +
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
