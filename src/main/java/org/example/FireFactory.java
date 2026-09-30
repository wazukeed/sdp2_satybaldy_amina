package org.example;

public class FireFactory implements GameFactory {

    @Override
    public Weapon createWeapon() {
        return new FireWeapon();
    }

    @Override
    public Armor createArmor() {
        return new FireArmor();
    }

    @Override
    public Ability createAbility() {
        return new FireAbility();
    }
}