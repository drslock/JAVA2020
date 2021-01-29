## Introduction to Objects
### <a href='https://web.microsoftstream.com/group/ae5b71e8-e396-438f-9f02-49f2682d64e6' target='_blank'> Weekly Briefing ![](../../resources/icons/briefing.png) </a>
### Task 1: Introduction
 <a href='01%20Introduction/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='01%20Introduction/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Welcome to this first practical workbook for the Object Oriented Programming with Java unit.
The aim of these workbooks is to present key theoretical concepts that underlie the unit and 
give you the opportunity to apply these in practical exercises.

Where you see the blue "Slides" and "Video" buttons at the top of a section, 
you should view these _before_ attempting the practical activities described in that section. 
You should do this now for this current section - this will present an introduction to
Java and provide you with a high-level understanding of the nature of Object Orientation.
Note that it is easier to clone these workbooks and view them locally on your own computer
(rather than trying to browse them online via the GitHub site).

Java is a very popular and marketable programming language. Before moving on to the
main tasks in this workbook, you might like to watch 
<a href="https://www.youtube.com/watch?v=Og847HVwRSI" target="_blank">this animation</a>
to see how Java's popularity has changed over the years.
  


# 
### Task 2: Key Concepts
 <a href='02%20Key%20Concepts/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='02%20Key%20Concepts/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

There are a number of key concepts that are fundamental to Object Orientation. Before we progress to any hands-on practical exercises, it is important that you understand such characteristics of Object Oriented code. View the slides and video above to gain an understanding of these concepts. At this stage, we only introduce the concepts at a very high level - we will revisit them again in later sections of this workbook and indeed, later workbooks. Once you are happy that you have an appreciation of these high-level ideas, move on to the following tasks in this workbook.
  


# 
### Task 3: Hello World
 <a href='03%20Hello%20World/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='03%20Hello%20World/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

The first program that you write in most languages is "Hello World". Take a look at the slide and video above that describe "Hello World" in java. Then copy and paste the code (from the slide) into a file called `HelloWorld.java` (note that you can edit java code with any editor you like, although we do recommend Intellij)
It is worth remembering that all Java source code files **must** have a `.java` extension.

To compile your source code file into bytecode, you will need to run `javac HelloWorld.java` on the command line (assuming you have java installed and on your path !) This produces a bytecode file with a `.class` extension. Then to run the program you use `java HelloWorld`. Try this now for your "Hello World" program to make sure you can compile and run java code.

Even if you plan to use an IDE (such as IntelliJ) for programming on this unit, it would still be a good idea to use the command line to compile "Hello World" - if only to get a feel for the process.  


**Hints & Tips:**  
If you are struggling to get Java installed and working on your computer, 
you might like to consider <a href="https://uob.sharepoint.com/sites/itservices/SitePages/fits-engineering-linux-ssh.aspx" target="_blank">remote login</a> to the lab machines to compile and run "Hello World" (since these machines have everything already setup for you).  


# 
### Task 4: Classes and Objects
 <a href='04%20Classes%20and%20Objects/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='04%20Classes%20and%20Objects/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Classes and Objects are the fundamental building blocks of Object Oriented code.
View the slides and video above to see an overview of these constructs.  

Hover over this <img src="answer.jpg" title="The substring is: 01" style="vertical-align:bottom" /> button
to reveal the solution to the problem posed at the end of the video lecture ! Note that the green "Substring"
at the bottom of the last slides _isn't_ the solution, but was a _link to the solution_ (for use in the lecture).

Once you are happy with the concepts presented in the lecture, attempt the following practical activity to test your knowledge.

Create a file called "Triangle.java" and in this, write a class called `Triangle` (to represent a two dimensional triangular shape). This class should have a single constructor method that takes three integer parameters (the length of each side of the triangle). Your class should also have a method called `getLongestSide` that returns the length of the longest side of the triangle.  


Test your code by adding a `main` method to your `Triangle` class. Make sure the signature of your `main` method exactly matches the example from the "HelloWorld" program - if you don't, Java won't recognise it as a `main` method. Inside this `main` method, create a number of different instances of `Triangle`, each with different length sides. Check that your `getLongestSide` method operates as expected. For example, you might use the following code:
``` java
Triangle testTriangle = new Triangle(5, 7, 9);
int longestSide = testTriangle.getLongestSide();
System.out.println("The longest side of the triangle is " + longestSide);
```

