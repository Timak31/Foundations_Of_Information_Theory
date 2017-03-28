import java.util.HashMap;
import java.util.Map;

/**
 * Created by timak31 on 18.03.17.
 */
public class Algoritm {
    private final int first = 32;
    private final int last = 63;
    private int firstSymbol;
    private int lastSymbol;
    private int size;
    private String text;
    private double information;

    public double getInformation() {
        return information;
    }

    public int getSize() {
        return size;
    }

    public Map<String, Double> ukrainOrRussianLanguege(String textAgain, int sizeText) {
        firstSymbol = 1072;
        lastSymbol = 1111;
        this.size = sizeText;
        this.text = textAgain;
        System.out.println("Кількість символів в тексті: " + size);
        return findAllSynbols();
    }

    public Map<String, Double> englishLanguege(String textAgain, int sizeText) {
        firstSymbol = 97;
        lastSymbol = 122;
        this.size = sizeText;
        this.text = textAgain;
        System.out.println("Кількість символів в тексті: " + size);
        return findAllSynbols();
    }

    private Map<String, Double> findAllSynbols() {
        Map<String, Integer> map = new HashMap<>();
        int count=0;
        for (int i=firstSymbol; i<lastSymbol+1; i++) {
            char buffer = (char)i;
            for (int j=0; j<size; j++) {
                if (buffer == text.charAt(j)) {
                    count++;
                }
            }
            map.put(String.valueOf(buffer), count);
            count=0;
        }

        for (int i=first; i<last+1; i++) {
            char buffer = (char)i;
            for (int j=0; j<size; j++) {
                if (buffer == text.charAt(j)) {
                    count++;
                }
            }
            map.put(String.valueOf(buffer), count);
            count=0;
        }
        return result(map);
    }

    public void showResult(Map<String, Double> allKeyValue) {
        System.out.println("Кількість інфораміції символа:");
        System.out.println("-------------------------");
        for (Map.Entry<String, Double> pair : allKeyValue.entrySet()) {
            String key = pair.getKey();
            double value = pair.getValue();
            System.out.println(key + " = " + value);
        }
    }

    private Map<String, Double> result(Map<String, Integer> mapAgain) {
        Map<String, Double> newHashMap = new HashMap<>();
        System.out.println("Ймовірність появи символа в тексті:");
        System.out.println("-------------------------");
        for (Map.Entry<String, Integer> pair : mapAgain.entrySet()) {
            String sPair = pair.getKey();
            Integer iPair = pair.getValue();
            if (iPair != 0) {
                System.out.println(sPair + " = " + (double)iPair/size);
                newHashMap.put(sPair, -(Math.log((double)iPair/size)/Math.log(2)));
                information += -(Math.log((double)iPair/size)/Math.log(2))*(double)iPair/size;
            }
        }
        System.out.println("-------------------------");
        return newHashMap;
    }
}
