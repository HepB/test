package ru.lyubimov.test.different.garry;

public class Person {
    private String firstName = null;
    private String secondName = null;

    public void setFirstName(String firstName) {
        if(firstName.isEmpty()) {
            System.out.println("Что ты делаешь, дурак? Имя пустое");
        } else {
            this.firstName = firstName;
        }
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void createError() {
        int a = 10 / 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
