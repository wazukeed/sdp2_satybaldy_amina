package org.example;

public class FireWeaponCreator extends WeaponCreator {

    @Override
    public Weapon createWeapon() {
        return new FireWeapon();
    }
}