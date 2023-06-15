import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Moein Zanjirian Zadeh
 * moeinz9322@gmail.com
 * 2023
 */
public class ReportFile extends File{
    public static final int RECORD_SIZE = 98;
    public ReportFile(RandomAccessFile file) {
        super(file);
    }
    public void write(String firstName , String lastName , double grade ,String condition) throws IOException {
        writeString(firstName);
        writeString(lastName);
        file.writeDouble(grade);
        writeString(condition);
    }
    public void read() throws IOException {
        for (int i = 0; i < file.length()/RECORD_SIZE; i++) {
            file.seek(i*RECORD_SIZE);
            System.out.println(readFixString()+" "+readFixString());
            System.out.println("grade : "+file.readDouble());
            System.out.println(readFixString());
            System.out.println("..........................................................................");
        }
    }
}
