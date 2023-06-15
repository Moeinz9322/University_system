/**
 * @author Moein Zanjirian Zadeh
 * moeinz9322@gmail.com
 * 2023
 */
public class CoursesOfStudents {
    private String courseName;
    private String studentUsername;
    private String examDate;
    private int courseNumber;
    private double grade;

    public CoursesOfStudents(String courseName, String studentUsername, String examDate, int courseNumber, double grade) {
        this.courseName = courseName;
        this.studentUsername = studentUsername;
        this.examDate = examDate;
        this.courseNumber = courseNumber;
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CoursesOfStudents{" +
                "courseName='" + courseName + '\'' +
                ", studentUsername='" + studentUsername + '\'' +
                ", examDate='" + examDate + '\'' +
                ", courseNumber=" + courseNumber +
                ", grade=" + grade +
                '}';
    }
}
