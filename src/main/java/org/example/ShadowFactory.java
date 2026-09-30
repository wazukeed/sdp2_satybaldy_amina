package org.example;

public class ShadowFactory implements GameFactory {

    @Override
    public Weapon createWeapon() {
        return new ShadowWeapon();
    }

    @Override
    public Armor createArmor() {
        return new ShadowArmor();
    }

    @Override
    public Ability createAbility() {
        return new ShadowAbility();
    }
}