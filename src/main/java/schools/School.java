package schools;

import courses.Course;
import users.SchoolPresident;
import users.VicePresident;

import java.util.ArrayList;
import java.util.List;

public class School {
    protected String schoolName;
    protected String vicePresidentCode;
    protected String schoolPresidentCode;
    protected List<Course> courses;

    public School(String schoolName, String vicePresidentCode, String schoolPresidentCode, List<Course> courses) {
        this.schoolName = schoolName;
        this.vicePresidentCode = vicePresidentCode;
        this.schoolPresidentCode = schoolPresidentCode;
        this.courses = courses;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getVicePresidentCode() {
        return vicePresidentCode;
    }

    public void setVicePresidentCode(String vicePresidentCode) {
        this.vicePresidentCode = vicePresidentCode;
    }

    public String getSchoolPresidentCode() {
        return schoolPresidentCode;
    }

    public void setSchoolPresidentCode(String schoolPresidentCode) {
        this.schoolPresidentCode = schoolPresidentCode;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public void addCourse(Course course){
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", vicePresidentCode='" + vicePresidentCode + '\'' +
                ", schoolPresidentCode='" + schoolPresidentCode + '\'' +
                ", courses=" + courses +
                '}';
    }
}
