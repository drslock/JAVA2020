## Design Patterns
### <a href='https://web.microsoftstream.com/group/ae5b71e8-e396-438f-9f02-49f2682d64e6' target='_blank'> Weekly Briefing ![](../../resources/icons/briefing.png) </a>
### Task 1: Introduction


This week's lectures cover the iterator pattern and strategy pattern. The strategy pattern is particularly useful and should be understood by all OOP developers as it enables selecting an algorithm at runtime - kind of like a function pointer in C. Both patterns are a great vehicle for gaining a deeper understanding of generics, inner classes and abstract inner classes. Understanding these features of Java in depth as well as understanding these patterns will prepare you for other design patterns as well lambdas and streams (not covered in this unit). We suggest you watch all the videos and compile and run the code snippets yourself before attempting the programming exercises.    


# 
### Task 2: Iterator Pattern
 <a href='02%20Iterator%20Pattern/slides/COMSM0086_IteratorStrategy.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='https://web.microsoftstream.com/video/fd0aa10f-a26d-4a7f-a92a-13e1d652a40a' target='_blank'> ![](../../resources/icons/video.png) </a>

Concepts: Abstract Types, Inner Classes, Anonymous Classes, Sets, Concrete Sets, Iterators, Iterator Pattern

The iterator pattern is a behavioural design pattern used to traverse a collection comprised of a number of elements in such a way as not to expose its underlying representation (the array / linked list / binary tree etc. used to store its elements). By the end of this lecture, you will understand how for loops employing the colon notation work and will be able to implement your own custom iterable collections. This lecture will also solidify your understanding of abstract types, polymorphism and anonymous inner classes which are fundamental to a deep understanding of Java’s features.

Code example is provided for <a href="https://www.ole.bris.ac.uk/bbcswebdav/courses/COMSM0086_2020_TB-2/code_snippets/Iterator.zip" target="_blank">iterator pattern</a> 


  


# 
### Task 3: Collections and Strategy Pattern
 <a href='03%20Collections%20and%20Strategy%20Pattern/slides/COMSM0086_IteratorStrategy.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='https://web.microsoftstream.com/video/ef1ff144-d374-4a66-9c71-8462ab48fcb5' target='_blank'> ![](../../resources/icons/video.png) </a>

Concepts: Inner Classes, Anonymous Classes, Collections, JCF, Lists, Initialisations, Comparable, Comparators, Sorting, Strategy Pattern

According to Wikipedia: "the strategy pattern (also known as the policy pattern) is a behavioural software design pattern that enables selecting an algorithm at runtime". In this lecture we'll look at sorting collections of objects based on different properties of those objects and we'll see how the strategy pattern can help. Along the way we'll cover some aspects of generics in a lot more depth, initialiser blocks, and again make use of abstract types, and anonymous inner classes extensively. This lecture will stretch your understanding of Java fundamentals.

Code example is provided for <a href="https://www.ole.bris.ac.uk/bbcswebdav/courses/COMSM0086_2020_TB-2/code_snippets/Strategy.zip" target="_blank">strategy pattern</a> 


  


# 
### Task 4: Strategy Pattern - Live coding
 <a href='https://web.microsoftstream.com/video/f9668918-63b8-472b-960d-86e5790bd581' target='_blank'> ![](../../resources/icons/video.png) </a>

You may find that the strategy pattern as described in the PowerPoint slides is a bit tightly bound to comparators and sorting, such that the strategy pattern itself is a bit lost and we think you will benefit from going through another example that's very different and more real world in its motivation. In this live coding example, we will transform some "bad code" that uses flags and switch statements into some "good code" which employs the strategy pattern. We will make frequent references to the strategy pattern's UML diagram so that the theory and implementation equivalences are properly understood.  


# 
### Task 5: Coding Exercises


1) Implement a class, IteratorFun, which takes an array (of any type) as an argument and implements the Java's Iterable interface such that when it is iterated over, using the colon notation, objects are returned in reverse order. A skeleton to get you started is provided <a href="https://www.ole.bris.ac.uk/bbcswebdav/courses/COMSM0086_2020_TB-2/code_snippets/iterator_fun_question.zip" target="_blank">here</a>.

2) Modify the <a href="https://www.ole.bris.ac.uk/bbcswebdav/courses/COMSM0086_2020_TB-2/code_snippets/LiveCodingStrategyQuestion.zip" target="_blank">'bad code'</a>  Sion implemented in the Strategy Pattern – Live coding video such that it uses the strategy pattern as opposed to a switch statement and a flag. Refer to the live coding video above, if you get stuck.
  


# 
