package ru.lyubimov.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface TestDenis {


    static void main(String[] args) {
        try {
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date date = format.parse("11.12.1313");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
