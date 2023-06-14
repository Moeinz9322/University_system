import java.io.*;

/**
 * @author Moein Zanjirian Zadeh
 * moeinz9322@gmail.com
 * 2023
 */
public class FacultyFile extends UsersFile {
    public FacultyFile(RandomAccessFile file) {
        super(file);
    }

    public int findFaculty(String faculty) throws IOException {
        for (int i = 0; i < file.length() / (FIX_SIZE * 6); i++) {
            file.seek(i * FIX_SIZE * 6);
            if (readFixString().equals(faculty))
                return i;
        }
        return -1;
    }

    @Override
    public boolean write(User user) throws IOException {
        writeString(user.getUsername());
        writeString(user.getPassword());
        writeString(user.getFirstName());
        writeString(user.getLastName());
        return true;
    }

    @Override
    public User read() throws IOException {
        return new User(readFixString(), readFixString(), null, readFixString(), readFixString());
    }


    public void addUserFromFile(String filePath) throws IOException {
        FileInputStream fileData = new FileInputStream(filePath + ".txt");
        DataInputStream streamData = new DataInputStream(fileData);
        BufferedReader dataLine = new BufferedReader(new InputStreamReader(streamData));
        String stringLine;
        User user = new User(null, null, "student", null, null);
        RandomAccessFile file = new RandomAccessFile("username.dat", "rw");
        RandomAccessFile userFile = new RandomAccessFile("UsersFile.txt", "rw");
        UsersFile usersFile1 = new UsersFile(userFile);
        int username;
        while ((stringLine = dataLine.readLine()) != null) {
            user.setFirstName(stringLine.substring(0, stringLine.indexOf(" ")));
            user.setLastName(stringLine.substring(stringLine.indexOf(" "), stringLine.length()));
//            System.out.println(user.getLastName()+" "+user.getFirstName());
            file.seek(0);
            if (file.length() == 0)
                file.writeInt(1000);
            file.seek(0);
            username = file.readInt();
            user.setUsername(String.valueOf(username) + user.getFirstName());
            user.setPassword(String.valueOf(username) + user.getLastName());
            username++;
            file.seek(0);
            file.writeInt(username);
            userFile.seek(userFile.length());
            usersFile1.write(user);
        }
    }
}
