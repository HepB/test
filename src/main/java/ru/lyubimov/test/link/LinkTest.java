package ru.lyubimov.test.link;

import java.util.*;

public class LinkTest {

    public static void main(String[] args) {
        secondTest();
    }

    private static void firstTest() {
        ExampleClass exampleClass = new ExampleClass();
        ExampleClass[] exampleClasses = new ExampleClass[3];
        exampleClass.setString("first");
        for (int i = 0; i < 3; i++) {
            exampleClasses[i] = exampleClass;
        }

        for(ExampleClass example : exampleClasses) {
            System.out.println(example.getString());
        }
        exampleClass.setString("second");

        for(ExampleClass example : exampleClasses) {
            System.out.println(example.getString());
        }

        exampleClasses[0].setString("third");

        for(ExampleClass example : exampleClasses) {
            System.out.println(example.getString());
        }
    }

    private static void secondTest() {
        ExampleClass firstClass = new ExampleClass();
        firstClass.setString("one");
        ExampleClass secondClass = new ExampleClass();
        secondClass.setString("two");

        List<ExampleClass> examplesList = new ArrayList<>();
        examplesList.add(firstClass);
        examplesList.add(secondClass);

        Set<ExampleClass> examplesSet = new HashSet<>();
        examplesSet.add(examplesList.get(0));
        examplesSet.add(examplesList.get(1));

        examplesList.get(0).setString("NEW_GENERATION");

        for (ExampleClass exampleClass : examplesSet) {
            System.out.println(exampleClass.getString());
        }

    }
}
