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
                    || input.equals("Login") || input.equals("INFO") || input.equals("EXIT")) {
                break;
            } else {
                System.out.println("Please check your command :(");
                input = inputString().toUpperCase();
            }
        }
        return input;
    }
}
