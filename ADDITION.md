# SLogo Extension

Blake Kaplan



## Estimation

I anticipate this feature taking an hour to implement, as I have to refresh myself on my team's SLogo codebase. As far as implementatino goes, I do not think that making the necessary code changes will be too difficult.

I think that I will have to touch 4 files at the minimum. More specifically, I will have to create a new class for both Wrap and Fence. I will also have to modify 2 properties files and make tweaks to the behavior in GUICanvas for determining the point where a Turtle will be placed given it's X and Y coordinates. The GUICanvas places the Turtle based on the Turtle's coordinates and the Canvas size. The new features will have to alter this behavior.



## Review

It took be about an hour and a half to complete this extension.

While implementing the new feature, I added or modified 9 files total. First, I had to make a class for both Wrap and Fence, each of which extended the DisplayNode class. I also had to change the GUICanvas class to make the appropriate front end changes. I then decided to use an enum to represent which bound behavior to use. This would eliminate the need for passing String constants and would provide easier uniformity. Further, I had to modify resource files that listed the English command, how many children nodes each command would require, and which commands were display command. Lastly, I added an additional resource file that contains important information for bounds behaviors.

I did not get it completely right on my first try because I made a small mistake with reflection and had also not entirely understood how the front end worked. My approach had been correct and I just had to make small tweaks to fix the bugs I encountered.



## Analysis

I think this excercise shows that our backend design was very strong. The bounds behavior commands fit into our interpreter tree design very well. To refresh myself on the design, I read the section about [adding a new command](https://github.com/duke-compsci308-spring2016/analysis_bjk20/blob/master/03_slogo/ANALYSIS.md#adding-a-new-command) from my SLogo analysis. I found the instructions to be accurate and very easy to follow. 

I did, however, realize that the design for our GUICanvas class could have been better. I had not touched this class much when we were originally coding our SLogo project, but had to make changes in it for this extension. At first I struggled to follow the class logic, but found the necessary changes after some experimentation. I think this class could have been improved when we were original building our SLogo project.

If I had not been familiar with the code at all, I think these extensions still would have been manageable, especially with the guidance on adding a new command. The hardest part would have been making the necessary front end changes in the GUICanvas file.