David Yang

SLogo Addition


* Estimation: before looking at the old code:
	* How long do you think it will take you to complete this new feature?
		* I think that it will take me about 3 hours to implement this new feature.
	* How many files will you need to add or update? Why?
		* I will likely have to add one class and update three class. I need to add the new class for the new view, and I will need to change one class so that I can update the images of the turtles. Since we used a factory design pattern for this project, I will also have to update the factory class and the TabMainScreen class that uses the factory to create all of the individual elements.

* Review: after completing the feature:
	* How long did it take you to complete this new feature?
		* This feature took me about 2 hours to implement.
	* How many files did you need to add or update? Why?
		* I had to update or add 8 classes. In addition to the classes that I knew I was going to have to update, I also had to change two classes because they interfered with updating the turtles one at a time. Our turtle imageviews were being all changed at the same time, so I had to change a couple of classes to allow the turtles to be changed one at a time. Another class was changed in order to fit the new view into the front end GUI, and the last class was added because I decided to use a ListView JavaFX component, and I created a class that implemented ListCell. 
	* Did you get it completely right on the first try?
		* I did not get it completely right on the first try. It took me many tries and a decent amount of debugging to fully implement the feature.

* Analysis: what do you feel this exercise reveals about your project's design and documentation?
	* Was it as good (or bad) as you remembered?
		* The code was not quite as good as I remembered. Adding the new class and placing it onto the GUI was as simple as I remembered, but getting it work properly was challenging. The problem with changing the turtle images one at a time turned out to be a big problem because we had the turtles' imageviews all being changed at the same time.
	* What could be improved?
		* I think the documentation could be improved. If I had know that the previous implementation of SLogo was forcing the turtle images to be changed all at once, I would have arrived at the solution much faster. Additionally, the factory design pattern made adding a new class a little clunkier than it needs to be. I think the overall design could be improved by simply using reflection instead of a factory, so that I could just change a properties file instead of adding new lines into the factory class. 
	* What would it have been like if you were not familiar with the code at all?
		* I think that it would have been relatively difficult to implement this new feature if I was not familiar with the code at all. Our front end API made it easy to add the new view to the GUI, but the way our front end was organized made it hard to add the actual functionality to the new view. 

