package org.example;

public class ShadowArmor implements Armor {

    @Override
    public void defend() {
        System.out.println("Shadow armor hides the character from attacks!");
    }
}
