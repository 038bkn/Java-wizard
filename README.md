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
        #specialAttackMpCost
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
    class WizardFire{
        +attack()
    }
    class WizardWater{
        +attack()
    }

    Enemy <|-- DarkKnight
    Enemy <|-- PhantomMessenger
    Enemy <|-- DragonAvatar
    class Enemy{
        <<abstract>>
        +int hp
        +int attackPower
        +attack()
        +specialAbility()void
    }
    class DarkKnight{
        +attack() void
        +specialAbility()void
    }
    class PhantomMessenger{
        +attack() void
        +specialAbility()void
    }
    class DragonAvatar{
        +attack() void
        +specialAbility()void
    }
 ```