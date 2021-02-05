## Further Language Constructs
### <a href='https://web.microsoftstream.com/group/ae5b71e8-e396-438f-9f02-49f2682d64e6' target='_blank'> Weekly Briefing ![](../../resources/icons/briefing.png) </a>
### Task 1: Introduction


The aim of this session is to introduce further features of the Java programming language.
Each section provides some teaching materials (typically written material, slides and video)
that introduces a concept, as well as an activity to undertake that will allow you to apply your
freshly-gained knowledge. In this workbook we continue with the triangle exercise from last week
and you will get the opportunity to extend it with additional features and functionality.
  


# 
### Task 2: Abstract
 <a href='02%20Abstract/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='02%20Abstract/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

An inspection of the code inside the `TwoDimensionalShape` class shows that there are two "abstract" methods.
These are methods without implementations (i.e. methods with no internal code).
View the slides and video lecture above to find out more about the notion of "abstract".
The video discusses the use of "abstract" in implementing lists - don't worry too much about these for the moment !
We mention lists briefly here for completeness - will we revisit them again in more detail later on in this unit.

Inside your Triangle class, complete the `calculateArea` and `calculatePerimeterLength` methods that you added
during the previous workbook. Inside each you should perform a suitable calculation and return the result.
These two methods will "override" the abstract ones defined in the `TwoDimensionalShape` class.
The reason that these are defined as "abstract" in the `TwoDimensionalShape` class is that: all shapes
_will_ have an area and perimeter length, but each shape will calculate these differently
(so we can't write anything sensible inside the `TwoDimensionalShape` class).

Once you have implemented area and perimeter calculation methods for your Triangle class, create a few
Triangles with different length sides and call your newly created methods to make sure they work correctly.
  


**Hints & Tips:**  
You might like to use <a href="https://www.mathsisfun.com/geometry/herons-formula.html" target="_blank">Herons Formula</a>
to calculate the area of a triangle. The perimeter length is easy !
  


# 
### Task 3: Enumerations
 <a href='03%20Enumerations/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='03%20Enumerations/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Some shapes (such as Circles) come in only one variant - a Circle is a Circle !
Other shapes (such as Triangles) can be a range of different variants (Isosceles, Right-angle, Equilateral etc).
We could create a range of subclasses of the `Triangle` class to represent these, however this might be overkill
(it is possible to over-use inheritance). These various sub-classes wouldn't have any additional attributes or methods,
so we could end up with a lot of almost empty files - clearly unnecessary complexity in our file system !

Instead, we will use this opportunity to explore another feature of Java - "enumerations".
In Java there is an enumeration mechanism (very much like that in C).
This allows us to declare a predefined list of values that a variable can hold.
Take a look at the video above (from our guest presenter !) to find out more details regarding
exceptions before going on to attempt the task below.

Extend your Triangle Class in order to make it "self-aware": so that it will _know_ what kind of triangle it is.
We aren't going to actually _tell_ the triangle what variant it is, the triangle will work it out for itself
(based on the length of the sides passed into the constructor).
So, add some code to your Triangle constructor method so that it works out what kind it is.
We have provided you with an enumeration called <a href="code/TriangleVariant.java" target="_blank">TriangleVariant</a>
that can be used to differentiate between the various triangle variants.
Once you triangle has worked out what variant it is, store the result in a private variable of type `TriangleVariant`.

You will get the opportunity to fully and systematically test your code in the next section.
For the time being, just try to ensure that your code works with as many different triangle variants as possible.
  


**Hints & Tips:**  
To help you classify some of your triangles, you might like to make use of the `getLongestSide` method your wrote previously !

Create a multi-branch IF statement that will allow the triangle to decide what kind it is. The order of the branches of the IF statements will be very important. Check for specific/special cases at the top, with more general cases at the bottom (you'll soon understand why later !)
  


# 
### Task 4: Interfaces
 <a href='04%20Interfaces/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='04%20Interfaces/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

As we have discussed previously, some shapes may have different variants,
whilst others (such as Circles) only have one. What we need is some kind of marker that indicates
whether or not a particular class of shape has multiple variants.

One way to do this is using a Java "Interface" - this is a mechanism, independent of the class hierarchy,
that allows us to mark classes as having particular characteristics. You can think of an Interface as a contract
that the class "agrees to" and guarantees to provide certain properties and features.
Take a look at the slides and video above for more detailed information on interfaces.

As an illustration of interfaces in action, we have provided a
<a href="code/MultiVariantShape.java" target="_blank">MultiVariantShape</a> interface that can be used to
indicate that a shape has more than one variant.
We would use this interface to mark our `Triangle` class like so:
``` java
class Triangle extends TwoDimensionalShape implements MultiVariantShape
```

We can test to see if an object conforms to an interface by using the Java `instanceof` keyword
(I know this is not a particularly suitable name, but it is reused from another part of Java).
So, for example, we can test any shape to see if it implements the `MultiVariantShape` interface
using the following code:
``` java
if(shape instanceof MultiVariantShape) System.out.println("This shape has multiple variants")
else System.out.println("This shape has only one variant")
```

You may have noticed that the `MultiVariantShape` interface defines a method called `getVariant`
that returns the variant of a shape. This allows code outside of the class to interrogate an instance
in order to find out what variant it is. You will also notice that their is no internal code that
provides an implementation of this method - it is the programmer's job to write this !
Add a method to your class called `getVariant` that returns the `TriangleVariant` that you
calculated and stored in the previous task.
  


**Hints & Tips:**  
We have provided a <a href="code/TriangleTester.java" target="_blank">TriangleTester</a>
class that contains a variety of test cases to help you develop your class.
The test class makes use of "Assertions" so you will need to enable these when you run the test
class by using the following on the command line: `java -ea TriangleTester`
(or by adding `-ea` to the command line parameters of your IDE).

When testing your code using the testing class, focus on each type of triangle in turn
(first Equilateral, then Isosceles, then Scalene etc.). Make sure your code passes all of the tests
for that type before moving on to the next.

The final group of tests (to do with overflow) are more difficult, so leave those until the end.
These may require you to refactor your code a fair bit (depending on how you wrote it in the first place) !
  


# 
### Task 5: Multiple Inheritance
 <a href='05%20Multiple%20Inheritance/deep/segment-1.mp4' target='_blank'> ![](../../resources/icons/deep.png) </a> <a href='05%20Multiple%20Inheritance/deep/segment-2.mp4' target='_blank'> ![](../../resources/icons/deep.png) </a>

Just as an aside, let us think about _multiple_ inheritance.
In some situations, it might be useful for a class to have multiple parents/superclasses.
This would allow it to derive methods and attributes from numerous different sources.
This is however dangerous - watch the first video above to find out why !

Java's solution to this is to only use single inheritance, but to augment this with interfaces. Watch the 2nd video above to gain an understanding of how this works.
Although a bit of a comprimise, this mechanism allows us to gain some of the benefits of multiple inheritance, whilst avoiding some of the pitfalls.  


# 
### Task 6: Arrays
 <a href='06%20Arrays/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='06%20Arrays/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a> <a href='06%20Arrays/video/segment-2.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Arrays in Java are very similar to those in C. In Java, they can hold primatives
(e.g. `int`, `float`, `char`, `boolean` etc)
but also complex Objects such as Strings, Robots or even Triangles !

Take a look at the video segments above for more information on arrays in Java.
Then (in you main method) create an array of 100 elements that can hold `TwoDimentionalShapes`.
Fill this array with randomly chosen shapes (Circles, Rectangles, Triangles).

Once you have filled the array with 100 shapes, loop through it and print details of each shape.
At the end of your program, print out a summary of how many Triangles were encountered in the array.
  


**Hints & Tips:**  
In order to fill your array with a random selection of shapes, you may like to make use of the Java "Random" method:

`Math.random()`

This will return a randomly selected double precision floating point number (between 0.0 and 1.0).
You will need to write an IF statement to look at this number and decide which shape to create.

In order to count the number of triangles, you'll need an integer counter variable.
You might also like to make use the `instanceof` operator !
  


# 
### Task 7: Class Variables and Methods
 <a href='07%20Class%20Variables%20and%20Methods/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='07%20Class%20Variables%20and%20Methods/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

In the previous task, we counted the number of Triangles in the array whilst looping through it.
But there is an alternative way to do this (without putting code inside the loop).
We can maintain a counter of how many Triangles have been created _inside_ the Triangle class itself
(incrementing this each time one is instantiated).
But their is a problem - we only want _one_ counter for the whole programme
(not a counter for each and every Triangle)

View the slides and audio narration above to gain an understanding of the difference
between _instance_ and _class_ variables. Then add an integer _class_ variable to your Triangle class to
keep track of how many Triangles have been created (don't forget to increment this in the constructor !).
Add a `getPopulation` method to your Triangle class that returns the current value of this counter variable.

Update your main method, so that it prints out the number of Triangles that existing using
this population counter _as well as_ the previous counter inside the loop
(just to make sure both counters agree !)

Just as we can create _class variables_ that are associated with the class (rather than each instance),
we can also write _class methods_ which are similarly associated with the class (not the instances).
You have already encountered just such a class method (namely the `random` method of the `Math` class).
Have a think about why you might wish to write a class method, rather than an instance method.
Considering the Triangle class - might some of its methods be better suited to being _class_ methods,
rather than _instance_ methods ?
  


# 
### Task 8: Casting


But there is a problem !

What if we want to find out the variant of a triangle that is stored in the array ?
We can't call `getVariant` on just any element of the array - because it might not actually _be_ a Triangle
(it might be a Circle, which doesn't support the `getVariant` method !)
Java will in fact block us from trying to call `getVariant` on a TwoDimentionalShape.

To solve this problem, Java will let us "cast" objects to a more specific class
For example, we can "down-cast" (or "narrow-cast") any TwoDimentionalShape into one of it's sub-classes.
We can then, quite happily call methods of that subclass, for example:

``` java
TwoDimentionalShape[] shapes = new TwoDimentionalShape[100];
...
TwoDimentionalShape firstShape = shapes[0];
Triangle firstTriangle = (Triangle)firstShape;
TriangleVariant variant = firstTriangle.getVariant();
```

The above asks Java to _trust_ that the `firstShape` is a Triangle.
As a consequence of this, we can then treat this Object as a Triangle and thus call
any of the methods of `Triangle` on it.

But what happens if the element at position 0 _isn't_ actually a Triangle ?
What if it is a Circle ?
Will Java let us convert a Circle into a Triangle in this way ?

Why not try it out and see what happens !
  


# 
