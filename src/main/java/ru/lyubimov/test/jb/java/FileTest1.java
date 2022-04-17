package ru.lyubimov.test.jb.java;

import java.io.*;

public class FileTest1 {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\resources\\file.txt"); // some file
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.printf("%s", "Lorem ipsum dolor sit amet");
        fileWriter.flush();
        printWriter.flush();
    }
}
