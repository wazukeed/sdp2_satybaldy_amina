package org.example;

public class Ability {
    private String type;

    public Ability(String type) {
        this.type = type;
    }

    public void use() {
        System.out.println(type + " ability is used");
    }
}