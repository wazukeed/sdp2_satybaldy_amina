package org.example;

public interface GameFactory {

    Weapon createWeapon();

    Armor createArmor();

    Ability createAbility();
}