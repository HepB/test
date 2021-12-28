package ru.lyubimov.test.garry;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GarryExplanation {

    public static void main(String[] args) {
        Cat cat = new Cat("Васька", 6);
        Cat cat2 = new Cat();

        System.out.println(cat.age);
        System.out.println(cat.sayMeou());

        JTextField textField = new JTextField();
        textField.addActionListener(actionEvent -> {

        });
    }
}
