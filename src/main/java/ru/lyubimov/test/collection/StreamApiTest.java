package ru.lyubimov.test.collection;

import java.util.Arrays;
import java.util.List;

public class StreamApiTest {
    public static void main(String[] args) {
        List<Integer> collection = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumOdd = collection.stream().filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println(sumOdd);
    }
}
