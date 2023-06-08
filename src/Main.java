import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

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
            RandomAccessFile rfile = new RandomAccessFile("UsersFile.txt", "rw");
            Menu.startMenu();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}