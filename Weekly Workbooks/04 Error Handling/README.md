## Error Handling
### <a href='https://web.microsoftstream.com/group/ae5b71e8-e396-438f-9f02-49f2682d64e6' target='_blank'> Weekly Briefing ![](../../resources/icons/briefing.png) </a>
### Task 1: Introduction


In this workbook, we will extend the OXO game that you started last week.
Currently it is possible for a user to make a mistake and input a "bad" cell identifier
(for example, a cell that doesn't exist or one that is already taken by another player)

On receiving a cell position, your code should check to make sure the specified cell is valid
before allowing the player to claim that cell. If the cell position is not valid, your code
should prevent the move from taking place and should then notify the game application
that an error has occurred. In Java there is a special mechanism for handling these kinds of errors...
  


# 
### Task 2: Error Handling in Java
 <a href='02%20Error%20Handling%20in%20Java/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='02%20Error%20Handling%20in%20Java/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a> <a href='02%20Error%20Handling%20in%20Java/video/segment-2.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Handling of run-time errors in Java is achieved using _Exceptions_.
These are a set of special classes and an error handling mechanism that is built into the language.
View the two videos above in order to gain an understanding of the concept of exceptions and to
see a demonstration of exceptions in action.
Make sure you have a solid grasp of these concepts before moving on to the next section.
  


# 
### Task 3: OXO Input Exceptions
 <a href='03%20OXO%20Input%20Exceptions/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='03%20OXO%20Input%20Exceptions/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

In this task, we will implement the user input error handling mechanism for the OXO game.
In order to do this, we will first need to appreciate the range of the different types of user
input error that are possible. These include:

- Already Taken: The specified cell exists, but it has already been claimed by a player
- Outside Range: The identifiers are valid characters, but they are out of range (i.e. too big or too small)
- Invalid Identifier Length: The identifier consists of more than two characters
- Invalid Identifier Character: The row and/or column characters are not valid (e.g. punctuation marks)

View the videos above for an introduction to how inheritance is represented in the "Unified Modelling Language".
With this understanding, take a look at the inheritance hierarchy shown in the
diagram below - this represents the range of different user input errors that might occur during an OXO game.

You should recreate the below inheritance hierarchy in your code - note that in this section you should _only_ create the source
code files and define the class names and "extends" relationships. You will get the opportunity to add the
constructor methods in the following section.  


![](03%20OXO%20Input%20Exceptions/images/inheritance.jpg)

**Hints & Tips:**  
There is a folder in the template project called "OXOExceptions" where you should locate your exception classes.
You might like to use the existing `OXOMoveException` class that is already in this folder as a template for your new classes. A `RowOrCol` class has been provided for you - this can be used to record which dimension (row coordinate or column coordinate) caused the error.
  


# 
### Task 4: This is Super
 <a href='04%20This%20is%20Super/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='04%20This%20is%20Super/slides/segment-2.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='04%20This%20is%20Super/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a> <a href='04%20This%20is%20Super/video/segment-2.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

In order to successfully implement the hierarchy of exceptions shown in the previous section,
you are going to need to be able to refer to the parent of a particular class.
Not only that, but you will need to be able to call the constructor method of that class.
View the above videos on the `super` keyword and constructor chaining in order to find out how to do this.

Implement a constructor method for each class in your exception hierarchy. For each exception
class, you should also write a `toString` method that returns a suitable description of that exception.
This message will be used later to provide feedback to the user - so try to make it as informative as possible.
In the message you should include as much detail about the error as possible.
  


# 
### Task 5: Throwing Exceptions
 <a href='05%20Throwing%20Exceptions/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='05%20Throwing%20Exceptions/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Add appropriate input checking features to your `handleIncomingCommand` method to trap any
invalid inputs entered by the user. When an error is detected, you should instantiate and
then "throw" the relevant exception, (depending on the type of input error that has been made).
The `OXOView` will then "catch" these exceptions and print out a relevant error message to the command line as feedback to the user.

You may assume a maximum grid size of 9x9 (rows `a`-`i` and columns `1`-`9`)
so that a cell identifier can only ever be two characters long.
Note that your code should accept upper as well as lower case row characters
(e.g. `A1` and `a1` are equivalent and both acceptable).

Test your program by playing a game and entering a range of erroneous inputs,
Making sure that all errors are trapped and reported.  


# 
### Task 6: Win detection


There is no point playing the game if nobody can actually win !
Add code to your controller that will detect when a win has been achieved.
You should check for wins in all directions (horizontally, vertically and diagonally).
Horizontal, Vertical are relatively easy (Diagonals are a bit more tricky !)

You should attempt to make your `OXOController` as flexible and versatile as possible.
It should therefore be able to perform win detection on grids of any size (not just 3x3).
Remember that for bigger grids, it is possible to set the number of cells in a row required to win
(the "Win Threshold"). This is done when initially instantiating the `OXOModel`, or by changing
it dynamically during a game using the `setWinThreshold` method.

Note that you are not responsible for checking that the win threshold is achievable
(i.e. that the board is wide or high enough to allow the win threshold to be reached).

Note that when someone has won, the game should not accept any further inputted commands.
There is no need to worry about resetting the game (if the users wish to play again)
it is the responsibility of the `OXOView` to manage this.  


# 
### Task 7: More than Two Players


As an extension to the standard game, why not implement support for more than two players ?
There is no need to alter the `OXOView` to allow interactive selection of the number of players.
To test your extended game, just add extra players to the model when your `OXOController`
is instantiated.  


# 
### Task 8: Submission


No test file is provided for this assignment...
You are becoming experienced programmers now and should be writing your own.
You should write a suite of tests to help you develop your application.
You might like to use the test classes from previous assignments as a template.

This assignment IS assessed: go to "Assessment, submission and feedback" on Blackboard to submit
(You should also visit this page to check the deadline for submission !)
It is essential that you ensure your code compiles and runs before you submit it
(otherwise we will not be able to run it to mark it !)

It is VERY important that you do NOT change the name of any of the classes methods that
you have been given. Scripts will be used to automatically test your code to make sure
it operates correctly - if you change the names (or parameters) we won't be able to test your code !

Note also that you should not have made any permanent changes to the
`OXOView`, `OXOGame` or `OXOPlayer` classes.
These will get replaced during the marking process, so you shouldn't be relying on any code
that you have added to them !  


# 
