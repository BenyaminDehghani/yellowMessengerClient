package courses;

import java.util.ArrayList;
import java.util.List;

public class Course {
    protected String courseName;
    protected String courseNumber;
    protected List<Course> prerequisites;
    protected List<Course> corequisites;
    protected String examDate;
    protected List<String> classTimes;
    protected String numberOfUnits;

    public Course(String courseName, String courseNumber, List<Course> prerequisites, List<Course> corequisites, String examDate, List<String> classTimes , String numberOfUnits) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.prerequisites = prerequisites;
        this.corequisites = corequisites;
        this.examDate = examDate;
        this.classTimes = classTimes;
        this.numberOfUnits = numberOfUnits;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addPrerequisite(Course course){
        this.prerequisites.add(course);
    }

    public void addCorequisite(Course course){
        this.corequisites.add(course);
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<Course> getCorequisites() {
        return corequisites;
    }

    public void setCorequisites(List<Course> corequisites) {
        this.corequisites = corequisites;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public List<String> getClassTimes() {
        return classTimes;
    }

    public void setClassTimes(List<String> classTimes) {
        this.classTimes = classTimes;
    }

    public String getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(String numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                ", prerequisites=" + prerequisites +
                ", corequisites=" + corequisites +
                ", examDate='" + examDate + '\'' +
                ", classTimes=" + classTimes +
                '}';
    }
}
