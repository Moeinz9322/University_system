import java.io.IOException;

public class Menu {
    public static void startMenu() throws IOException {
        Menu menu = new Menu();
        String input;
        first:
        while (true) {
            menu.printMenu();
            input = Input.inputInStartMenu();
            switch (input) {
                case "1", "LOG IN":
                    logIn();
                    break;
                case "2", "INFO":
                    info();
                    break;
                case "3", "Exit":
                    break first;
            }
        }
    }

    private void printMenu() {
        System.out.println("""
                ******************* University System ********************
                       ******************* Menu *******************
                1. Log In
                2. Info
                3. Exit""");
    }

    private static void logIn() throws IOException {
        Input input = new Input();
        System.out.println("******************* Log In ********************");
        User user = input.inputForLogIn();
        switch (user.getJob()){
            case "staff":
                staffMenu(user.getUsername());
                break;
            case "professor":
                professorMenu(user.getUsername());
                break;
            case "student":
                studentMenu(user.getUsername());
        }
    }

    private static void staffMenu(String username) {
        System.out.println("staff ...");
    }

    private static void professorMenu(String username) {
        System.out.println("professor ...");
    }

    private static void studentMenu(String username) {
        System.out.println("student ...");
    }

    private static void info() {
        System.out.println("""
                Hello
                Welcome to University System
                author : Moein Zanjirian Zadeh
                since : 6/8/2023
                Email : moeinz9322@gmail.com
                Telegram : @moeinz9322""");
        pauseInputEnter();
    }
    private static void pauseInputEnter() {
        System.out.print("Press enter to return to the previous menu ...");
        Input.inputString();
    }
}
