package ru.lyubimov.test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringUtilsComparatorTest {

    public static void main(String[] args) {
        String a = "-12.23";
        String b = "11";
        String c = "-6";
        String d = "221";
        String e = "9";
        String v = null;

        List<String> strings = new ArrayList<String>();
        strings.add(a);
        strings.add(b);
        strings.add(c);
        strings.add(d);
        strings.add(e);
        strings.add(v);

        Collections.sort(strings, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return StringUtils.compare(o1, o2);
            }
        });

        for (String str : strings) {
            System.out.println(str);
        }
    }

}
