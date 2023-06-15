import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Moein Zanjirian Zadeh
 * moeinz9322@gmail.com
 * 2023
 */
public class CoursesOfStudentsFile extends File {

    public static final int RECORD_SIZE = 98;

    public CoursesOfStudentsFile(RandomAccessFile file) {
        super(file);
    }

    public void write(CoursesOfStudents coursesOfStudents) throws IOException {
        writeString(coursesOfStudents.getCourseName());
        writeString(coursesOfStudents.getStudentUsername());
        writeString(coursesOfStudents.getExamDate());
        file.writeInt(coursesOfStudents.getCourseNumber());
        file.writeInt(coursesOfStudents.getGrade());
    }

    public CoursesOfStudents read() throws IOException {
        return new CoursesOfStudents(readFixString(), readFixString(), readFixString(), file.readInt(), file.readInt());
    }

    public boolean isThereClockInterference(CoursesOfStudents coursesOfStudents) throws IOException {
        RandomAccessFile coursesFile = new RandomAccessFile("Courses.txt", "rw");
        CoursesOfProfessorFile coursesOfProfessorFile = new CoursesOfProfessorFile(coursesFile);
        String weekday1, weekday2;
        int time;
        for (int i = 0; i < file.length() / RECORD_SIZE; i++) {
            file.seek(i * RECORD_SIZE + (2 * FIX_SIZE));
            if (coursesOfStudents.getStudentUsername().equals(readFixString())) {
                file.seek(i * RECORD_SIZE);
                if (readFixString().equals(coursesOfStudents.getCourseName())) {
                    System.out.println("You have already chosen this course ...");
                    return true;
                }
                file.seek(i * RECORD_SIZE + (4 * FIX_SIZE));
                if (readFixString().equals(coursesOfStudents.getExamDate())) {
                    System.out.println("Exam time interference ...");
                    return true;
                }
//                coursesFile.seek(coursesOfStudents.getCourseNumber()*CoursesOfStudentsFile.RECORD_SIZE+(FIX_SIZE*6)+8);
//                examDate = coursesOfProfessorFile.readFixString();
////                System.out.println(examDate);
//                file.seek(i*RECORD_SIZE+(6*FIX_SIZE));
//                coursesFile.seek(file.readInt()*CoursesOfStudentsFile.RECORD_SIZE+(FIX_SIZE*6)+8);
//                if(examDate.equals(coursesOfProfessorFile.readFixString()))
//                    return true;
                coursesFile.seek(coursesOfStudents.getCourseNumber() * CoursesOfProfessorFile.RECORD_SIZE + (FIX_SIZE * 2) + 4);
                weekday2 = coursesOfProfessorFile.readFixString();
                file.seek(i * RECORD_SIZE + (6 * FIX_SIZE));
                coursesFile.seek(file.readInt() * CoursesOfProfessorFile.RECORD_SIZE + (FIX_SIZE * 2) + 4);
                weekday1 = coursesOfProfessorFile.readFixString();
                for (int j = 0; j < weekday1.length(); j += 2) {
                    for (int z = 0; z < weekday2.length(); z += 2) {
                        if (weekday1.substring(j, j + 1).equals(weekday2.substring(z, z + 1))) {
                            coursesFile.seek(coursesOfStudents.getCourseNumber() * CoursesOfProfessorFile.RECORD_SIZE + (FIX_SIZE * 4) + 4);
                            time = coursesFile.readInt();
                            file.seek(i * RECORD_SIZE + (6 * FIX_SIZE));
                            coursesFile.seek(file.readInt() * CoursesOfProfessorFile.RECORD_SIZE + (FIX_SIZE * 4) + 4);
                            if (time == coursesFile.readInt()) {
                                System.out.println("Class time interference ...");
                                return true;
                            }
                        }
                    }
                }

            }
        }
        return false;
    }

    public List<Integer> findCourseNumber(int courseNumber) throws IOException {
        List<Integer> coursesNumber = new ArrayList<>();
        for (int i = 0; i < file.length() / RECORD_SIZE; i++) {
            file.seek(i * RECORD_SIZE + FIX_SIZE * 6);
            if (courseNumber == file.readInt())
                coursesNumber.add(i);
        }
        return coursesNumber;
    }
}
