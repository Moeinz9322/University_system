import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Moein Zanjirian Zadeh
 * moeinz9322@gmail.com
 * 2023
 */
public class FacultyFile extends UsersFile {
    public FacultyFile(RandomAccessFile file) {
        super(file);
    }

    public int findFaculty(String faculty) throws IOException {
        for (int i = 0; i < file.length() / (FIX_SIZE * 2); i++) {
            file.seek(i * FIX_SIZE * 2);
            if (readFixString().equals(faculty))
                return i;
        }
        return -1;
    }
}
