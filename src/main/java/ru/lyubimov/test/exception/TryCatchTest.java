package ru.lyubimov.test.exception;

import java.io.IOException;

public class TryCatchTest {
    public static void main(String[] args) {
        String s = "Привет!";
        try {
            throw new IOException();
        } catch (IOException ex) {
            System.out.println(s + "1");
        } catch (Exception e) {
            System.out.println(s + "2");
        } finally {
            System.out.println(s + "3");
        }
    }
}
