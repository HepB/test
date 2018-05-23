package ru.lyubimov.test.dagger;

import javax.inject.Inject;

public class Stark implements House {

    @Inject
    public Stark() {

    }

    public void prepareForWar() {
        System.out.println(this.getClass().getSimpleName() + " prepared for war");
    }

    public void reportForWar() {
        System.out.println(this.getClass().getSimpleName() + " reporting..");
    }
}
