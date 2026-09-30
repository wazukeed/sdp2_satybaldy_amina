package org.example;

public class Weapon {
    private String type;

    public Weapon(String type) {
        this.type = type;
    }

    public void attack() {
        System.out.println(type + " weapon attacks the enemy");
    }
}
