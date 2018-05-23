package ru.lyubimov.test.dagger;

import javax.inject.Inject;

public class Bolton implements House {

    @Inject
    public Bolton() {

    }

    public void prepareForWar() {
        System.out.println(this.getClass().getSimpleName() + " prepared for war");
    }

    public void reportForWar() {
        System.out.println(this.getClass().getSimpleName() + " reporting..");
    }
}
