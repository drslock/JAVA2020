## Polymorphism and Collections
### <a href='https://web.microsoftstream.com/group/ae5b71e8-e396-438f-9f02-49f2682d64e6' target='_blank'> Weekly Briefing ![](../../resources/icons/briefing.png) </a>
### Task 1: Introduction


The next two workbooks will lead you through an assessed exercise that has a weighting of 20%
(i.e. it WILL contribute to your unit mark). The focus of this assignment is to build a playable game.

You are encouraged to discuss assignments and possible solutions with other students.
HOWEVER it is essential that you only submit your own work.

This may feel like a grey area, however if you adhere to the following advice, you should be fine:

- Never exchange code with other students (via IM/email, GIT, forums, printouts, photos or any other means)
- Although pair programming is encouraged in some circumstances, on this unit you must type your own work !
- It's OK to seek help from online sources (e.g. Stack Overflow) but don't just cut-and-paste chunks of code...
- If you don't understand what a line of code actually does, you shouldn't be submitting it !
- Don't submit anything you couldn't re-implement under exam conditions (with a good textbook !)

If you ask a question on a discussion forum, try to keep disussion at a high level
(i.e. not pasting in chunks of your code). If it is unavoidable to include code, only share
small snippets of the essential sections you need assistance with.

An automated checker will be used to flag any incidences of possible plagiarism.
If the markers feel that intentional plagiarism has actually taken place, marks may be deducted.
In serious or extensive cases, the incident may be reported to the faculty plagiarism panel.
This may result in a mark of zero for the assignment, or perhaps even the entire unit
(if it is a repeat offence).
Don't panic - if you stick to the above list of advice, you should remain safe !  


# 
### Task 2: Game Overview


Your aim in this assignment is to build a digital version of the classic turn-taking game
"Noughts and Crosses" / "Tic-Tac-Toe" / "OXO". You will not be required to construct the entire game.
The Graphical User Interface (see screenshot below) and the core Data Model classes will be provided for you.
You will however be required to write the "Controller" that handles all of the game logic.
  


![](02%20Game%20Overview/images/game.jpg)

# 
### Task 3: Model-View-Controller
 <a href='03%20Model-View-Controller/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='03%20Model-View-Controller/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

The Model-View-Controller (MVC) "pattern" is a common structural convention that is used widely in the development of
interactive systems. You have been provided with an <a href="code/" target="_blank">MVC template</a> for the OXO project to help get you started !

Take a look at the slides and video above for an introduction to the concept of the Model-View-Controller pattern,
then use the knowledge gained to explore the template of the OXO game.

The `OXOModel` class contains the core data structures for the game - you can use the public methods
provided by this class to manipulate the following internal state of the game:

- The list of players currently playing the game (2 in a standard game !)
- The player whose current turn it is
- The winner of the game (when the game ends)
- Whether or not the game has been drawn (all cells are filled, but no one won !)
- The "owner" (player who has claimed) each cell in the game grid
- The number of cells in a row required to win the game (3 in a standard game)

Your main task is to implement the "Event Handling Logic" in the `OXOCOntroller`.
Note that the "Rendering Logic" is handled for you - any changes to the state of the `OXOModel`
will be automatically rendered in the `OXOView`. As a consequence of this,
you will NOT need to interface directly to the `OXOView` class from your `OXOController`.

You may alter the `OXOController` and `OXOModel` classes, however 
you should NOT change the existing method signatures
(if you change the method names or parameters, you may break the marking scripts !)
You should NOT alter the `OXOView` class at all.
The remaining tasks in this (and next) weeks' workbooks will lead you through the features that you need to implement.  


# 
### Task 4: Need for Flexibility
 <a href='04%20Need%20for%20Flexibility/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='04%20Need%20for%20Flexibility/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Clearly, the core data class of the OXO application (`OXOModel`) is going to need some kind of 2-dimensional
data structure in order to store the current state of the board at any particular time.
As you can see from the `OXOModel` you have been given, we have used a simple 2D array.

There is however a problem in that this commits us a particular sized board (e.g. 3x3).
It would be nice to be able to change the size of the board _during_ a game !
For example, if all of the cells of the board were filled and the game was drawn,
the board size could be increased in order to allow play to be continued
(and hopefully a winner might eventually triumph !)

Luckily there are some dynamic data types (e.g. Queues, Stacks,  Lists etc.)
provided by some of the core Java libraries that allow us to store dynamically sized groups of Objects.
There is however a problem with these compound classes when it comes to the storage
and retrieval of the Objects stored in them.
Take a look at the video above to gain an understanding of the causes and implications of these issues.
  


# 
### Task 5: Introducing Generics
 <a href='05%20Introducing%20Generics/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='05%20Introducing%20Generics/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

One solution to the problems identified in the previous section is a Java mechanism called _Generics_.
This mechanism allows us to designate a particular compound data structure to hold a specific object type.
This allows us to make use of untyped data structures, whilst at the same time enforcing type checking at compile time.
View the video above to gain an understanding of how the use of generics achieves this.
  


# 
### Task 6: Collections
 <a href='06%20Collections/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='06%20Collections/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Java provides a number of very useful compound data structures in the _Collections_ package.
These all make use of the Generics mechanism outlined previously.
Watch the video linked to above for an introduction into the _Collections_ package.
Use this knowledge to convert the board grid data structure in the `OXOModel` class from an Array to an
<a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html" target="_blank">ArrayList</a>.

Note that there is no need to test dynamically changing the board size at this stage.
Reimplementing the `OXOModel` with `ArrayLists` is enough for the time being.
You will get to test your changes to the `OXOModel` in the next section...
  


**Hints & Tips:**  
In order to make the change from arrays to ArrayLists you are going to need to change the
declaration and initialisation of the `cells` variable, as well as the cell owner "getter" and "setter" methods.
  


# 
### Task 7: User Interaction
 <a href='07%20User%20Interaction/video/oxo.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

In order to fully test out your changes to the `OXOModel` class we need to actually play a game - so in this task
you will make the game interactive ! Players will take it in turns to enter desired cell position
into the `OXOView` GUI window (see video above). Note that the order of player turns should be the same as the order that players
have been added to the model (i.e. the first player added to the game will take the first go, followed by the second)

A cell position consists of the row letter and the column number of the cell a player wishes to "claim".
For example, if a user wished to claim the centre cell of a 3x3 board, they would type: `b2`.
Cell identifiers entered via the `OXOView` will be automatically passed to the `OXOController`
(via a call to the `handleIncomingCommand` method).

Note that you should set the "current player" to be the player _whose turn it is next_, so that the view shows graphically the player who is about to take a turn.

It is possible that the user may make a mistake when interacting with the system and enter a "bad" cell identifier.
Do not try to deal with these here - we will address error handling in the next workbook.
For the time being, you may assume that any cell identifiers entered by the user are always valid.
  


# 
