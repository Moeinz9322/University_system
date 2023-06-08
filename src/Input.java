import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

//Check input if it was true return else print Check message
public class Input {
    /**
     * return String
     */
    public static String inputString() {
        Scanner input0 = new Scanner(System.in);
        return input0.nextLine();
    }

    /**
     * return
     */
    public static String inputStringNotNull() {
        String input;
        do {
            input = inputString();
        } while (input.equals(""));
        return input;
    }

    public static String inputInStartMenu() {
        String input = inputString().toUpperCase();
        while (true) {
            if (input.equals("1") || input.equals("2") || input.equals("3")
                    || input.equals("LOG IN") || input.equals("INFO") || input.equals("EXIT")) {
                break;
            } else {
                System.out.println("Please check your command :(");
                input = inputString().toUpperCase();
            }
        }
        return input;
    }

    public User inputForLogIn() throws IOException {
        RandomAccessFile file = new RandomAccessFile("UsersFile.txt", "rw");
        UsersFile usersFile = new UsersFile(file);
        System.out.print("username : ");
        String username;
        String password;
        int userNumber;
        while (true) {
            username = Input.inputStringNotNull();
            userNumber = usersFile.findUser(username);
            if (userNumber != -1) {
                file.seek(userNumber * UsersFile.RECORD_SIZE + usersFile.FIX_SIZE * 2);
                password = usersFile.readFixString();
                break;
            }
            System.out.println("please check your username ...");
        }
        System.out.print("password : ");
        while (true) {
            if (password.equals(Input.inputStringNotNull()))
                break;
            System.out.println("please check your password ...");
        }
        file.seek(userNumber*UsersFile.RECORD_SIZE);
        return usersFile.read();
    }
}
