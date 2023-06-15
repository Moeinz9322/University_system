import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 * @author Moein Zanjirian Zadeh
 * moeinz9322@gmail.com
 * 2023
 */
public class SemestersFile extends File {
    public final int RECORD_SIZE = 78;

    public SemestersFile(RandomAccessFile file) {
        super(file);
    }

    public void write(String condition) throws IOException {
        Date date = new Date();
        writeString(condition);
        writeStringDate(date.toString().substring(0, 20) + date.toString().substring(30, 34));
    }

    public String read() throws IOException {
        return readFixString() + readFixStringForDate();
    }
}
