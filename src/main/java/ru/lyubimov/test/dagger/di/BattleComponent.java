package ru.lyubimov.test.dagger.di;

import dagger.Component;
import ru.lyubimov.test.dagger.Cash;
import ru.lyubimov.test.dagger.Soldiers;
import ru.lyubimov.test.dagger.War;


@Component(modules = BraavosModule.class)
public interface BattleComponent {
    War getWar();
    Cash getCash();
    Soldiers getSoldiers();
}
