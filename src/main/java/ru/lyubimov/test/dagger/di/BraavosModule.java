package ru.lyubimov.test.dagger.di;

import dagger.Module;
import dagger.Provides;
import ru.lyubimov.test.dagger.Cash;
import ru.lyubimov.test.dagger.Soldiers;


@Module
public class BraavosModule {
    Cash cash;
    Soldiers soldiers;

    public BraavosModule(Cash cash, Soldiers soldiers) {
        this.cash = cash;
        this.soldiers = soldiers;
    }

    @Provides
    public Cash provideCash() {
        return cash;
    }

    @Provides
    public Soldiers provideSoldiers() {
        return soldiers;
    }
}
