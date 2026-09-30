package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {

    // 1
    @Test
    void fireFactoryCreatesFireProducts() {
        GameFactory factory = new FireFactory();

        assertInstanceOf(FireWeapon.class, factory.createWeapon());
        assertInstanceOf(FireArmor.class, factory.createArmor());
        assertInstanceOf(FireAbility.class, factory.createAbility());
    }

    // 2
    @Test
    void iceFactoryCreatesIceProducts() {
        GameFactory factory = new IceFactory();

        assertInstanceOf(IceWeapon.class, factory.createWeapon());
        assertInstanceOf(IceArmor.class, factory.createArmor());
        assertInstanceOf(IceAbility.class, factory.createAbility());
    }

    // 3
    @Test
    void shadowFactoryCreatesShadowProducts() {
        GameFactory factory = new ShadowFactory();

        assertInstanceOf(ShadowWeapon.class, factory.createWeapon());
        assertInstanceOf(ShadowArmor.class, factory.createArmor());
        assertInstanceOf(ShadowAbility.class, factory.createAbility());
    }

    // 4
    @Test
    void lightningFactoryCreatesLightningProducts() {
        GameFactory factory = new LightningFactory();

        assertInstanceOf(LightningWeapon.class, factory.createWeapon());
        assertInstanceOf(LightningArmor.class, factory.createArmor());
        assertInstanceOf(LightningAbility.class, factory.createAbility());
    }

    // 5
    @Test
    void fireFactoryProductsAreCompatible() {
        GameFactory factory = new FireFactory();

        assertTrue(factory.createWeapon() instanceof FireWeapon);
        assertTrue(factory.createArmor() instanceof FireArmor);
        assertTrue(factory.createAbility() instanceof FireAbility);
    }

    // 6
    @Test
    void iceFactoryProductsAreCompatible() {
        GameFactory factory = new IceFactory();

        assertTrue(factory.createWeapon() instanceof IceWeapon);
        assertTrue(factory.createArmor() instanceof IceArmor);
        assertTrue(factory.createAbility() instanceof IceAbility);
    }

    // 7
    @Test
    void selectorReturnsFireFactory() {
        GameFactory factory = FactorySelector.selectFactory(1);

        assertInstanceOf(FireFactory.class, factory);
    }

    // 8
    @Test
    void selectorReturnsIceFactory() {
        GameFactory factory = FactorySelector.selectFactory(2);

        assertInstanceOf(IceFactory.class, factory);
    }

    // 9
    @Test
    void selectorReturnsShadowFactory() {
        GameFactory factory = FactorySelector.selectFactory(3);

        assertInstanceOf(ShadowFactory.class, factory);
    }

    // 10
    @Test
    void selectorReturnsLightningFactory() {
        GameFactory factory = FactorySelector.selectFactory(4);

        assertInstanceOf(LightningFactory.class, factory);
    }

    // 11 - negative scenario
    @Test
    void selectorRejectsInvalidHighNumber() {
        assertThrows(
                IllegalArgumentException.class,
                () -> FactorySelector.selectFactory(10)
        );
    }

    // 12 - negative scenario
    @Test
    void selectorRejectsInvalidLowNumber() {
        assertThrows(
                IllegalArgumentException.class,
                () -> FactorySelector.selectFactory(0)
        );
    }

    // 13 - business behavior
    @Test
    void characterCanFight() {
        GameFactory factory = new FireFactory();
        GameCharacter character = new GameCharacter(factory);

        assertDoesNotThrow(character::fight);
    }

    // 14 - business behavior
    @Test
    void characterCanUseSpecialAttack() {
        GameFactory factory = new IceFactory();
        GameCharacter character = new GameCharacter(factory);

        assertDoesNotThrow(character::specialAttack);
    }

    // 15 - business behavior
    @Test
    void characterCanSurviveBattle() {
        GameFactory factory = new ShadowFactory();
        GameCharacter character = new GameCharacter(factory);

        assertDoesNotThrow(character::surviveBattle);
    }

    // 16 - Client works through abstraction
    @Test
    void characterWorksWithAbstractFactory() {
        GameFactory factory = FactorySelector.selectFactory(4);

        GameCharacter character = new GameCharacter(factory);

        assertDoesNotThrow(character::fight);
        assertDoesNotThrow(character::specialAttack);
        assertDoesNotThrow(character::surviveBattle);
    }

    @Test
    void characterRejectsNullFactory() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new GameCharacter(null)
        );
    }
}