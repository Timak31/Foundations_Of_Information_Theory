import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by timak31 on 18.03.17.
 */
public class ReadFile{
    private int size;
    private String path;

    public ReadFile(String path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public String getText() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        return buildText(reader);
    }

    private String buildText(BufferedReader reader) throws IOException {
        int c;
        String text = "";
        while ((c=reader.read()) != -1) {
            text += (char)c;
            size++;
        }
        text = text.toLowerCase();
        return text;
    }
}
