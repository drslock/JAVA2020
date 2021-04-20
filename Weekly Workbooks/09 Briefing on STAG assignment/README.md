## Briefing on STAG assignment
### <a href='https://web.microsoftstream.com/group/ae5b71e8-e396-438f-9f02-49f2682d64e6' target='_blank'> Weekly Briefing ![](../../resources/icons/briefing.png) </a>
### Task 1: Introduction


This workbook introduces an assignment that is worth the final 45% of the assessment for this unit. The focus of this assignment is to build a general-purpose socket-server game-engine for text adventure games. A typical game of this genre is illustrated in the screenshot below. The following sections of this workbook will explain the construction of this game engine in more detail and provide a breakdown of the features you are required to implement.  


![](01%20Introduction/images/adventure.jpg)

# 
### Task 2: Game Server
 <a href='02%20Game%20Server/video/adventure.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Your aim is to build a game engine server that communicates with one or more game clients.
Your server must use a `ServerSocket` to listen on port 8888 for incoming socket connections.

Upon receiving a connection, your server should accept an incoming command from the client
and process the actions that have been requested. The server should process the command, change any game state that is required and send a suitable response back to the client. After processing the command from the client, your server MUST close the connection and then listen again for the next connection on port 8888. View the video linked above for a demonstration of communication in action.

Don't panic: the basic networking operation is provided for you in a template
<a href="resources/code/StagServer.java" target="_black">server class</a>.
Additionally, you do not need to write the client as this is 
<a href="resources/code/StagClient.java" target="_black">provided for you</a>.
It is essential however that you DO NOT CHANGE the code in the client.
The interactive client will be replaced by an automated test client when marking your work.
If your server cannot communicate successfully with the client provided, it won't work with the testing scripts.

It is intended for your game engine to be versatile so that it is able to play any game
(that conforms to certain rules). To support this versatility, two configuration files
(_entities_ and _actions_) are passed into the game server when it is run. For example:

``` java
java StagServer entities.dot actions.json
```

