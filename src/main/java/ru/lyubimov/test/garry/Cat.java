package ru.lyubimov.test.garry;

public class Cat {

    String name;
    int age = 3;

    public Cat(String name, int age) {
        this.name = name;
        this.age = this.age + age;
    }

    public Cat() {}

    int getCatAge() {
         return 9;
    }

    String sayMeou() {
        return "meou";
    }

    int plus() {
        return 22 + 12;
    }

}

