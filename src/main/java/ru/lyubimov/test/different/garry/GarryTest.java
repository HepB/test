package ru.lyubimov.test.different.garry;

public class GarryTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("");
        person.setSecondName("Ахматмагреев");
        System.out.println(person);
        System.out.println("Гарри Ахматгареев");


        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}
