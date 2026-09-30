package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose weapon:");
        System.out.println("1 - Fire");
        System.out.println("2 - Ice");
        System.out.println("3 - Shadow");

        int choice = scanner.nextInt();

        WeaponCreator creator;

        if (choice == 1) {
            creator = new FireWeaponCreator();
        } else if (choice == 2) {
            creator = new IceWeaponCreator();
        } else if (choice == 3) {
            creator = new ShadowWeaponCreator();
        } else {
            System.out.println("Wrong choice");
            return;
        }

        creator.fight();
    }
}