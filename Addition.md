Add a new view that allows users to see the images of all of the turtles (active or not). Clicking on an image should let the user change that turtle's image. If your team did not implement multiple turtles, then show the image of just the single turtle.

#### Estimation:
How long do you think it will take you to complete this new feature?
> 2 hours

How many files will you need to add or update? Why?
> Create one class, to contain the view with the images of the turtles. This class will contain an instance of the Canvas class, so it can access the turtles and update their images on click. I may have to modify Canvas.java if there are is not a getter for the turtles yet.

#### Review:
How long did it take you to complete this new feature?
> Holy moly, ended up taking me 4 hours.

How many files did you need to add or update? Why?
> Files I updated/refactored: Turtle.java, CanvasAnimation.java, GUIComboBoxImages.java, CanvasPen.java, CanvasMain.java, CanvasImageManager.java, CanvasRight.java, TabMainScreen.java

> Files I created: CanvasTurtleViewer.java, GUIComboBoxTurtleViewer.java

> I changed/created more files than I initially anticipated largely because GUICanvas.java (renamed and refactored to CanvasMain.java) was SO bad. I remember not understanding my partner's code during SLogo, and even though I refactored it a bit at the end of SLogo to cut down on line count (by a couple hundred lines), it was still very convoluted and incomprehensible. Also, in SLogo because of the way our canvas was set up, I realized I couldn't change the image of separate turtles- it had to be all together. So, I refactored GUICanvas and cleaned up its related classes, and I added the ability to change multiple turtle images OR change them all together. CanvasTurtleViewer is the main class I created with the list of the available turtles, and GUIComboBoxTurtleViewer was opened in a popup to set the image of the turtle.

Did you get it completely right on the first try?
> Ha good one, no

#### Analysis: what do you feel this exercise reveals about your project's design and documentation?

Was it as good (or bad) as you remembered?
> I definitely remember that GUICanvas.java had a lot of design problems, but David didn't do much to fix it at the time, and I didn't have time to completely refactor the class. But after trying to add an extension, I am realizing just how smelly some of that code was. Also, his comments and method names were not distinguishable or descriptive enough at all to understand the methods he wrote.

What could be improved?
> Better comments, more time spent refactoring rather than just focusing on functionality/features before code submission.

What would it have been like if you were not familiar with the code at all?
> Dear Lord, the front-end extension would have taken me several hours longer. Even my teammates for SLogo that worked on the backend but kind of had a grasp on the front-end came to me asking for clarification about this specific class and I didn't know what to tell them (I told them to ask David since he was the author, but I don't think he was available).
