package pp;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        zadanie1();
        zadanie2();
        zadanie3();
    }

    private static void zadanie1(){
        System.out.println("\nzadanie 1\n");

        final int n = 1000000;

        int[] tab = new int[n];
        List<Integer> array1 = new ArrayList<>();
        List<Integer>  array2 = new ArrayList<>(n);
        List<Integer>  linked = new LinkedList<>();

        long startTime = System.nanoTime();
        for(int i = 0; i < n; i++){
            tab[i] = i;
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Czas tworzenia tablicy: " + (double)estimatedTime/1E6 + "ms");

        long startTime2 = System.nanoTime();
        for(int i = 0; i < n; i++){
            array1.add(i);
        }
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("Czas tworzenia ArrayList: " + (double)estimatedTime2/1E6 + "ms");

        long startTime3 = System.nanoTime();
        for(int i = 0; i < n; i++){
            array2.add(i);
        }
        long estimatedTime3 = System.nanoTime() - startTime3;
        System.out.println("Czas tworzenia ArrayList z podanym rozmiarem: " + (double)estimatedTime3/1E6 + "ms");

        long startTime4 = System.nanoTime();
        for(int i = 0; i < n; i++){
            linked.add(i);
        }
        long estimatedTime4 = System.nanoTime() - startTime4;
        System.out.println("Czas tworzenia LinkedList: " + (double)estimatedTime4/1E6 + "ms");
    }

    private static void zadanie2(){
        System.out.println("\nzadanie 2\n");
        BigInteger silnia = BigInteger.ONE;
        NumberFormat formatter = new DecimalFormat("0.######E0");
        final int n = 100;
        long startTime = System.nanoTime();
        for (int i = 1; i <= n; i++) {
            silnia = silnia.multiply(BigInteger.valueOf(i));
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Czas liczenia silni: " + (double)estimatedTime/1E6 + "ms");
        System.out.println(n + "! = " + formatter.format(silnia));
    }

    private static void zadanie3() throws IOException {
        System.out.println("\nzadanie 3\n");
        long uniqueWords = Files.lines(Paths.get("macbeth.txt"))
                .flatMap(line -> Arrays.stream(line.trim().split("\\W+")))
                .map(String::toLowerCase)
                .distinct()
                .count();

        System.out.println("W pliku macbeth.txt znajduje sie " + uniqueWords + " unikalnych slow");
    }
}
