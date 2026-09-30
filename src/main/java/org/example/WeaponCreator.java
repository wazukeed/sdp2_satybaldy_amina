package org.example;

public abstract class WeaponCreator {

    public abstract Weapon createWeapon();

    public void fight() {
        Weapon weapon = createWeapon();

        System.out.println("Preparing for battle...");
        weapon.attack();
        System.out.println("Attack completed!");
    }
}