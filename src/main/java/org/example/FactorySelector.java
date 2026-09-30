package org.example;

public class FactorySelector {

    public static GameFactory selectFactory(int choice) {

        if (choice == 1) {
            return new FireFactory();
        } else if (choice == 2) {
            return new IceFactory();
        } else if (choice == 3) {
            return new ShadowFactory();
        } else if (choice == 4) {
            return new LightningFactory();
        } else {
            throw new IllegalArgumentException("Unknown character family");
        }
    }
}