import java.io.IOException;

/**
 * Created by timak31 on 18.03.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ReadFile rFile = new ReadFile("src\\text.txt");
        Algoritm algoritm = new Algoritm();

        algoritm.showResult(algoritm.ukrainOrRussianLanguege(rFile.getText(), rFile.getSize()));

        System.out.println("\nЕнтропія повідомлення: " + algoritm.getInformation() + " (біт/повідомлення)");
    }
}
