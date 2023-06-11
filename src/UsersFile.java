import java.io.IOException;
import java.io.RandomAccessFile;

public class UsersFile extends File {
    public static final int RECORD_SIZE = 90;

    public UsersFile(RandomAccessFile file) {
        super(file);
    }

    public boolean write(User user) throws IOException {
        writeString(user.getUsername());
        writeString(user.getPassword());
        writeString(user.getJob());
        return true;
    }

    public User read() throws IOException {
        return new User(readFixString(), readFixString(), readFixString());
    }

    public int findUser(String username) throws IOException {
        for (int i = 0; i < file.length() / RECORD_SIZE; i++) {
            file.seek(i * RECORD_SIZE);
            if (username.equals(readFixString()))
                return i;
        }
        return -1;
    }
}
