package ru.lyubimov.test.dagger;

import javax.inject.Inject;

public class War {
    private Stark stark;
    private Bolton bolton;

    @Inject
    public War(Stark stark, Bolton bolton) {
        this.stark = stark;
        this.bolton = bolton;
    }

    public void prepare() {
        stark.prepareForWar();
        bolton.prepareForWar();
    }

    public void report() {
        stark.reportForWar();
        bolton.reportForWar();
    }
}
