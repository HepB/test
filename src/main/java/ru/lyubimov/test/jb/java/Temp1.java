package ru.lyubimov.test.jb.java;

public class Temp1 {
    float f = (float) (20d + 20.02f); // 1
    long n = 10 + 2L;       // 2
    byte b = (byte) (n + 5);         // 3

    public static void main(String[] args) {
        char ch = 'e';
        ch -= 'a';
        ch++;
        ch += 'b';
        System.out.println(ch);
        Long val = Long.parseLong("4321");
        Long val1 = Long.valueOf("4321");
    }
}
