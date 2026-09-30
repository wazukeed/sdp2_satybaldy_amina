package org.example;

public class LightningWeapon implements Weapon {

    @Override
    public void attack() {
        System.out.println("Lightning weapon shocks the enemy!");
    }
}