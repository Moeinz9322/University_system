import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

public class LetterFile extends File {
    public static final int RECORD_SIZE = 192;
    public static final int FIX_SIZE_FOR_DATE = 24;
    public static final int FIX_SIZE_FOR_TEXT = 500;

    public LetterFile(RandomAccessFile file) {
        super(file);
    }

    /**
     * write a string in a file of child
     * param str
     * throws IOException
     */
    public void writeStringText(String str) throws IOException {
        file.writeChars(fixSizeToWriteText(str));
    }

    private void writeStringDate(String str) throws IOException {
        file.writeChars(this.fixSizeToWriteDate(str));
    }

    private String fixSizeToWriteDate(String str) {
        while (str.length() < FIX_SIZE_FOR_DATE) {
            str += " ";
        }
        return str.substring(0, FIX_SIZE_FOR_DATE);
    }

    /**
     * fix size So that we can read the file later
     * param str
     * return
     */
    public String fixSizeToWriteText(String str) {
        while (str.length() < FIX_SIZE_FOR_TEXT) {
            str += " ";
        }
        return str.substring(0, FIX_SIZE_FOR_TEXT);
    }

    /**
     * read a string to the length FIX_SIZE
     * return  a string to the length FIX_SIZE
     * throws IOException
     */
    public String readFixStringText() throws IOException {
        String tmp = "";
        for (int i = 0; i < FIX_SIZE_FOR_TEXT; i++) {
            tmp += file.readChar();
        }
        return tmp.trim();
    }

    public boolean write(Letter letter) throws IOException {
        writeString(letter.getAuthorJob());
        writeString(letter.getAuthorName());
        writeString(letter.getReceiverJob());
        writeString(letter.getReceiverName());
        writeStringDate(letter.getDate());
        writeString(letter.getSubject());
        writeStringText(letter.getTextOfTheLetter());
        return true;
    }

    private String readFixStringForDate() throws IOException {
        String tmp = "";
        for (int i = 0; i < FIX_SIZE_FOR_DATE; i++) {
            tmp += file.readChar();
        }
        return tmp.trim();
    }

    public Letter read() throws IOException {
        Letter letter = new Letter(null,
                null, null, null, null, null, null);
        letter.setAuthorJob(readFixString());
        letter.setAuthorName(readFixString());
        letter.setReceiverJob(readFixString());
        letter.setReceiverName(readFixString());
        letter.setDate(readFixStringForDate());
        letter.setSubject(readFixString());
        letter.setTextOfTheLetter(readFixStringText());
//        System.out.println(letter);
        return letter;
    }
}
