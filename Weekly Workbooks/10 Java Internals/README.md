## Java Internals
### <a href='https://web.microsoftstream.com/group/ae5b71e8-e396-438f-9f02-49f2682d64e6' target='_blank'> Weekly Briefing ![](../../resources/icons/briefing.png) </a>
### Task 1: Introduction


In this workbook we introduce some more complex "internal workings" of Java and our first design pattern.
You may not need all of them to be able to complete the assignments, 
but you may find it useful in some situations to know what is going on "under the hood"  


# 
### Task 2: Objects life
 <a href='02%20Objects%20life/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='https://web.microsoftstream.com/video/a5dde363-98e8-4b47-8fc6-723a1c3b5a7d' target='_blank'> ![](../../resources/icons/video.png) </a> <a href='https://web.microsoftstream.com/video/05247e4f-05b9-4b75-81b6-89973ca378dd' target='_blank'> ![](../../resources/icons/video.png) </a>

Concepts: overloading, references, reference equality, equals, this, null, the heap, arrays, object scope, instance persistence, call-by-reference, call-by-value

This week's and next week's lectures will be in the traditional long form. For Object's life, there will be a lot of revision, we're going to be covering the life cycle of objects and we're going to be focusing on the heap and the stack. We think this stuff is really important because if you understand where objects reside in memory and where references reside and the relevance of the stack and the heap, it will make you more efficient programmers that are less prone to bugs and when you do have bugs, you'll be able to track them down more easily. Furthermore, understanding these concepts is vital for understanding the rest of this and next week's materials.
  


# 
### Task 3: Double Dispatch
 <a href='03%20Double%20Dispatch/slides/COMSM0086_PolymorphismDoubleDispatch.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='https://web.microsoftstream.com/video/3bf4b450-20e6-47e8-aa16-713eae28a47a' target='_blank'> ![](../../resources/icons/video.png) </a>

Concepts: abstract classes, multiple dynamic dispatch, overriding, operation decoupling, Visitor pattern, class diagram basics, procedural vs OO multiple dispatch

If you liked single dispatch and polymorphism, you'll love double dispatch. Double dispatch dispatches calls to different concrete methods depending on the runtime types of the two objects involved in the call: dispatch based on 2 types. For example, consider collisions between two game objects which are both referred to by the same abstract superclass. The references are of the same type, but the underlying objects could be drawn from a variety of subclasses. How can we exploit polymorphism to handle these interactions in a seamless way?

Code examples are provided for <a href="https://www.ole.bris.ac.uk/bbcswebdav/courses/COMSM0086_2020_TB-2/code_snippets/rock_paper_scissors2021.zip" target="_blank">rock, paper, scissors</a> and <a href="https://www.ole.bris.ac.uk/bbcswebdav/courses/COMSM0086_2020_TB-2/code_snippets/MammalInteraction2021.zip" target="_blank">mammal interactions</a>  


# 
### Task 4: Visitor Pattern I
 <a href='04%20Visitor%20Pattern%20I/slides/COMSM0086_Visitor.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='https://web.microsoftstream.com/video/f080e53c-01f2-4622-ac9e-5fab225bff90' target='_blank'> ![](../../resources/icons/video.png) </a>

Concepts: abstract classes,  multiple dynamic dispatch, overriding, operation decoupling, Visitor pattern, class diagram basics

The Visitor Pattern facilitates the addition of new operations to existing object structures without modifying those structures (maybe look up open closed principle). A visitor class is created that implements all of the appropriate specializations. The visitor takes the instance reference as input, and implements the goal through double dispatch.

Code examples are provided for <a href="https://www.ole.bris.ac.uk/bbcswebdav/courses/COMSM0086_2020_TB-2/code_snippets/mammal_visitor.zip" target="_blank">mammal visitor</a> and <a href="https://www.ole.bris.ac.uk/bbcswebdav/courses/COMSM0086_2020_TB-2/code_snippets/credit_card_visitor.zip" target="_blank">credit card visitor</a>
  


# 
### Task 5: Visitor Pattern 2
 <a href='05%20Visitor%20Pattern%202/slides/COMSM0086_Visitor.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='https://web.microsoftstream.com/video/a521f48d-dda3-4394-b432-0225cff00118' target='_blank'> ![](../../resources/icons/video.png) </a>

Concepts: abstract classes,  multiple dynamic dispatch, overriding, operation decoupling, Visitor pattern, class diagram basics

So the great thing about the visitor pattern is that you can use it on dynamic structures like trees as well as the static structures we looked at previously, the credit cards. In this lecture we’ll see how any operations a binary tree may be defined independently from the object structure itself. Specifically, the operations will be encapsulated in a separate object which we shall call the Visitor …

Code example is provided for <a href="https://www.ole.bris.ac.uk/bbcswebdav/courses/COMSM0086_2020_TB-2/code_snippets/tree_visitor.zip" target="_blank">tree visitor</a>   


# 
### Task 6: Zoo assignment


This is a formative task, no submission is required, it should take no longer than 2 hours to complete. Use the lab sessions/Discussion Forum tab in Teams to ask questions and get feedback.

This tiny project will introduce you to the JUnit testing frameword and give you a first experience in using inheritance, overloading, overriding, polymorphism and multiple dynamic dispatch.

We have provided a tiny skeleton project for you to work with. The project includes a set of .java files and a testing suite, which you can use to make sure your project does what it is meant to - you can check your coursework this way continuously whilst developing and find out where things need fixing and when you have arrived at a fully working solution!

You can download the skeleton and get detailed instructions [here](06%20Zoo%20assignment/md/zoo.md)
  


# 
