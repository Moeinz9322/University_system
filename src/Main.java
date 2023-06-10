import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 * university system
 *
 * @author Moein Zanjirian Zadeh
 * @since 6/8/2023
 * Email : moeinz9322@gmail.com
 * Telegram : @moeinz9322
 */
public class Main {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("UsersFile.txt", "rw");
            UsersFile usersFile = new UsersFile(file);
            file.seek(0);
            usersFile.write(new User("ali amini", "1111", "staff"));
            Menu.startMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}