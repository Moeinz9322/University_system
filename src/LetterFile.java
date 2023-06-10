import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

public class LetterFile extends File {
    public static final int RECORD_SIZE = 192;

    public LetterFile(RandomAccessFile file) {
        super(file);
    }

    public boolean write(Letter letter) throws IOException {
        fixSizeToWrite(letter.getAuthorJob());
        fixSizeToWrite(letter.getAuthorName());
        fixSizeToWrite(letter.getReceiverJob());
        fixSizeToWrite(letter.getReceiverName());
        file.writeInt(letter.getDate().getYear());
        file.writeInt(letter.getDate().getMonth());
        file.writeInt(letter.getDate().getYear());
        fixSizeToWrite(letter.getSubject());
        fixSizeToWrite(letter.getTextOfTheLetter());
        return true;
    }

    public Letter read() throws IOException {
        Letter letter = new Letter(readFixString(), readFixString(), readFixString(), readFixString()
                , new Date(file.readInt(), file.readInt(), file.readInt()), readFixString(), readFixString());
        return letter;
    }
}
