# java-wizard

```mermaid
classDiagram
    Wizard <|-- WizardFire
    Wizard <|-- WizardWater
    Wizard : +String name
    Wizard: +run()
    Wizard: +heal()
    class WizardFire{
        +attack()
    }
    class WizardWater{
        +attack()
    }
    class Slime{
        +int hp
        +slimeAttack()
    }
 ```