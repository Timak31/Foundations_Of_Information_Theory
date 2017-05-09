import java.io.IOException;

/**
 * Created by timak31 on 05.04.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Author Timak31");
        Write write = new Write();
        write.showMass();

        Algoritm algoritm = new Algoritm(write.getI(), write.getJ(), write.getMass());
        algoritm.getAi();
        algoritm.getBj();

        algoritm.getpAiSleshBj();
        algoritm.getpBjSleshAi();

        algoritm.gethASleshBj();
        algoritm.gethBSleshAi();

        algoritm.getHA();
        algoritm.getHB();

        algoritm.getHAsleshB();
        algoritm.getHBsleshA();

        algoritm.getAllEntropia();
    }
}
