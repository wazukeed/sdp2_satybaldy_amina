package org.example;

public class IceWeapon implements Weapon {

    @Override
    public void attack() {
        System.out.println("Ice weapon freezes the enemy!");
    }
}
