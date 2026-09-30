package org.example;

public class ShadowAbility implements Ability {

    @Override
    public void use() {
        System.out.println("Shadow ability makes the character invisible!");
    }
}