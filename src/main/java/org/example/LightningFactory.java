package org.example;

public class LightningFactory implements GameFactory {

    @Override
    public Weapon createWeapon() {
        return new LightningWeapon();
    }

    @Override
    public Armor createArmor() {
        return new LightningArmor();
    }

    @Override
    public Ability createAbility() {
        return new LightningAbility();
    }
}
