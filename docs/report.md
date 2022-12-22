## LDTS_GR04 - Frogger
[![BCH compliance](https://bettercodehub.com/edge/badge/lfsjesus/Frogger-Game-LDTS?branch=main)](https://bettercodehub.com/)

The objective of this game is to move the frog through a path of static and moving obstacles, reaching the end of
the levels without dying with the highest score possible. 

The character is a frog that must cross a series of busy roads, rivers, train tracks and lava. He has 3 lives and every time he loses one, his position is reseted.

This game is based on a mix of two well-known games: Crossy Road and Frogger.

#### Overall Game Design
<p align="center" justify="center">
  <img src="/docs/mockup.gif"/>
</p>
<p align="center">
  <b><i>Image 1. Game</i></b>
</p>
<br>
<br />

#### Game Menu
<p align="center" justify="center">
  <img src="/docs/menu.jpg"/>
</p>
<p align="center">
  <b><i>Image 2. Main Menu</i></b>
</p>
<br>
<br />

#### Leaderboard
<p align="center" justify="center">
  <img src="/docs/leaderboard.jpg"/>
</p>
<p align="center">
  <b><i>Image 3. Leaderboard</i></b>
</p>
<br>
<br/>

#### Game Over
<p align="center" justify="center">
  <img src="/docs/gameover.jpg"/>
</p>
<p align="center">
  <b><i>Image 4. Game Over Screen</i></b>
</p>
<br>
<br/>

#### Game Win
<p align="center" justify="center">
  <img src="/docs/gamewin.jpg"/>
</p>
<p align="center">
  <b><i>Image 5. Game Win Screen</i></b>
</p>
<br>
<br/>


This project was developed by [Luís Jesus](https://github.com/lfsjesus) and [Miguel Rocha](https://github.com/r00cha).

### IMPLEMENTED FEATURES

- [X] **Menu Interface**: the application starts by showing a simple menu that is able to start the game.
- [X] **Keyboard Control:** the keyboard inputs are received and an action is taken according the current state of the application. The used inputs are the Arrow keys and the letter 'q' to go back to the menu.
- [X] **Arena:** the arena and the elements are created at the beginning of the game while reading different files that describe each level, using different characters. Example: 'W' represents the water.
- [X] **Collisions**: collisions between the frog, cars, trains, vans, trucks, motorbikes, water, lava, limit walls, etc are detected.
- [X] **Lives**: the frog has 3 lives, which are shown on the screen represented by three hearts.
- [X] **Vehicle Movement:** there are different vehicles (cars, vans, motorbikes, trucks, trains, etc). They move at different velocities and can have different directions (right or left).
- [X] **Elements:** the elements are divided into two categories: movable and non-movable. Specific elements inherit properties from one of these two categories (parent classes).
- [X] **Levels:** there are different levels with different environments and elements (road, forest, river, lava, etc).
- [X] **Score:** the score increases along with the time and picking up coins increases it even more.
- [X] **Score Farming Prevention:** if the frog stays without moving for a certain amount of time, he loses a life and his position is reseted.
- [X] **Sound Effects:** there are some sound effects for the frog motion, collisions, winning, losing, etc.
- [x] **Leaderboard:** the game keeps track of the top 10 scores and shows them on the Leaderboard menu.
- [x] **Game Over:** the game ends when the frog loses all his lives and a specific screen is shown.
- [x] **Winning:** the game ends when the frog reaches the end of the last level and a specific screen is shown.
 
### DESIGN

***Nota:*** The diagrams that show the implementation of each design pattern are, of course, simplified. We are not showing all the dependencies and relationships between other classes nor all the attributes and methods of some classes because they are not relevant for the understanding of the design pattern implementation.

**GENERAL STRUCTURE**
<br>
![MVC](/docs/mvc.jpg)
- **Problem in Context.**  In order to easily add new features and test them, we needed to find a way to structure our code accordingly. Our game uses a GUI, so we thought that Model-Viewer-Controller(MVC) pattern would be a good choice.
- **The Pattern.** The Model-View-Controller pattern is an **Architectural** pattern in which the code is split up into three parts: the model, the controller and the view.
- **Implementation.**  The model is responsible for storing the data, the controller is responsible for mutating the model and controlling the logic of the game and the view is responsible for rendering the model on the screen.
- **Consequences.** Using this pattern allows us to easily introduce new features and enforces the **Single Responsibility Principle**. However, this pattern creates a class for each model, which leads to the creation of classes that can't do anything on their own.


**INTERACTING WITH LANTERNA**
<br>
![Facade](/docs/facade.jpg)
- **Problem in Context.**  Because Lanterna is an external dependency where changes can be introduced at any time, we need a way to isolate calls to it. We also just need a small portion of Lanterna's API.
- **The Pattern.** The Facade Pattern immediately came to mind as it allows us to choose what functionalities we want to implement and if there's a change in Lanterna, we only need to update the way each method works. This way, we ensure that our code changes are minimal if any external method gets updated or redesigned.
- **Implementation.**  We implemented it using a GUI interface that is implemented by LanternaGUI class that handles all the things related to the graphic interface.
- **Consequences.** The use of this pattern makes the code easier to maintain and avoids duplicated code. It's also more clean as we just have the needed features from Lanterna.


**APPLICATION STATE**
<br>
![State](/docs/state.jpg)
- **Problem in Context.** It's important to know whether the application is on the menu or when the game is actually running, allowing, at the same time, other implementations (for example, if we want to add another entry to the menu, which whould imply a new state).
- **The Pattern.** The State Pattern uses polymorphism in order to solve this problem. Each state has a class and its logic (GameState, MenuState, etc). 
- **Implementation.** The Game has a state which is one of these four: MenuState, GameState, GameFinishedState or LeaderboardState. When the user starts the application, it is on the menu. If he selects the option to "Play", the state changes so the game starts running. If the user presses 'q' the state changes back to the menu, etc...
- **Consequences.** This pattern minimizes conditional complexity, eliminating the need for if and switch statements in objects with different behavior.

**Nota**: In the diagram above, it is subtended that the subclasses override the methods in italic of the superclass.

**SOUND EFFECTS AND MUSIC MANAGING**
<br>
![Singleton](/docs/singleton.jpg)
- **Problem in Context.** There's a class (MusicManager) responsible for playing the background music and, simultaneously, other sounds. We have to make sure that there are not unwanted overlapping sounds that result from different instances of this class. At the same time, we want to have a single unit of control for the music and the sounds.
- **The Pattern.** The Singleton Pattern is a pattern that ensures that only one instance of a class is created and that there is a single point of access to it.
- **Implementation.** We implemented it using a static instance of the class that is initialized when the application starts. This instance is used to play the music and the sounds.
- **Consequences.** We are sure that there is only one instance of the class. It is harder to unit test, though, because test frameworks are usually based on inheritance when producing mocks, so we had to use Mockito-Inline instead of regular Mockito.

**TWO FUNDAMENTAL COMMANDS**
<br>
![Singleton](/docs/command.jpg)
- **Problem in Context.** Most of the MoveableElement objects have a simple movement, either left or right. This way, this movement must be independent of the object's class.
- **The Pattern.** The Command Pattern alows us to turn a request into a stand-alone object that contains all the information about the request. This way, a object is used to encapsulate all the information need to perform a desired action (in this case, MoveRight and MoveLeft classes).
- **Implementation.** We implemented it using a Command abstract class that is extended by MoveRight and MoveLeft classes. Each controller of a specific vehicle uses a parameter of type Command in its function that moves the vehicle.
- **Consequences.** Promotes the Single Responsibility Principle, as the command object encapsulates all the information needed to perform an action. It also makes it easier to add new commands, as we just need to create a new class that extends Command and implement the execute method. The code is also cleaner and easier to read.


**RUNNING THE GAME**
<br>
![GameLoop](/docs/gameloop.jpg)
- **Problem in Context.** It would be great if we had a way to run the game and make the actions on it proceed at the proper speed and time regardless of what the user is doing or how fast the computer is.
- **The Pattern.** The Game Loop pattern allows us to check for input and process it if available, update game objects and render the display, at each turn of the loop.
- **Implementation.** It is a loop used in the main class game that allows the game to run smoothly.
- **Consequences.** It allows the game to run smoothly regardless of a user's input, or lack thereof.

### BETTER CODE HUB
Analysis' result: 7/10

**Failed Guidelines**: 
- Separate Concerns in Modules: some classes have many incoming calls, however this is something we can't fully solve because most of the classes pointed by BetterCodeHub are general classes that have to be used by most of the other classes (for example, class Position).
- Keep Unit Interfaces Small: this refers to functions that have more than 2 parameters and it happens quite often but just in the controller (that requires) three parameters for the method "step". We don't consider this particularly serious because this guideline is just marked as failed because our game has many elements and, of course, many controller classes (we really need these 3 parameters in this method).
- Keep Architecture Components Balanced: this guideline is marked as failed because there are more lines in the controller package and in the class Arena (from the Model). Those are the only that really cause the greatest unbalancing, but they are very important in the game and we didn't see a better way to create more folders/packages as it is already very partitioned. 


------
### IMPLEMENTATION - UML

![UML](/docs/UML_Frogger.jpg)

------

### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

#### Large Class
The class Arena contains many methods and attributes when compared to other classes. Maybe we could have split it into smaller classes, but we couldn't find a way to do it without losing the cohesion of the class.

#### If/Else Statements
There are methods in some classes (Frog Controller, for example) that have a lot of if/else statements. We could have used polymorphism to solve it by creating different frogs with different directions (FrogNorth, FrogSouth, etc). The code is still readable, though.

#### Feature Envy
There are some methods in the class Arena that have a lot of calls to other classes. We tried to minimize as much as possible, but there are some cases where it's necessary because there are many interactions between the classes.

#### Static Variables
We have a static variable in the class Arena (points) and in the class Frog (lives). Managing the lives and the points was a bit tricky because we had to make sure that the values were updated in the right way. We tried to minimize the use of static variables. As we basically had just these two cases, it was not a big deal, but we recognize that it's not the best practice.

#### Train and Rock classes are not using Command as other movable objects
We could have not fixed some bugs in TrainController and RockController classes if we used Command because those classes had some specificities that made it difficult to use. Therefor, we decided to not use Command in those classes making it possible to fix the bugs.


------
### TESTING

![](/docs/testcoverage.jpg)
- [Mutation Testing](https://github.com/FEUP-LDTS-2022/project-l01gr04/blob/main/docs/Pitest/index.html): we excluded the classes Game, because it was not testable, and RandomArenaBuilder, that was not supposed to be tested (it was used to generate random arenas for Property Testing).
![Pitest](/docs/pitest.jpg)

### SELF-EVALUATION
All the work was divided equally between us and we were both working hard to deliver the best results possible.

- Luís Jesus: 50%
- Miguel Rocha: 50%
