package org.example;

public class IceWeaponCreator extends WeaponCreator {

    @Override
    public Weapon createWeapon() {
        return new IceWeapon();
    }
}