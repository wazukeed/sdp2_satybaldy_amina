package org.example;

public class ShadowWeapon implements Weapon {

    @Override
    public void attack() {
        System.out.println("Shadow weapon attacks from darkness!");
    }
}