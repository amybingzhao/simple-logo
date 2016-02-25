####API Review, akt16

Part One:
>What about your API/design is intended to be flexible?

>> A: Our API/design Factory design pattern allows for flexible creation of nodes in the GUI. The Factory class encapsulates the instantiation and behavior of each node, and the only thing that needs to be passed in is a String indicating what kind of Node it is (which is kept track of using a resources folder).

>How is your API/design encapsulating your implementation decisions?

>> A: The only public methods available (ex: updateNode(), createNode(), etc.) hide how each task is completed. The user has to pass as few parameters as possible in each API method. We have an object factory class that creates nodes for the scene + their implementations based on a single string, which indicates the node type.

>What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?

>> A: Invalid input for background color, pen color, image file for the turtle, invalid syntax taken in from command line. To handle the color and file input, we have error messages that will be printed on the GUI using a Labeled class, based on what kind of error it is. For invalid syntax, the backend will throw the error and the front end will catch it. We have a part of the GUI dedicated printing out command line exception handling.

>Why do you think your API/design is good (also define what your measure of good is)?

>> A: Our API is good because it is concise. We try to limit the available methods that can be accessed (are public) and have them perform useful functions, rather than just spitting out information.

Part Two:
>Demo what you currently have running (it could be anything, but it should definitely be something).

>Come up with at least four use cases for your part (it is absolutely fine if they are useful for both teams).
>> Case 1: User types in a math command and the result is displayed in the output.
>>> The command String is taken in by the VBox node, and it is passed to the backend using parseCommand(String command);. The backend interprets the string and calls notifyAllObservers() in the Observer class to update state of the GUI and print out the result in the console using Labeled.

>> Case 2: User wants to draw a square, Turtle moves on screen.
>>> The command String is taken in by the VBox node, and it is passed to the backend using parseCommand(String command);. The backend interprets the string and set a boolean value penDown to true. They the backend calls notifyAllObservers() in the Observer class to update state of the GUI and move the turtle on the screen.

>> Case 3: User wants to set background color.
>>> The color String is taken in by the VBox node. On button click to set the color, the front end performs error checking to make sure the string is a valid color. If it is not, it will print out corresponding error messages. If it is valid, the frontend will convert the color String to a JavaFX Color object and set the background of the turtle Canvas to that color. When notifyAllObservers() is called again, the canvas will change color.

>> Case 4: User defines own command.
>>> The String is taken in by the VBox node, passed to the backend to parse (parseCommand(String command)), and once it recognizes that it is a user defined command, it will save the command to a memory structure. When notifyAllObservers() is called again, the ComboBox containing the history of user defined commands is updated to include that command.


>What feature/design problem are you most excited to work on?
>> A: Exception handling in the front end, because I worked on that in the last project.

>What feature/design problem are you most worried about working on?
>> A: Updating Turtle movement (and all other GUI nodes that need to be updated) using Observables, because I'm not sure how to use the Observer pattern yet.
