package org.example;

public class Armor {
    private String type;

    public Armor(String type) {
        this.type = type;
    }

    public void defend() {
        System.out.println(type + " armor protects the character");
    }
}
