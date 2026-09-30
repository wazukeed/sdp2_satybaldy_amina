# Assignment 2 - Factory Method & Abstract Factory

## Game Character System

This project demonstrates the use of the Factory Method and Abstract Factory design patterns in a Game Character System.

The system contains three main product types:

- Weapon
- Armor
- Ability

The original product families are:

- Fire
- Ice
- Shadow

Later, a fourth family, Lightning, was added to demonstrate system extensibility.

---

## Part A - Initial Design Without Factories

The first version of the application created objects directly inside the client using `new`.

For example:

```java
weapon = new Weapon("Fire");
armor = new Armor("Fire");
ability = new Ability("Fire");
```

This approach created several design problems:

1. The client depended directly on object creation.
2. A large `if/else` structure was required.
3. Adding a new family required modification of existing client code.
4. Object creation logic was mixed with application logic.
5. Products from different families could potentially be combined incorrectly.

The initial implementation is preserved in the Git history.

---

## Factory Method

Factory Method is used for weapon creation.

### Product

`Weapon`

### Concrete Products

- `FireWeapon`
- `IceWeapon`
- `ShadowWeapon`

### Creator

`WeaponCreator`

### Concrete Creators

- `FireWeaponCreator`
- `IceWeaponCreator`
- `ShadowWeaponCreator`

`WeaponCreator` defines the Factory Method:

```java
public abstract Weapon createWeapon();
```

It also contains the business method `fight()`.

The concrete creators override `createWeapon()` and decide which concrete Weapon should be created.

For example, `FireWeaponCreator` creates a `FireWeapon`, while `IceWeaponCreator` creates an `IceWeapon`.

This separates object creation from the business logic that uses the object.

---

## Abstract Factory

`GameFactory` is the Abstract Factory of the application.

It defines three creation methods:

```java
Weapon createWeapon();
Armor createArmor();
Ability createAbility();
```

The concrete factories are:

- `FireFactory`
- `IceFactory`
- `ShadowFactory`
- `LightningFactory`

Each concrete factory creates a complete family of related products.

For example, `FireFactory` creates:

- `FireWeapon`
- `FireArmor`
- `FireAbility`

`IceFactory` creates:

- `IceWeapon`
- `IceArmor`
- `IceAbility`

`ShadowFactory` creates:

- `ShadowWeapon`
- `ShadowArmor`
- `ShadowAbility`

---

## Product Compatibility

Products belonging to the same family are created through one `GameFactory`.

For example:

```text
FireFactory
    -> FireWeapon
    -> FireArmor
    -> FireAbility
```

`GameCharacter` receives one `GameFactory`.

The character then asks that same factory to create its Weapon, Armor, and Ability.

Because all three products come from the same concrete factory, the normal client workflow keeps the product family consistent.

For example:

```text
FireWeapon + FireArmor + FireAbility
```

instead of an incorrect combination such as:

```text
FireWeapon + IceArmor + ShadowAbility
```

The architecture therefore reduces the possibility of incompatible product combinations without using manual family checks inside the business logic.

---

## Runtime Factory Selection

The product family can be selected while the program is running.

The `FactorySelector` class selects the appropriate `GameFactory` according to the user's choice.

```text
1 -> FireFactory
2 -> IceFactory
3 -> ShadowFactory
4 -> LightningFactory
```

For example:

```java
GameFactory factory = FactorySelector.selectFactory(choice);
```

After the factory is selected, the main business logic does not need to know which concrete family is being used.

`GameCharacter` works through the abstractions:

- `GameFactory`
- `Weapon`
- `Armor`
- `Ability`

---

## Business Operations

The `GameCharacter` class contains three business operations involving multiple products.

### fight()

Uses:

- Armor
- Weapon

The armor protects the character and the weapon performs an attack.

### specialAttack()

Uses:

- Ability
- Weapon

The character uses its special ability and then attacks with its weapon.

### surviveBattle()

Uses:

- Armor
- Ability

The armor protects the character while the ability helps during the battle.

These operations demonstrate collaboration between products from the same product family.

---

## Adding a Fourth Product Family

After the original Fire, Ice, and Shadow families were completed, a fourth family called Lightning was added.

The following files were added:

- `LightningWeapon.java`
- `LightningArmor.java`
- `LightningAbility.java`
- `LightningFactory.java`

Runtime factory selection was also extended so that the user can select the Lightning family.

The existing business operations in `GameCharacter` did not need to be rewritten.

The methods:

```text
fight()
specialAttack()
surviveBattle()
```

continue to work with the new Lightning family because they depend on the `Weapon`, `Armor`, and `Ability` abstractions rather than concrete Lightning classes.

This demonstrates that the system can be extended with a new product family with minimal changes to existing business logic.

---

## Automated Testing

The project contains more than 15 automated tests using JUnit.

The tests cover:

- creation of the original Fire family;
- creation of the original Ice family;
- creation of the original Shadow family;
- creation of the new Lightning family;
- correct concrete product creation;
- product-family compatibility;
- runtime factory selection;
- business behavior;
- invalid factory selections;
- null factory handling;
- use of abstractions by the client.

The tests verify both object creation and application behavior.

---

## UML Diagram

The project contains the file:

```text
uml.puml
```

The UML class diagram shows:

- Product interfaces;
- Concrete Products;
- Creator;
- Concrete Creators;
- Abstract Factory;
- Concrete Factories;
- Client;
- relationships between classes.

The diagram also identifies the Factory Method and Abstract Factory parts of the architecture.

---

## Factory Method vs Abstract Factory

### Factory Method

Factory Method is used when a creator delegates the creation of one type of product to its subclasses.

In this project:

```text
WeaponCreator
        |
        +-- FireWeaponCreator
        +-- IceWeaponCreator
        +-- ShadowWeaponCreator
```

Each concrete creator decides which `Weapon` implementation should be created.

### Abstract Factory

Abstract Factory is used to create complete families of related products.

In this project:

```text
GameFactory
      |
      +-- FireFactory
      +-- IceFactory
      +-- ShadowFactory
      +-- LightningFactory
```

Each concrete factory creates:

```text
Weapon + Armor + Ability
```

from the same family.

Therefore, Factory Method handles one level of product creation, while Abstract Factory manages complete compatible product families.

---

## Project Structure

```text
src/main/java/org/example

Weapon
FireWeapon
IceWeapon
ShadowWeapon
LightningWeapon

Armor
FireArmor
IceArmor
ShadowArmor
LightningArmor

Ability
FireAbility
IceAbility
ShadowAbility
LightningAbility

WeaponCreator
FireWeaponCreator
IceWeaponCreator
ShadowWeaponCreator

GameFactory
FireFactory
IceFactory
ShadowFactory
LightningFactory

FactorySelector
GameCharacter
Main
```

Tests are located in:

```text
src/test/java/org/example
```

---

## Conclusion

The project demonstrates how Factory Method and Abstract Factory can solve object creation problems in an extensible application.

Factory Method separates weapon creation from the logic that uses weapons.

Abstract Factory creates compatible families of Weapon, Armor, and Ability objects.

The architecture allows a new family such as Lightning to be added without rewriting the existing business logic.