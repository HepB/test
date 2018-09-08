package ru.lyubimov.test.patterns.singletone;

class ClassicSingleton {

    private volatile static ClassicSingleton uniqueInstance;

    private ClassicSingleton() {
    }
    public static ClassicSingleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (ClassicSingleton.class) {
                uniqueInstance = new ClassicSingleton();
            }
        }
        return uniqueInstance;
    }
}
