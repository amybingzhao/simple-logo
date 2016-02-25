# Team 16: API Exercise

Names: Blake Kaplan, Amy Zhao, David Yang, Annie Tang

## Overall Plan

1. When does parsing need to take place and what does it need to start properly?

  * Parsing will take place on the back end
  * It will require an input of commands
  * Proper formatting
  * Understanding of each commands and its arguments

2. What is the result of parsing and who receives it?

  * The result is a command and its arguments
  * Another section of the back end will focus on taking the parsed output and applying it as an executable action

3. When are errors detected and how are they reported?

  * Errors will be detected on the back end
  * They will be reported as dialogs on the front end
  * This will require an API interaction

4. What do commands know, when do they know it, and how do they get it?

  * Commands will have to know their arguments and the program's current state (held in the model)
  * Commands will know their arguments after parsing
  * They will retrieve state from the model

5. How is the GUI updated after a command has completed execution?

  * All changes will happen to the model
  * The view will be able to interact with the model to reflect the changes

## APIs

### API 1: Sending the Typed Command to Parser:

The parser class will interpret string commands.

  ```java

public class SLogoController(){

  //Obtains a list of previously run commands
  public List<String> getCommandsPreviouslyRun();

  //Obtains a list of previous used variables
  public List<String> getCurrentVariables();

  //Prints out all available commands that can be used
  public List<String> getUserCommands();

  //Sets the input language
  public void setTranslationLanguage(String language);

}

public class CommandParser(){

  //Parses a string command
  public void parse(String command);

}
  ```

### API 2: Parser to Executable (Interior API):

  Sending parsed information from the parser to be executed

  We will use command objects that apply commands to the turtle. They will all be subclasses of the Command abstract class below:

  ```java

  public abstract class Command(){

    //Causes appropriate command response
    public abstract void handle(Turtle myTurtle);

  }

  public class Forward extends Command{

    //Action parameters go into the constructor
    public Forward(int distance);

    //Carries out actual change to Model
    public void handle(Turtle myTurtle);

  }

  public class Turtle{

    //Lifts the Turtle's pen so that it does not draw
    public void penUp();

    //Puts the Turtle's pen down so that it does draw
    public void penDown();

  }

  ```

### API 3: Executables Cause Change to Front End Element

  Commands sent in executable form to front end
  ```java

public interface GUI(){

    //Returns the width of the screen
    public int getWidth();

    //Returns the height of the screen
    public int getHeight();

    //Makes object specific UI change
    public void update();

    //Displays an error notification
    public void displayError(String error);

  }

  ```

### API 4: UI Element Interaction

  Something within front end

  ```java
 public interface GUIElement {

   //Put the element onto the display
   public void displayElement(Stage s);

 }
 public class CommandLine implements GUIElement{

   //Puts the element onto the display
   public void displayElement(Stage s);

   //Reads in the command
   public String readCommand();

 }
 public class ColorSetter implements GUIElement{

   //Puts the element on the display
   public void displayElement(Stage s);

   //Sets the background color
   public String setBackgroundColors();

 }
 public class DisplayBox implements GUIElement{

   //Puts the element on the display
   public void displayElement(Stage s);

   //Displays errors
   public void displayErrors();

 }
  ```

## Use Cases:

1. **The user types 'fd 50' in the command window, sees the turtle move in the display window leaving a trail, and has the command added to the environment's history.**

  When a command is provided, a string version of the command is sent to the SLogoController. This controller add the command to the list of previously executed commands. It then sends the command on to the CommandParser. The CommandParser creates an instance of the appropriate Command subclass for the action. It passes all the appropriate arguments into the constructor. The handle method actually performs the Turtle movement, which will cause the turtle to move and draw a path.

2. **The user types '50 fd' in the command window and sees an error message that the command was not formatted correctly.**

  When the Controller sends the command to the parser, the parser will catch the error and send it to the GUI via the `displayError` method.

3. **The user types 'pu fd 50 pd fd 50' in the command window and sees the turtle move twice (once without a trail and once with a trail).**

  The Command subclass for forward would have a boolean argument specifying whether or not the pen is down. When the action is executed, there will be a different behavior for when it is up or down.

4. **The user changes the color of the environment's background.**

  This will be performed via a button on the GUI. It will change an attribute for the windows background.
