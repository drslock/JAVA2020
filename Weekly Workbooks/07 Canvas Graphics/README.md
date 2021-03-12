## Canvas Graphics
### <a href='https://web.microsoftstream.com/group/ae5b71e8-e396-438f-9f02-49f2682d64e6' target='_blank'> Weekly Briefing ![](../../resources/icons/briefing.png) </a>
### Task 1: Introduction


In previous workbooks we have introduced the fundamentals of the Java programming language.
In the following weeks we'll cover some more specialised topics.
The next few workbooks will focus on creating graphical applications using the JavaFX library.
JavaFX has two main parts: "Canvas" & "Controls".
In this current workbook we will start with the drawing Canvas.
In a future workbook we will take a look at Controls (GUI Widgets).

This topic is not an "assessed learning outcome" for this unit.
As such, you will not be assessed on it.
However, this topic might prove to be very valuable if you need a
GUI for your individual project or in your future careers !

JavaFX can be a little fiddly to install, your best bet is to start with
<a href="https://openjfx.io/openjfx-docs/#install-javafx" target="_blank">this tutorial</a>.
Alternatively you might find it easier to use Maven by following 
<a href="https://openjfx.io/openjfx-docs/#maven" target="_blank">this tutorial</a>.

For comprehensive documentation, see the full 
<a href="https://docs.oracle.com/javafx/2/api/" target="_blank">JavaFX API</a>.
It's fairly extensive, but is well structured (using the standard "JavaDoc" format).  


**Hints & Tips:**  
Top tip: Just be beware of outdated tutorials on the Internet (written for older versions of JavaFX).  


# 
### Task 2: Canvas Drawing
 <a href='02%20Canvas%20Drawing/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='02%20Canvas%20Drawing/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

The concept of a drawing "canvas" is common to many languages and drawing frameworks, including
HTML5, P5.js, JavaFX, D3, SDL, Processing to name but a few. Take a look through the slides and 
video linked to above to gain an understand of canvas operation.
Although our focus in this workbook is primarily on JavaFX,
the high-level concepts are transferable to other frameworks
(although the method names might differ to some extent).
  


# 
### Task 3: Application Structure
 <a href='03%20Application%20Structure/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='03%20Application%20Structure/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

All JavaFX applications have a common structure - see the slides and
video above for an overview and explanation of this structure.
At this stage we are only interested in understanding the high-level concepts.
In the following task we will look at how such a structure is actually achieved in code.
  


# 
### Task 4: JavaFX Code Examples
 <a href='04%20JavaFX%20Code%20Examples/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='04%20JavaFX%20Code%20Examples/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Enough of the high-level theoretical and conceptual discussion - the slides and
video above show how to actually implement the JavaFX application structure in code.
In this video, we also illustrate how to use a range of basic canvas drawing primitives.
  


# 
### Task 5: Events
 <a href='05%20Events/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='05%20Events/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a> <a href='05%20Events/video/segment-2.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Event handling is essential for graphical applications that require
any form of user interaction (either via keyboard or mouse).
Review the slides and video above to gain an understanding
of the event mechanism in use within JavaFX.
The final video above shows a demonstration of mouse and keyboard events
being used to add interactivity to photographic imagery.
We will leave it up to you to figure out how the shift in perspective is achieved !
  


# 
### Task 6: Transformation
 <a href='06%20Transformation/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='06%20Transformation/slides/segment-2.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='06%20Transformation/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a> <a href='06%20Transformation/video/segment-2.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Transformation is a key feature of canvas drawing platforms that enables
more complex and sophisticated drawing to take place.
Review the slides and audio narrations above to gain an understanding of
transformations and the transformation stack.
With this knowledge in mind, think about how you would achieve the following graphic:  


![](06%20Transformation/images/greyboxes.jpg)

**Hints & Tips:**  
Hover your mouse over the following button to reveal one possible 
<img src="answer.jpg" title="
   // Draw the grey box
   g.setFill(Color.rgb(120, 120, 120));  
   g.fillRect(40, 40, 30, 30);
   // Draw the black box
   g.translate(40, 40);
   g.rotate(45);
   g.setFill(Color.rgb(0, 0, 0));
   g.fillRect(0, 0, 30, 30);
" style="vertical-align:bottom" />
  


# 
### Task 7: Sprite Sheets
 <a href='07%20Sprite%20Sheets/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='07%20Sprite%20Sheets/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

The concept of "Sprite Sheets" is core to many game engine platforms.
Java FX provides support for such constructs and permits simple animations to be created.
View the slides and video animation above for a brief overview of sprite sheets
and a demonstration of them in use to create a flocking simulation.  


# 
### Task 8: Animation Loops
 <a href='08%20Animation%20Loops/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='08%20Animation%20Loops/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a> <a href='08%20Animation%20Loops/video/segment-2.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Animation is a common requirement for many types of graphical canvas application.
Review the slides and video above to find out about timers and animation loops.
The final video in the set shows an example animation that makes use of cyclic animation loops
to achieve organic movement of articulated characters.  


# 
### Task 9: Final Demonstration
 <a href='09%20Final%20Demonstration/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a> <a href='09%20Final%20Demonstration/video/z-solion.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

In this final section, we bring together everything we have seen so far in this workbook into a final demonstration application that encompasses: 
canvas drawing primitives, transformations, cyclic animation loops, user interaction and even dynamic data-driven visualisation. 
The first video provides a piece-by-piece deconstruction of the animation, building it up from first principles. 
The second of the two videos shows the final animation in action.  


# 
