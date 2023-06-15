import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Moein Zanjirian Zadeh
 * moeinz9322@gmail.com
 * 2023
 */
public class CoursesOfProfessorFile extends File {
    public static final int RECORD_SIZE = 128;

    public CoursesOfProfessorFile(RandomAccessFile file) {
        super(file);
    }

    public boolean write(CoursesOfProfessor coursesOfProfessor) throws IOException {
        writeString(coursesOfProfessor.getCourseName());
        file.writeInt(coursesOfProfessor.getCourse());
        writeString(coursesOfProfessor.getWeekdays());
        file.writeInt(coursesOfProfessor.getTime());
        writeString(coursesOfProfessor.getProfessorUsername());
        writeString(coursesOfProfessor.getExamDate());
        return true;
    }

    public CoursesOfProfessor read() throws IOException {
        return new CoursesOfProfessor(readFixString(), file.readInt(), readFixString(), file.readInt(), readFixString(), readFixString());
    }

    public boolean isThereClockInterference(CoursesOfProfessor coursesOfProfessor) throws IOException {
        String weekday;
        int time;
        for (int i = 0; i < file.length() / RECORD_SIZE; i++) {
            file.seek(i * RECORD_SIZE + (FIX_SIZE * 4) + 8);
            if (readFixString().equals(coursesOfProfessor.getProfessorUsername())) {
                file.seek(i * RECORD_SIZE + (2 * FIX_SIZE) + 4);
                weekday = readFixString();
//                System.out.println(weekday);
                for (int j = 0; j < weekday.length(); j += 2) {
                    for (int z = 0; z < coursesOfProfessor.getWeekdays().length(); z += 2) {
                        if (weekday.substring(j, j + 1).equals(coursesOfProfessor.getWeekdays().substring(z, z + 1))) {
                            file.seek(i * RECORD_SIZE + (4 * FIX_SIZE) + 4);
                            time = file.readInt();
//                            System.out.println(time);
                            if (coursesOfProfessor.getTime() == time + 1 || coursesOfProfessor.getTime() == time - 1 || coursesOfProfessor.getTime() == time)
                                return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    public List<Integer> findCourseName(String courseName) throws IOException {
        List<Integer> courseNumber = new ArrayList<>();
        for (int i = 0; i < file.length() / RECORD_SIZE; i++) {
            file.seek(i * RECORD_SIZE);
            if (courseName.equals(readFixString()))
                courseNumber.add(i);
        }
        return courseNumber;
    }
}
