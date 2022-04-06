package ru.lyubimov.test.jb.java.sup;

public class SubClass extends SuperClass {
    protected int field;

    public SubClass() {
        this.field = 30;  // It initializes the field of SubClass
        field = 30;       // It also initializes the field of SubClass
        super.field = 20; // It initializes the field of SuperClass
    }

    /**
     * It prints the value of SuperClass and then the value of SubClass
     */
    public void printSubValue() {
        super.printBaseValue(); // It invokes the method of SuperClass, super is optional here
        System.out.println(field);
    }
}
