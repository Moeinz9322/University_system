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
            Date date = new Date();
            System.out.println(date.toString().substring(0, 20) + date.toString().substring(30));
            RandomAccessFile file = new RandomAccessFile("UsersFile.txt", "rw");
            UsersFile usersFile = new UsersFile(file);
            file.seek(0);
            usersFile.write(new User("Ali", "1111", "staff"));
            usersFile.write(new User("Shokoofeh", "1111", "professor"));
            usersFile.write(new User("Moein", "1111", "student"));
            Menu.startMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}