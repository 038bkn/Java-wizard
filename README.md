# java-wizard

```mermaid
classDiagram
    Wizard <|-- WizardFire
    Wizard <|-- WizardWater
    class Wizard{
        <<abstract>>
        +String name
        +int hp
        +int mp
        +heal()
        +tingle()
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