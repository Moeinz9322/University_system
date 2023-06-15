import java.io.IOException;
import java.io.RandomAccessFile;

public class UsersFile extends File {
    public static final int RECORD_SIZE = 150;

    public UsersFile(RandomAccessFile file) {
        super(file);
    }

    public boolean write(User user) throws IOException {
        writeString(user.getUsername());
        writeString(user.getPassword());
        writeString(user.getJob());
        writeString(user.getFirstName());
        writeString(user.getLastName());
        return true;
    }

    public User read() throws IOException {
        return new User(readFixString(), readFixString(), readFixString(), readFixString(), readFixString());
    }

    public int findUserAccordingToUsername(String username) throws IOException {
        for (int i = 0; i < file.length() / RECORD_SIZE; i++) {
            file.seek(i * RECORD_SIZE);
            if (username.equals(readFixString()))
                return i;
        }
        return -1;
    }

    public boolean findUsername(String username) throws IOException {
        User user;
        for (int i = 0; i < file.length() / RECORD_SIZE; i++) {
            file.seek(i * RECORD_SIZE);
            if (username.equals(readFixString())) {
                file.seek(i * RECORD_SIZE);
                user = read();
                System.out.println(user.getFirstName() + " " + user.getLastName());
            }

        }
        return true;
    }

    public int findUserAccordingToFirstName(String username) throws IOException {
        for (int i = 0; i < file.length() / RECORD_SIZE; i++) {
            file.seek(i * RECORD_SIZE + FIX_SIZE * 6);
            if (username.equals(readFixString()))
                return i;
        }
        return -1;
    }

    public int findUserAccordingToLastName(String username) throws IOException {
        for (int i = 0; i < file.length() / RECORD_SIZE; i++) {
            file.seek(i * RECORD_SIZE + FIX_SIZE * 8);
            if (username.equals(readFixString()))
                return i;
        }
        return -1;
    }

}
