## LDTS_GR04 - Frogger

The objective of this game is to move the frog through a path of static and moving obstacles, reaching the end of
the levels without dying with the highest score possible. 

The character is a frog that must cross a series of busy roads, rivers, train tracks and lava. He has 3 lives and every time he loses one, his position is reseted.

This game is based on a mix of two well-known games: Crossy Road and Frogger.

This project was developed by [Luís Jesus](https://github.com/lfsjesus) and [Miguel Rocha](https://github.com/r00cha).

### IMPLEMENTED FEATURES

- [X] **Menu Interface**: the application starts by showing a simple menu that is able to start the game.
- [X] **Keyboard Control:** the keyboard inputs are received and an action is taken according the current state of the application. The used inputs are the Arrow keys and the letter 'q' to go back to the menu. 
- [X] **Arena:** the arena and the elements are created at the beginning of the game while reading different files that describe each level, using different characters. Example: 'F' represents the frog.
- [X] **Collisions**: collisions between the frog, the cars and the limit walls are detected.
- [X] **Lives**: the frog has 3 lives, which are shown on the screen represented by three hearts.
- [X] **Vehicle Movement:** so far, there's only one type of car and they move at the same speed in the same direction.

### PLANNED FEATURES

- [ ] **Elements:** the elements are divided into two types: movable and non-movable. Specific elements inherit properties from one of these two parent classes.
- [ ] **Collisions:** collisions between the remaining entities (trunks, trees, etc) have to be implemented.
- [ ] **Levels:** different levels with different environments (road, forest, river, lava, etc).
- [ ] **Score:** the score will increase along with the time and picking up coins increases it even more. 
- [ ] **Score Farming Prevention:** if the frog stays in the same position for a long time, it loses a life, in order to prevent unfair high scores.
- [ ] **Vehicle Movement**: different types of vehicles (trains, trucks, etc) will move at different speeds both to the left and right.
- [ ] **Sound Effects**: background music and crashing/collisions/etc sounds.
 
### DESIGN

**General Structure**

- **Problem in Context.**  In order to easily add new features and test them, we needed to find a way to structure our code accordingly. Since our application also uses a GUI, we taught that the MVC (Model-View-Controller) pattern would be a great choice.
- **The Pattern.** The Model-View-Controller pattern is an **Architectural** pattern in which the code is split up into three parts: the model, the controller and the view.
- **Implementation.**  The model is responsible for storing the data, the controller is responsible for mutating the model and controlling the logic of the game and the view is responsible for rendering the model on the screen.
- **Consequences.** Using this pattern allows us to easily introduce new features and enforces the **Single Responsibility Principle**. However, this pattern creates a class for each model, which leads to the creation of classes that can't do anything on their own.

------

- **Problem in Context.**  In order to easily add new features and test them, we needed to find a way to structure our code accordingly. Since our application also uses a GUI, we taught that the MVC (Model-View-Controller) pattern would be a great choice.
- **The Pattern.** The Model-View-Controller pattern is an **Architectural** pattern in which the code is split up into three parts: the model, the controller and the view.
- **Implementation.**  The model is responsible for storing the data, the controller is responsible for mutating the model and controlling the logic of the game and the view is responsible for rendering the model on the screen.
- **Consequences.** Using this pattern allows us to easily introduce new features and enforces the **Single Responsibility Principle**. However, this pattern creates a class for each model, which leads to the creation of classes that can't do anything on their own.

------

#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.

**Example of such a subsection**:

------

#### DATA CLASS

The `PlatformSegment` class is a **Data Class**, as it contains only fields, and no behavior. This is problematic because […].

A way to improve the code would be to move the `isPlatformSegmentSolid()` method to the `PlatformSegment` class, as this logic is purely concerned with the `PlatformSegment` class.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%