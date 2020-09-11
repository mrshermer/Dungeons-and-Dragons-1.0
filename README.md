# Dungeons-and-Dragons-1.0

This is my miniture version game of Dungeons and Dragons. This is a scaled down very simple version and a more dynamic complex version will be uploaded soon. 

Concept:

This is a 2 level Dungeons and Dragons game. The user has an option of going alone or going with another hero in the party. Each time the user surpasses a level, the monsters increase and the maze increases. The maze has a starting point where the user starts and a ending point denoted by 'F'. The user is presented a maze but the user doesn't know where the monsters are in the maze. To win the game the user must make it to the end of level 2 with or without defeating all the monsters. If the user dies, the game is over. 

OOP Principles:

The program displays all 4 concepts of Object Oriented Programming Principles. See below explanation 

Encapsulation: Within each of the classes, I make sure that any varibles declared within the class that those varibles are within the scope of which the class that they were declared in. Those varibles are not avaible outside of the class so to reduce the possibility that another class could possiblity access those varibles. 

Inheritance: Inheritance is used within the program, such as the Hero class or the Monster class. This decision was made as you can have many different types of Heros/Monsters but those Heros/Monsters is still considered as a Hero or a Monster in general. I believed that inheritance would be a good strategy such that the different types of Heros/Monsters will inherit the behaviors of the parent class for their base functionality.

Abstraction: Abstration is used within the Hero/Monster class. This was used to demonstrate only what the user needed to know about a Hero/Monster without exposing the underlying structure or complexity. 

Polymorphism: Polymorphism is used within the program, such as the Hero class. This was used to demonstrate that the Hero object can take on more than one form. 

Design Patterns:

The program also utilizes some design patterns. The following explantion below details what design patterns were used and how they were used:

Strategy Pattern: I did the strategy pattern for the abilites, as I noticed that the one part of my program that's changing consistently is the abilites. I decided that the strategy pattern would be a good fit.

Factory Pattern: I decided to use the factory pattern to identify what weapons each hero/monster would have. Rather than creating a long method with a tedious amount of if statements to determine who has what weapons. I dedicated that reponsibility to one class such that class was solely responsible for assigning the weapons to the hero/monsters.
