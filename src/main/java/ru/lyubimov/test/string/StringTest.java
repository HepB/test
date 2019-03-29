package ru.lyubimov.test.string;

import java.util.Date;

public class StringTest {
    private static String s = "asdf34vcaraweraaaf324dfsfadsfar3ewFFAASDFADFFADF32dfasdfadf354aadfadfadfa43rfadsfdgagadcvcva4fdf3refdgdgdg4fW";

    private static void testOne() {
        Date dateOne = new Date();
        for (int i = 0; i < 1000000; i++) {
            String v = s.replace("3", "");
        }
        Date dateTwo = new Date();
        System.out.println(dateTwo.getTime() - dateOne.getTime());
    }

    private static void main(String[] args) {
        //testOne();
        //testTwo();
        formatTest();
    }

    private static void testTwo() {
        Date dateOne = new Date();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            for (char c : s.toCharArray()) {
                if (c == ',') {
                    continue;
                }
                sb.append(c);
            }
        }
        Date dateTwo = new Date();
        System.out.println(dateTwo.getTime() - dateOne.getTime());
    }

    private static void formatTest() {
        long number = 1234422123213214232L;
        System.out.println(String.format("%d", number));
    }
}
