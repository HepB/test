package ru.lyubimov.test.dagger;


import ru.lyubimov.test.dagger.di.BattleComponent;
import ru.lyubimov.test.dagger.di.BraavosModule;
import ru.lyubimov.test.dagger.di.DaggerBattleComponent;

public class BattleOfBastards {
    public static void main(String[] args) {
        Cash cash = new Cash();
        Soldiers soldiers = new Soldiers();
        BattleComponent component = DaggerBattleComponent.builder()
                .braavosModule(new BraavosModule(cash, soldiers))
                .build();
        War war = component.getWar();
        war.prepare();
        war.report();
        System.out.println(component.getCash());
        System.out.println(component.getSoldiers());
    }
}
