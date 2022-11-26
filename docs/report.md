## LDTS_GR04 - Frogger

The objective of this game is to move the frog through a path of static and moving obstacles, reaching the end of
the levels without dying with the highest score possible. 

The character is a frog that must cross a series of busy roads, rivers, train tracks and lava. He has 3 lives and every time he loses one, his position is reseted.

This game is based on a mix of two well-known games: Crossy Road and Frogger.

<img src="/docs/mockup.jpeg" width="500"> 

This project was developed by [Luís Jesus](https://github.com/lfsjesus) and [Miguel Rocha](https://github.com/r00cha).

### IMPLEMENTED FEATURES

- [X] **Menu Interface**: the application starts by showing a simple menu that is able to start the game.
  <br>
  <img src="/docs/menu.jpeg" width="300"> 
- [X] **Keyboard Control:** the keyboard inputs are received and an action is taken according the current state of the application. The used inputs are the Arrow keys and the letter 'q' to go back to the menu.
  <img src="/docs/frogger1.gif" width="300">
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

**GENERAL STRUCTURE**

- **Problem in Context.**  In order to easily add new features and test them, we needed to find a way to structure our code accordingly. Our game uses a GUI, so we thought that Model-Viewer-Controller(MVC) pattern would be a good choice.
- **The Pattern.** The Model-View-Controller pattern is an **Architectural** pattern in which the code is split up into three parts: the model, the controller and the view.
- **Implementation.**  The model is responsible for storing the data, the controller is responsible for mutating the model and controlling the logic of the game and the view is responsible for rendering the model on the screen.
- **Consequences.** Using this pattern allows us to easily introduce new features and enforces the **Single Responsibility Principle**. However, this pattern creates a class for each model, which leads to the creation of classes that can't do anything on their own.


**INTERACTING WITH LANTERNA**

- **Problem in Context.**  Because Lanterna is an external dependency where changes can be introduced at any time, we need a way to isolate calls to it. We also just need a small portion of Lanterna's API.
- **The Pattern.** The Facade Pattern immediately came to mind as it allows us to choose what functionalities we want to implement and if there's a change in Lanterna, we only need to update the way each method works. This way, we ensure that our code changes are minimal if any external method gets updated or redesigned.
- **Implementation.**  We implemented it using a GUI interface that is implemented by LanternaGUI class that handles all the things related to the graphic interface.
- **Consequences.** The use of this pattern makes the code easier to mantain and avoids duplicated code. It's also more clean as we just have the needed features from Lanterna.


**APPLICATION STATE**

- **Problem in Context.** It's important to know whether the application is on the menu or when the game is actually running, allowing, at the same time, other implementations (for example, if we want to add another entry to the menu, which whould imply a new state).
- **The Pattern.** The State Pattern uses polymorphism in order to solve this problem. Each state has a class and its logic (GameState, MenuState, etc). 
- **Implementation.** The Game has a state which is one of the two: MenuState or GameState. When the user starts the application, it is on the menu. If he selects the option to "Play", the state changes so the game starts running. If the user presses 'q' the state changes back to the menu, etc...
- **Consequences.** This pattern minimizes conditional complexity, eliminating the need for if and switch statements in objects with different behavior.

**RUNNING THE GAME**

- **Problem in Context.** It would be great if we had a way to run the game and make the actions on it proceed at the proper speed and time regardless of what the user is doing or how fast the computer is.
- **The Pattern.** The Game Loop pattern allows us to check for input and process it if available, update game objects and render the display, at each turn of the loop.
- **Implementation.** It is a loop used in the main class game that allows the game to run smoothly.
- **Consequences.** It allows the game to run smoothly regardless of a user's input, or lack thereof.

------

#### MOTION OF OBJECTS (vehicles, trunks, etc)

- **Problem in Context.** There are several kinds of objects that have the same behavior when it comes to their motion. Cars and other vehicles, trunks, etc move either to the left or right (very simple motion). There is no need to complicate and repeat code everywhere to make them move.
- **The Pattern.** To be decided when we implement more vehicles and movable objects in the game (maybe Command Pattern).
- **Implementation.** Not implemented yet.
- **Consequences.** ---

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

- There are several kinds of objects that have the same behavior when it comes to their motion. Cars and other vehicles, trunks, etc move either to the left or right (very simple motion). There is no need to complicate and repeat code everywhere to make them move.
- **A design pattern is yet being decided, because we will have more vehicles and movable objects in the game (maybe Command Pattern will be a good choice).

**Example of such a subsection**:

------
### TESTING

![](./docs/testcoverage.jpeg)
- [Mutation Testing]()

### SELF-EVALUATION


- Luís Jesus: 50%
- Miguel Rocha: 50%
