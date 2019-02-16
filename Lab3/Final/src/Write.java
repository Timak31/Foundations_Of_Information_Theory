import java.io.*;

/**
 * Created by timak31 on 05.04.17.
 */
public class Write {
    private int i;
    private int j;
    private double mass[][];

    public Write() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введіть кількість рядків: ");
        i = Integer.parseInt(reader.readLine());
        System.out.println("Введіть кількість стовпців: ");
        j = Integer.parseInt(reader.readLine());
        mass = new double[i][j];
        System.out.println("Введіть значення матриці: ");
        for (int r=0; r<i; r++) {
            for (int s=0; s<j; s++) {
                mass[r][s] = Double.parseDouble(reader.readLine());
            }
        }
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public double[][] getMass() {
        return mass;
    }

    public void showMass() {
        System.out.println("Матриця ймовірностей:");
        for (int r=0; r<this.i; r++) {
            for (int s=0; s<this.j; s++) {
                System.out.print(mass[r][s] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
