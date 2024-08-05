# java-wizard

```mermaid
classDiagram
    Wizard <|-- WizardFire
    Wizard <|-- WizardWater
    class Wizard{
        <<abstract>>
        -String name
        -int hp
        -int mp
        -String backStory
        #int maxHp
        #int maxMp
        #int normalAttackMpCost
        #int specialAttackMpCost
        +Wizard(String backStory, int mp)
        +getName() String
        +setName(String name) void
        +getHp() int
        +setHp(int hp) void
        +getMp() int
        +setMp(int mp) void
        +getBackStory() String
        +printBackstory() void
        #consumeMp(int mpCost) int
        +takeDamage(int damage) void
        +heal(Random random) int
        +attack(Random random, int targetHp) int
        +specialAbility(Random random, int enemyHp) int
        +attack1(Random random) int
        +attack2(Random random) int
        +attack3(Random random) int
    }
    class WizardWater{
        +WizardWater(String backStory, int mp)
        +attack1(Random random) int
        +attack2(Random random) int
        +attack3(Random random) int
        +specialAbility(Random random, int targetH)
    }
    class WizardFire{
        +WizardFire(String backStory, int mp)
        +attack1(Random random) int
        +attack2(Random random) int
        +attack3(Random random) int
        +specialAbility(Random random, int targetH)
    }

    Enemy <|-- DarkKnight
    Enemy <|-- PhantomMessenger
    Enemy <|-- DragonAvatar
    class Enemy{
        <<abstract>>
        -int hp
        -String name
        +Enemy(String name, int hp, int attackPower)
        +getName() String
        +getHp() int
        +takeDamage(int damage) void
        +attack(Random random, int targetHp) int
        #attack1(int targetHp) int
        #attack2(int targetHp) int
        #attack3(int targetHp) int
        #specialAbility(Wizard targetHp) int
    }
    class DarkKnight{
        +DarkKnight(String name, int hp, int attackPower)
        +attack1(int target) int
        +attack2(int target) int
        +attack3(int target) int
        +specialAbility(Wizard target) int
    }
    class PhantomMessenger{
        +PhantomMessenger(String name, int hp, int attackPower)
        +attack1(int target) int
        +attack2(int target) int
        +attack3(int target) int
        +specialAbility(Wizard target) int
    }
    class DragonAvatar{
    +DragonAvatar(String name, int hp, int attackPower)
        +attack1(int target) int
        +attack2(int target) int
        +attack3(int target) int
        +specialAbility(Wizard target) int
    }
 ```