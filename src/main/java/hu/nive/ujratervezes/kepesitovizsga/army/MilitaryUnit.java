package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {

    private int damage;
    private int hitPoints;
    private boolean armor;
    private int numberDoDamage = 0;
    private int numberDoDamageSwordsman = 0;
    private boolean hasArmor = true;

    public MilitaryUnit(int damage, int hitPoints, boolean armor) {
        this.damage = damage;
        this.hitPoints = hitPoints;
        this.armor = armor;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int doDamage() {
        if (this instanceof HeavyCavalry && numberDoDamage == 0) {
            numberDoDamage ++;
            return damage * 3;
        }
        return damage;
    }

    public void sufferDamage(int damage) {
        if (this instanceof Swordsman && hasArmor) {
            hasArmor = false;
            return;
        }
        if (armor) {
            hitPoints -= damage / 2;
        }
        if (!armor) {
            hitPoints -= damage;
        }
    }

}
