import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.Random;
import java.util.RandomAccess;
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

    public static String inputIntegerNotNullToString() {
        String input;
        char[] chars;
        boolean flag;
        do {
            flag = false;
            input = inputString();
            chars = input.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (!Character.isDigit(chars[i])) {
                    flag = true;
                }
            }
        } while (input.equals("") || flag);
        return input;
    }

    public static String inputInStartMenu() {
        String input = inputString().toUpperCase();
        while (true) {
            if (input.equals("1") || input.equals("2") || input.equals("3")
                    || input.equals("LOG IN") || input.equals("INFO") || input.equals("EXIT")) {
                break;
            } else {
                System.err.println("Please check your command :(");
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
            userNumber = usersFile.findUserAccordingToUsername(username);
            if (userNumber != -1) {
                file.seek(userNumber * UsersFile.RECORD_SIZE + usersFile.FIX_SIZE * 2);
                password = usersFile.readFixString();
                break;
            }
            System.err.println("please check your username ...");
        }
        System.out.print("password : ");
        while (true) {
            if (password.equals(Input.inputStringNotNull()))
                break;
            System.err.println("please check your password ...");
        }
        file.seek(userNumber * UsersFile.RECORD_SIZE);
        return usersFile.read();
    }

    public Letter inputLetter() {
        Letter letter = new Letter(null, null, null, null, null, null, null);
        String receiverJob;
        first:
        do {
            receiverJob = inputStringNotNull().toLowerCase();
            switch (receiverJob) {
                case "1", "professor" -> {
                    letter.setReceiverJob("professor");
                    break first;
                }
                case "2", "student" -> {
                    letter.setReceiverJob("student");
                    break first;
                }
                case "3", "staff" -> {
                    letter.setReceiverJob("staff");
                    break first;
                }
                default -> System.err.println("please check your password ...");
            }

        } while (true);
        System.out.print("username of " + letter.getReceiverJob() + " : ");
        letter.setReceiverName(inputStringNotNull());
        Date date = new Date();
        letter.setDate(date.toString().substring(0, 20) + date.toString().substring(30, 34));
        System.out.print("Subject : ");
        letter.setSubject(inputStringNotNull());
        System.out.println("TEXT : ");
        letter.setTextOfTheLetter(inputString());
        return letter;
    }

    public void inputUser(User user) throws IOException {
        RandomAccessFile file = new RandomAccessFile("username.dat", "rw");
        RandomAccessFile userFile = new RandomAccessFile("UsersFile.txt", "rw");
        UsersFile usersFile = new UsersFile(userFile);
        int userNumber1, userNumber2;
        while (true) {
            System.out.print("First name : ");
            user.setFirstName(inputStringNotNull());
            System.out.print("Last name : ");
            user.setLastName(inputStringNotNull());
            userNumber1 = usersFile.findUserAccordingToFirstName(user.getFirstName());
            userNumber2 = usersFile.findUserAccordingToLastName(user.getLastName());
            if (userNumber1 == -1 || userNumber2 == -1 || userNumber2 == userNumber1) {
                break;
            }
            System.out.println("This user exists in the system ...");
        }
        file.seek(0);
        if (file.length() == 0)
            file.writeInt(1000);
        file.seek(0);
        int username = file.readInt();
        user.setUsername(String.valueOf(username) + user.getFirstName());
        user.setPassword(String.valueOf(username) + user.getLastName());
        username++;
        file.seek(0);
        file.writeInt(username);
        System.out.printf("Please print user information ... \n" +
                "username : %s\npassword : %s\n", user.getUsername(), user.getPassword());
    }

    public void inputForAddStudentMenu() throws IOException {
        FacultyFile facultyFile = new FacultyFile(new RandomAccessFile("FacultyFile.txt", "rw"));
        do {
            switch (inputStringNotNull().toLowerCase()) {
                case "1", "add students", "file" -> {
                    System.out.print("please enter path of data file : ");
                    facultyFile.addUserFromFile(inputStringNotNull());
                    return;
                }
                case "2", "add student" -> {
                    RandomAccessFile usersFile = new RandomAccessFile("UsersFile.txt", "rw");
                    UsersFile usersFile1 = new UsersFile(usersFile);
                    User user = new User(null, null, "student", null, null);
                    inputUser(user);
                    usersFile.seek(usersFile.length());
                    usersFile1.write(user);
                    usersFile.close();
                    return;
                }
                default -> System.err.println("please check your password ...");
            }
        } while (true);
    }

    public CoursesOfProfessor inputCourseOfProfessor() throws IOException {
//        System.out.print("please enter name of faculty : ");
//        String faculty;
//        while (true) {
//            faculty = inputStringNotNull();
//            if (new FacultyFile(new RandomAccessFile("Faculty.txt", "rw")).findFaculty(faculty) != -1)
//                break;
//            System.err.println("please check your command ...");
//        }
        System.out.print("Professor username : ");
        String username = null;
        while (true) {
            username = inputStringNotNull();
            if (new UsersFile(new RandomAccessFile("UsersFile.txt", "rw")).findUserAccordingToUsername(username) != -1)
                break;
            System.err.println("please check your command ...");
        }
        System.out.print("name of course : ");
        CoursesOfProfessor coursesOfProfessor = new CoursesOfProfessor(inputStringNotNull(), 0, null, 0, username);
        System.out.print("vahed course : ");
        coursesOfProfessor.setCourse(Integer.parseInt(inputIntegerNotNullToString()));
        System.out.println("weekdays : (Sa,Su,Mo,Tu,We)");
        String weekday = null;
        first:
        while (true) {
            coursesOfProfessor.setWeekdays(inputStringNotNull());
            if (coursesOfProfessor.getCourse() > 2) {
                weekday = inputStringNotNull();
                coursesOfProfessor.setWeekdays(coursesOfProfessor.getWeekdays() + weekday);
                switch (weekday) {
                    case "Sa", "Su", "Mo", "Tu", "We":
                        break;
                    default:
                        coursesOfProfessor.setWeekdays("00notTrue");
                }

            }
            if (coursesOfProfessor.getWeekdays().length() < 2)
                continue;
            switch (coursesOfProfessor.getWeekdays().substring(0, 2)) {
                case "Sa", "Su", "Mo", "Tu", "We":
                    break first;
            }
            System.err.println("please check your command ...");
        }
        System.out.print("time of course : ");
        while (true) {
            coursesOfProfessor.setTime(Integer.parseInt(inputIntegerNotNullToString()));
            if (!new CoursesOfProfessorFile(new RandomAccessFile("Courses.txt", "rw")).isThereClockInterference(coursesOfProfessor))
                break;
            System.err.println("Clock Interference ... !!!");
        }
        return coursesOfProfessor;
    }
}
