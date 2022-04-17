package ru.lyubimov.test.jb.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class FileTest {

    private static final String PATH = "src\\main\\resources\\dataset_91069.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(PATH);

        Scanner scanner = new Scanner(file);

        long highestDiff = -1;
        long prevPopulation = -1;
        int targetYear = -1;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] words = line.split("\t+");
            long population;
            int year;
            try {
                population = new BigInteger(words[1].replace(",", "")).longValue();
                year = Integer.parseInt(words[0]);
            } catch (Exception e) {
                continue;
            }
            if (prevPopulation != -1) {
                long currentDiff = Math.abs(population - prevPopulation);
                if (currentDiff > highestDiff) {
                    highestDiff = currentDiff;
                    targetYear = year;
                }
            }
            prevPopulation = population;
        }
        scanner.close();
        System.out.println(targetYear);
    }
}
