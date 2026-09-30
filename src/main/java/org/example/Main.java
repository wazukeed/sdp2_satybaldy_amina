package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose character family:");
        System.out.println("1 - Fire");
        System.out.println("2 - Ice");
        System.out.println("3 - Shadow");
        System.out.println("4 - Lightning");

        int choice = scanner.nextInt();

        GameFactory factory;

        if (choice == 1) {
            factory = new FireFactory();
        } else if (choice == 2) {
            factory = new IceFactory();
        } else if (choice == 3) {
            factory = new ShadowFactory();
        } else if (choice == 4) {
            factory = new LightningFactory();
        } else {
            System.out.println("Wrong choice");
            return;
        }

        GameCharacter character = new GameCharacter(factory);

        character.fight();
        character.specialAttack();
        character.surviveBattle();
    }
}