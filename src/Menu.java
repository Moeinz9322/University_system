import java.io.IOException;

public class Menu {
    public static void startMenu() {
        Menu menu = new Menu();
        String input;
        first:
        while (true) {
            menu.printMenu();
            input = Input.inputInStartMenu();
            switch (input) {
                case "1", "Login":
                    signIn();
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
                1. Login
                2. Info
                3. Exit
                """);
    }

    private static void signIn() {
        System.out.println("""
                ******************* Login ********************
                """);
        System.out.print("username : ");
        String username = Input.inputStringNotNull();
        System.out.print("password : ");
        String password = Input.inputStringNotNull();
    }

    private static void info() {

    }
}
