## GUI Interfaces
### <a href='https://web.microsoftstream.com/group/ae5b71e8-e396-438f-9f02-49f2682d64e6' target='_blank'> Weekly Briefing ![](../../resources/icons/briefing.png) </a>
### Task 1: Introduction
 <a href='01%20Introduction/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='01%20Introduction/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Most complex applications have some kind of Graphical User Interface (GUI).
Until this point in the Java unit, we have not considered how such interfaces are created.
This workbook provides an introduction to this topic - again using JavaFX as the implementation framework.
The slides and video above provide an provide an introduction to the building blocks of
JavaFX GUI interfaces (called "Widgets" or "Controls").

Although not assessed, this material may well be useful in your individual projects and in
your future careers. So it is well worth engaging with now - even if it is to just watch
the videos and try out a few examples.  


# 
### Task 2: New Events
 <a href='02%20New%20Events/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='02%20New%20Events/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

With a new form of user interaction comes the necessity for a new set of events
and event handlers. This is a big area in GUI development - the slides and video
above provide a short introduction to this area. To find out more information,
you might like to explore the event features provided by different controls in the
<a href="https://docs.oracle.com/javafx/2/api/javafx/scene/control/package-summary.html"
target="_blank">JavaFX documentation</a>.  


# 
### Task 3: Layout with Panes
 <a href='03%20Layout%20with%20Panes/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='03%20Layout%20with%20Panes/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

An issue that we usually don't think about when _using_ a graphical interface is that of layout.
For reasons we will see later, we can't just fix the position of widgets with absolute pixel coordinates.
The slides and video above provide an introduction to positioning of widgets on a screen using containers
called "panes". The nesting of these panes (one inside another) results in very complex code !
This complexity is a common characteristic of GUI code - one which we will return to at the end of this workbook.  


# 
### Task 4: Resizing
 <a href='04%20Resizing/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='04%20Resizing/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Elegant resizing is something that we take for granted when using graphic user interfaces.
However it involves a lot of thought and effort on the part of the developer to achieve.
The slides and video above provide insight into the challenges faced in creating resizable
interfaces and illustrates the use of different kinds of JavaFX layout pane as a mechanism
to achieve controlled resizing.   


# 
### Task 5: Value Binding
 <a href='05%20Value%20Binding/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='05%20Value%20Binding/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

In a previous session we introduced the Model-View-Controller pattern.
Synchronising the _view_ presented by a widget with the data _model_ it represents
is an example of this pattern in action. This synchronisation can involved a fair bit
of work on the part of the developer (especially if there are multiple views and controllers
presenting and manipulating the data of a particular model).
Luckily JavaFX provides us with an automated "value binding" facility that can reduce the
amount of synchronisation code we need to write. Take a look at the slides and video above
to find out how this mechanism works and how you might go about implementing this in your code.  


# 
### Task 6: GUI Builder
 <a href='06%20GUI%20Builder/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='06%20GUI%20Builder/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

As we have alluded to previously, the construction of Graphical User Interfaces
is a complex activity that requires much work on the part of the developer.
The code produced is often extensive and monotonous. Luckily there are various
development tools available that can assist developers in quickly producing
graphical interfaces. The slides and video above introduce "Scene Builder" - 
a popular tool for the design and implementation of JavaFX Graphical User Interfaces.  


# 
