package ru.lyubimov.test.patterns.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    "D:\\Java\\LyubimovTest\\src\\main\\java\\ru\\lyubimov\\test\\patterns\\decorator\\test.txt")));
            while ((c = in.read()) >=0 ) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
