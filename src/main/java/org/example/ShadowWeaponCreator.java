package org.example;

public class ShadowWeaponCreator extends WeaponCreator {

    @Override
    public Weapon createWeapon() {
        return new ShadowWeapon();
    }
}