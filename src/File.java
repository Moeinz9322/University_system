import java.io.IOException;
import java.io.RandomAccessFile;

public class File {
    RandomAccessFile file;
    public static final int FIX_SIZE_FOR_DATE = 24;
    public final int FIX_SIZE = 15;//size of string (username , password , job)


    public File(RandomAccessFile file) {
        this.file = file;
    }

    /**
     * write a string in a file of child
     * param str
     * throws IOException
     */
    public void writeString(String str) throws IOException {
        file.writeChars(fixSizeToWrite(str));
    }

    /**
     * fix size So that we can read the file later
     * param str
     * return
     */
    public String fixSizeToWrite(String str) {
        while (str.length() < FIX_SIZE) {
            str += " ";
        }
        return str.substring(0, FIX_SIZE);
    }

    /**
     * read a string to the length FIX_SIZE
     * return  a string to the length FIX_SIZE
     * throws IOException
     */
    public String readFixString() throws IOException {
        String tmp = "";
        for (int i = 0; i < FIX_SIZE; i++) {
            tmp += file.readChar();
        }
        return tmp.trim();
    }

    public void writeStringDate(String str) throws IOException {
        file.writeChars(this.fixSizeToWriteDate(str));
    }

    private String fixSizeToWriteDate(String str) {
        while (str.length() < FIX_SIZE_FOR_DATE) {
            str += " ";
        }
        return str.substring(0, FIX_SIZE_FOR_DATE);
    }

    public String readFixStringForDate() throws IOException {
        String tmp = "";
        for (int i = 0; i < FIX_SIZE_FOR_DATE; i++) {
            tmp += file.readChar();
        }
        return tmp.trim();
    }
}
