package org.example;

public class FireWeapon implements Weapon {

    @Override
    public void attack() {
        System.out.println("Fire weapon burns the enemy!");
    }
}