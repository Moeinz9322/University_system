/**
 * @author Moein Zanjirian Zadeh
 * moeinz9322@gmail.com
 * 2023
 */
public class CoursesOfProfessor {
    private String courseName;
    private int course;
    private String weekdays;
    private int time;
    private String professorUsername;

    public CoursesOfProfessor(String courseName, int course, String weekdays, int time, String professorUsername) {
        this.courseName = courseName;
        this.course = course;
        this.weekdays = weekdays;
        this.time = time;
        this.professorUsername = professorUsername;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(String weekdays) {
        this.weekdays = weekdays;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getProfessorUsername() {
        return professorUsername;
    }

    public void setProfessorUsername(String professorUsername) {
        this.professorUsername = professorUsername;
    }

    @Override
    public String toString() {
        return "CoursesOfProfessor{" +
                "courseName='" + courseName + '\'' +
                ", course=" + course +
                ", weekdays='" + weekdays + '\'' +
                ", time=" + time +
                ", professorUsername='" + professorUsername + '\'' +
                '}';
    }
}
