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

        try {
            GameFactory factory = FactorySelector.selectFactory(choice);

            GameCharacter character = new GameCharacter(factory);

            character.fight();
            character.specialAttack();
            character.surviveBattle();

        } catch (IllegalArgumentException e) {
            System.out.println("Wrong choice");
        }
    }
}