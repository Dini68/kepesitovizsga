package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<MilitaryUnit> army = new ArrayList<>();


    public void addUnit(MilitaryUnit militaryUnit) {
        army.add(militaryUnit);
    }

    public int getArmySize() {
        return army.size();
    }

    public void damageAll(int damage) {
        List<MilitaryUnit> removeUnits = new ArrayList<>();
        for (MilitaryUnit m: army) {
            m.sufferDamage(damage);
            if (m.getHitPoints() < 25) {
                removeUnits.add(m);
            }
        }
        army.removeAll(removeUnits);
    }
    public int getArmyDamage() {
        int sumDamage = 0;
            for (MilitaryUnit m: army) {
                sumDamage += m.doDamage();
            }
        return sumDamage;
    }
}
