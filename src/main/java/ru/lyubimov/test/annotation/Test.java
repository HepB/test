package ru.lyubimov.test.annotation;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("ru.lyubimov.tests.annotation.Cookies");
        if (!clazz.isAnnotationPresent(ControlledObject.class)) {
            System.out.println("no annotation");
        } else {
            System.out.println("annotated " + clazz.getAnnotation(ControlledObject.class));
            ControlledObject annotation = (ControlledObject) clazz.getAnnotation(ControlledObject.class);
            System.out.println(annotation.name());
        }

        boolean hasStart = false;
        boolean hasStop = false;

        Method[] methods = clazz.getMethods();
        for (Method md : methods) {
            if (md.isAnnotationPresent(StartObject.class)) hasStart = true;
            if (md.isAnnotationPresent(StopObject.class)) hasStop = true;
        }
        System.out.println("Gotta start: " + hasStart + " Gotta stop: " + hasStop);
    }
}
