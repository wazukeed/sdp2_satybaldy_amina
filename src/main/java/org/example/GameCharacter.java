package org.example;

public class GameCharacter {

    private final Weapon weapon;
    private final Armor armor;
    private final Ability ability;

    public GameCharacter(GameFactory factory) {
        if (factory == null) {
            throw new IllegalArgumentException("Factory cannot be null");
        }

        weapon = factory.createWeapon();
        armor = factory.createArmor();
        ability = factory.createAbility();
    }

    public void fight() {
        System.out.println("\n--- FIGHT ---");
        armor.defend();
        weapon.attack();
    }

    public void specialAttack() {
        System.out.println("\n--- SPECIAL ATTACK ---");
        ability.use();
        weapon.attack();
    }

    public void surviveBattle() {
        System.out.println("\n--- SURVIVE BATTLE ---");
        armor.defend();
        ability.use();
    }
}