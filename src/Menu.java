import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.Random;
import java.util.RandomAccess;

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
        Menu menu = new Menu();
        Input input = new Input();
        System.out.println("******************* Log In ********************");
        User user = input.inputForLogIn();
        switch (user.getJob()) {
            case "staff" -> staffMenu(user.getUsername());
            case "professor" -> menu.professorMenu(user.getUsername());
            case "student" -> menu.studentMenu(user.getUsername());
        }
    }

    private static void staffMenu(String username) throws IOException {
        Menu menu = new Menu();
        outer:
        while (true) {

            System.out.println("""
                    ******************* Staff Menu ********************
                    1. Add a new professor
                    2. Add a new faculty
                    3. Add students
                    4. Write letter
                    5. View letters
                    6. Add a new semester
                    7. Add a new course to the current semester
                    8. End the current semester
                    9. return to the main menu""");
            boolean again;
            do {
                again = false;
                switch (Input.inputIntegerNotNullToString()) {
                    case "1" -> menu.addProfessor();
                    case "2" -> menu.addFaculty();
                    case "3" -> menu.addStudent();
                    case "4" -> menu.writeLetter("staff", username);
                    case "5" -> menu.viewLetters();
                    case "6" -> menu.addSemester();
                    case "7" -> menu.addCourse();
                    case "8" -> menu.endSemester();
                    case "9" -> {
                        break outer;
                    }
                    default -> {
                        System.out.println("please check your comment ... ");
                        again = true;
                    }
                }
            } while (again);
        }
    }

    private void addProfessor() {
        //add to users and faculty
        System.out.println("add professor");
    }

    private void addFaculty() {
//        RandomAccessFile file = new RandomAccessFile("Faculty.txt","rw");
//
        //add to faculty and creat faculty
        System.out.println("add faculty");
    }

    private void addStudent() {
        System.out.println("add student");
    }

    private void writeLetter(String userJob, String username) throws IOException {
        System.out.print("""
                ******************* Write letter Menu ********************
                write letter for :
                1. Professor
                2. Student
                3. Staff
                """);
        RandomAccessFile file = new RandomAccessFile("Letter.txt", "rw");
        file.seek(file.length());
        Letter letter = new Input().inputLetter();
        letter.setAuthorJob(userJob);
        letter.setAuthorName(username);
//        System.out.println(letter);
        new LetterFile(file).write(letter);
        System.out.println("successful ....");
        pauseInputEnter();
    }

    private void viewLetters() {
        System.out.println("view letter");
    }

    private void addSemester() {
        System.out.println("add semester");
    }

    private void addCourse() {
        System.out.println("add course");
    }

    private void endSemester() {
        System.out.println("end semester");
    }


    private void studentMenu(String username) {
        System.out.println("student ...");
    }

    private void professorMenu(String username) {
        System.out.println("professor ...");
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
