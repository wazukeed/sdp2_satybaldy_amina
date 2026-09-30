package org.example;

public class GameCharacter {

    private final Weapon weapon;
    private final Armor armor;
    private final Ability ability;

    public GameCharacter(GameFactory factory) {
        weapon = factory.createWeapon();
        armor = factory.createArmor();
        ability = factory.createAbility();
    }

    // Business operation 1
    public void fight() {
        System.out.println("\n--- FIGHT ---");
        armor.defend();
        weapon.attack();
    }

    // Business operation 2
    public void specialAttack() {
        System.out.println("\n--- SPECIAL ATTACK ---");
        ability.use();
        weapon.attack();
    }

    // Business operation 3
    public void surviveBattle() {
        System.out.println("\n--- SURVIVE BATTLE ---");
        armor.defend();
        ability.use();
    }
}