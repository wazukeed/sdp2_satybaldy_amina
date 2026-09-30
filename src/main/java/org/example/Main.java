package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose character family:");
        System.out.println("1 - Fire");
        System.out.println("2 - Ice");
        System.out.println("3 - Shadow");

        int choice = scanner.nextInt();

        Weapon weapon;
        Armor armor;
        Ability ability;

        if (choice == 1) {
            weapon = new Weapon("Fire");
            armor = new Armor("Fire");
            ability = new Ability("Fire");

        } else if (choice == 2) {
            weapon = new Weapon("Ice");
            armor = new Armor("Ice");
            ability = new Ability("Ice");

        } else if (choice == 3) {
            weapon = new Weapon("Shadow");
            armor = new Armor("Shadow");
            ability = new Ability("Shadow");

        } else {
            System.out.println("Wrong choice");
            return;
        }

        System.out.println("\nCharacter is ready!");

        weapon.attack();
        armor.defend();
        ability.use();
    }
}
