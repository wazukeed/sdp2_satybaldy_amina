package org.example;

public class IceFactory implements GameFactory {

    @Override
    public Weapon createWeapon() {
        return new IceWeapon();
    }

    @Override
    public Armor createArmor() {
        return new IceArmor();
    }

    @Override
    public Ability createAbility() {
        return new IceAbility();
    }
}