Notice how in the above code you can "glue" separate Strings together in Java by using the `+` concatenation operator.
Java will even let you concatenate different types together (in the above example, a `String` and an `int`)

Now use this knowledge to add a `toString` method to your Triangle class that returns a String describing the Triangle
(e.g. "This is a Triangle with sides of length 4, 5, 7")
  


# 
### Task 5: Inheritance and Polymorphism
 <a href='05%20Inheritance%20and%20Polymorphism/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='05%20Inheritance%20and%20Polymorphism/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a> <a href='05%20Inheritance%20and%20Polymorphism/deep/segment-1.pdf' target='_blank'> ![](../../resources/icons/deep.png) </a> <a href='05%20Inheritance%20and%20Polymorphism/deep/segment-1.mp4' target='_blank'> ![](../../resources/icons/deep.png) </a>

View the slides and video above to gain an understanding of the concept of Inheritance. Then attempt the following task which will add to your existing project. The "PRO" slides and video aren't required to complete the exercise, but provides some deeper and more complex information regarding inheritance.
Note that code fragments from the "PRO" segment can be found by following <a href="pro-code.zip" target="_blank">this link</a>.

There are many different types of shape in the world (in addition to just triangles !) We have created a simple hierarchy of shapes for you that includes a <a href="code/Circle.java" target="_blank">Circle</a> and a <a href="code/Rectangle.java" target="_blank">Rectangle</a> - both of these share a super class called
<a href="code/TwoDimensionalShape.java" target="_blank">TwoDimensionalShape</a> (from which all 2D shapes inherit).

Add these three classes to your project and then integrate your existing `Triangle` class into the class hierarchy (by using the `extends` keyword in your `Triangle` class to link it to the `TwoDimensionalShape` class). In order to successfully integrate `Triangle` class into the class hierarchy, you will need to add the following two methods (don't worry too much about these right now, just copy and pasted them into your `Triangle` class - we will return to them in next week's workbook !):

```java
public double calculateArea() {
    return -1;
}

public int calculatePerimeterLength() {
    return -1;
}

```

The slides and video above discussed the notion of Polymorphism - let us explore this concept in your code. Create a variable that can hold an instance of the `TwoDimensionalShape` class - then try to fill this variable with each type of shape in turn (Circles, Rectangles and Triangles). Each time, print the content of the variable - just to show what type it currently holds.  


**Hints & Tips:**  
If you try to print out an instance of a class by passing it to `println`, it will call the `toString` method of that object in order to get a printable string !  


# 
### Task 6: Encapsulation
 <a href='06%20Encapsulation/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='06%20Encapsulation/slides/segment-2.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='06%20Encapsulation/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a> <a href='06%20Encapsulation/video/segment-2.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

As you will see from the slides and audio narration above, encapsulation is a key concept in Object Oriented programming. Let us explore this notion of encapsulation by adding some internal state to our project. In addition to a number of edges, all shapes also have a colour. Add a new variable to the `TwoDimensionalShape` class that allows the shape's colour to be stored. To help you in this task, we have provided you with a <a href="code/Colour.java" target="_blank">Colour</a> class. If you add this class to your project, you will be able to use it in the following way:
```java
Colour firstColour = Colour.RED;
Colour secondColour = Colour.YELLOW;
Colour thirdColour = Colour.WHITE;
```
  


# 
### Task 7: Controlling Access
 <a href='07%20Controlling%20Access/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='07%20Controlling%20Access/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a> <a href='07%20Controlling%20Access/deep/segment-1.pdf' target='_blank'> ![](../../resources/icons/deep.png) </a> <a href='07%20Controlling%20Access/deep/segment-1.mp4' target='_blank'> ![](../../resources/icons/deep.png) </a>

It is no good being able to store the colour of a shape if there is no way to access it ! After all, how would we draw a shape if there was no way to find out what colour it was ? Take a look at the slides and video above to find out why we need to be careful when providing access to encapsulated data. Using this knowledge, add `setColour` and `getColour` methods to the `TwoDimensionalShape` class.

As programmers, we have a lot of control over the access to our variables, methods and classes. Check out the "PRO" video above for more datails about the options available.
  


# 
### Task 8: Final Thoughts


Note that the `StyledString` examples shown in the lecture slides and discussed in the videos is just a _theoretical_ example - in reality Java would not let us do this ! The String class is "final" which means that we are unable to extend it and add features.  


# 
