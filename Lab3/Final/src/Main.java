import java.io.IOException;

/**
 * Created by timak31 on 05.04.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Write write = new Write();
        write.showMass();

        Algoritm algoritm = new Algoritm(write.getI(), write.getJ(), write.getMass());
        algoritm.getAllEntropia();
    }
}
