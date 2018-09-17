package ru.lyubimov.test.link;

public class LinkTest {

    public static void main(String[] args) {
        firstTest();
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
}