The server will load the game scenario in from these two files, allowing a range of different
games to be played. During the marking process, we will be using custom game files in order to explore the full range of functionality in your code. It is therefore essential that your game engine allows these files to be passed in (otherwise we won't be able to test your code).  


# 
### Task 3: Configuration Files


The game description files passed into the server contain the following two aspects of the game:

- Entities: "things" in the game, their structural layout and the relationships between them
- Actions: the dynamic behaviours of the entities within the game

Because these two types of data are very different in nature, we have chosen two different documents formats to represent them:

- DOT: A language for expressing graphs (which is basically what a text adventure game is !)
- JSON: A language for expressing structured data (which we will use to store the actions)

You already have much experience of writing parsers ! We don't want to cover old ground,
so you will NOT be required to build your own parsers for these document formats.
Instead, you are able to use two existing parsing libraries. There is considerable educational value in learning to use existing libraries and frameworks in this way.

For parsing DOT files you should use the
<a href="http://www.alexander-merz.com/graphviz/doc.html" target="_blank">JPGD library</a>
(a jar file of this library can be found <a href="resources/libs/dot-parser.jar" target="_blank">here</a>).
For parsing JSON files you should use the
<a href="http://alex-public-doc.s3.amazonaws.com/json_simple-1.1/index-all.html" target="_blank">JSON-simple library</a>
(a jar file of this library can be found <a href="resources/libs/json-parser.jar" target="_blank">here</a>).
To illustrate how parsing libraries may be used, a <a href="resources/code/GraphParserExample.java" target="_blank">rough code fragment</a> is provided to illustrate reading in and printing out the content of DOT files. Note that this example is very "raw" code - you will need to refactor it if you make use of it in your own project.  


# 
### Task 4: Game Entities
 <a href='04%20Game%20Entities/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Each game consists of a number of different "entities" (as described in the "entities.dot" file).
There are a number of different types of entity, including:
- Locations: Rooms or places within the game
- Artefacts: Physical "things" within the game
(that can be collected by the player)
- Furniture: Physical "things" that are an integral part of a location
(they can NOT be collected by the player)
- Characters: Creatures or people involved in game
- Players: A special kind of character that represents the user !

All entities need at least a name and a description, some may need additional attributes as well.
It is worth mentioning that any entity names defined in the configuration files will be unique.
You won't have to deal with two things called "door" (Although your might see a "blue-potion" and a "red-potion").
As such, you can safely use entity names as unique identifiers.

It is worth noting that "Locations" are complex constructs and as such
have various different attributes in their own right, including:
- Paths to other Locations
(note: it is possible for paths to be one-way !)
- Characters that are currently at a Location
- Artefacts that are currently present in a Location
- Furniture that belongs in a Location

Take a look at the video at the top of this section for a walkthrough of an example entity file.
This should hopefully provide you with a clearer idea of the nature and use of such entities files.

We have provided a couple of example entity files for you to use in your project.
Firstly there is a <a href="resources/data/basic-entities.dot" target="_blank">basic entities file</a>
to help get you started in constructing your game engine.
We have also provided an <a href="resources/data/extended-entities.dot" target="_blank">extended entities file</a> that can be used to for more extensive testing during the later stages of your work.

Note that every game has a "special" location that is the starting point for an adventure.
This starting point is always the first location that is encountered when reading in the "entities" file.

There is another special location called "unplaced" that can be found in the entities file.
This location does not appear in the game world, but is rather a container for all of the entities
that have no initial location. They need to exist somewhere in the game structure so that they can be defined,
but they do not enter the game until an action places then in another location within the game.

The big benefit of using DOT files to store game entities is that that are numerous existing tools
for visualising them - we can SEE the structure of the game configuration.
The image below visually shows the structure of the basic entities file.
As you can see, each location is represented by a box containing a number of different entities
(each type of entity being represented by a different shape). The paths between locations are also
presented as directed arrows.  


![](04%20Game%20Entities/images/basic-entities.png)

# 
### Task 5: Game Actions
 <a href='05%20Game%20Actions/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Dynamic behaviours within the game are represented by "Actions", each of which has following elements:

- A set of possible "trigger" words (ANY of which can be used to initiate the action)
- A set of "subjects" entities that are acted upon (ALL of which need to be present to perform the action)
- A set of "consumed" entities that are all removed ("eaten up") by the action
- A set of "produced" entities that are all created ("generated") by the action

Note that "being present" requires the entity to _either_ be in the inventory of the player invoking the action
_or_ for that entity to be in the room/location where the action is being performed.

The above description of actions might not make much sense out of context, however they should become a lot
clearer with an example ! Take a look at the video at the top of this section for a walkthrough of a specific example.

It is worth noting that action names are NOT unique - for example there may be multiple "open" actions that
act on different entities. So be careful when storing and accessing actions.

We have provided a couple of example action files for you to use in the development of your project.
Firstly there is a <a href="resources/data/basic-actions.json" target="_blank">basic actions file</a>
to help get you started in constructing your game engine.
We have also provide an <a href="resources/data/extended-actions.json" target="_blank">extended actions file</a>
that can be used for more extensive testing during the later stages of your work.  


# 
### Task 6: Communication


In order to communicate with the server, we need an agreed language
(otherwise the user won't know what to type to interact with the game !)
There are a number of standard "built-in" gameplay commands that your game engine should respond to:

- "inventory" (or "inv" for short): lists all of the artefacts currently being carried by the player
- "get": picks up a specified artefact from current location and puts it into player's inventory
- "drop": puts down an artefact from player's inventory and places it into the current location
- "goto": moves from one location to another (if there is a path between the two)
- "look": describes the entities in the current location and lists the paths to other locations

It is essential that you conform to this standard set of commands,
otherwise it won't be possible to play your game
(and your game engine will fail some of the marking tests !)

In addition to the standard "built-in" commands, your game engine should also accept ANY of the
trigger keywords from the loaded-in game actions file. You should first verify that the conditions
hold to perform the action (i.e. ALL "Subject" entities are available to the player). You must then undertake the relevant additions/removals (consumption/production). Be sure to make your command interpreter as flexible and robust as possible (to deal with "varied" input from the user !)

The skeleton StagServer class you have been given includes the code to deal with network communication.
You will however be required to deal with reading and writing to the socket stream.
You can either use <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/BufferedReader.html" target="_blank">Buffered Readers</a> and <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/BufferedWriter.html" target="_blank">Buffered Writers</a> as we did with the DB assignment. Or you may like to take this opportunity to explore the 
<a href="https://docs.oracle.com/javase/8/docs/api/java/nio/package-summary.html" target="_blank">
Non-block IO (NIO) API</a>


  


# 
### Task 7: Multiplayer


Your game should be able to operate with more than just a single player.
In order to support this, each incoming command message will begin with a username
(to identify which player has issued the command)

A full incoming message might therefore take the form of:
```
Simon: open door with key
```

It is essential that when an incoming message is received, the command is applied to the correct player !

Note that there is no need for your server to implement any form of authentication - 
you can assume that the client handles this responsibility.
You will however need to maintain game state for each player encountered
(e.g. each player may be in a different location and will carry their own inventory of items etc.)

Note that there is no formal player registration process - when the server encounters a command from
a previously unseen user, a new player should be create in the start location of the game.  


# 
### Task 8: Player Health


As an extension to the basic game, you might like to add a "health level" feature.
Each player should start with a health level of 3.
Consumption of "Poisons & Potions" or interaction with beneficial or dangerous characters will increase or decrease a player's health.
You will see in the "extended" actions file the use of the `health` keyword in the `consumed` and `produced` fields.

When a player's health runs out (i.e. reaches zero) they should lose all of the items in their inventory
(which are dropped in the location where they ran out of health) and then they should return to the start location.
In order to implement these features in your game engine, you should also add a new `health` command keyword
that reports back the player's current health level (so the player can keep track of it).  


# 
### Task 9: Marking


A special set of custom game description files will be used to assess your game.
It is therefore essential your code is able to parse files in the same format as the examples provided !
Scripts will be used to automatically test your game engine to make sure it is operating correctly.
It is therefore essential that you adhere to the gameplay commands detailed previously in this workbook !
You should also ensure that you do not change the name of your main class - it must be called `StagServer`,
if not the marking script will not be able to find it !

We have provided an <a href="resources/code/StagCheck.java" target="_blank">automated checking tool</a>
that can be used to verify the testing script can find, run and communicate with your server.

This assignment is an opportunity to explore Java in detail and there are a range of interesting alternative avenues you might take in implementing this project. You might like to consider employing a range of design patterns (as described in the weekly workbooks).
The Java Core API and Collections package also contains various useful data structures you might like to use.

Note that the "quality" of your code will be taken into account when assessing your work.
The code quality metrics outlined earlier in this unit will be used to derive your final mark.
It is important therefore to adhere to the structure and style guidelines outlined in the previous workbooks.
It is especially important to take heed of the quality feedback advice you have received from previous exercises.  


# 
### Task 10: Plagiarism


You are encouraged to discuss assignments and possible solutions with other students.
HOWEVER it is essential that you only submit your own work.
This may feel like a grey area, however if you adhere to the following advice, you should be fine:

- Never exchange code with other students (via IM/email, USB stick, GIT, printouts or photos !)
- Although pair programming is encouraged in some circumstances, on this unit you must type your own work !
- It's OK to seek help from online sources (e.g. Stack Overflow) but don't just cut-and-paste chunks of code...
- If you don't understand what a line of code actually does, you shouldn't be submitting it !
- Don't submit anything you couldn't re-implement under exam conditions (with a good textbook !)

An automated checker will be used to flag any incidences of possible plagiarism.
If the markers feel that intentional plagiarism has actually taken place, marks may be deducted.
In serious or extensive cases, the incident may be reported to the faculty plagiarism panel.
This may result in a mark of zero for the assignment, or perhaps even the entire unit
(if it is a repeat offence).
Don't panic - if you stick to the above list of advice, you should remain safe !  


# 
