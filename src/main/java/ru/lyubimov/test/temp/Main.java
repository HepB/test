package ru.lyubimov.test.temp;

public class Main {
    public static void main(String[] args) {
        int a = 15;
        int b = 7;
        int c = 10;
        int p1 = (a + b + c) / 2;
        double s = Math.sqrt(p1 * ((p1 - a * p1 - b) * (p1 - c)));
        System.out.println(s);
    }
}

