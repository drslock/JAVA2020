## Briefing on DB assignment
### <a href='https://web.microsoftstream.com/group/ae5b71e8-e396-438f-9f02-49f2682d64e6' target='_blank'> Weekly Briefing ![](../../resources/icons/briefing.png) </a>
### Task 1: Introduction


This workbook will lead you through an assessed exercise that has a weighting of 35%
(i.e. it WILL contribute to your unit mark). 
The aim of this assignment is to build a "homebrew" database server (from the ground up !).

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
### Task 2: Assignment Overview


In this workbook, you will build a relational database server from scratch.
This database server will provide the following features:

- To store Entity-Relationship data as a collection of files
- To listen for incoming client requests to interrogate and manipulate the stored data
- To conform to a standard query language that allows operations to be performed on the stored data

It is **essential** that your server is _robust_ - you should detect and trap errors effectively
and ensure that the server continues running at all times. Just imagine a world in which servers
had to be manually restarted every time something unexpected was encountered.
It's going to be very difficult for your server to pass the marking tests if it has crashed !

Note that it is _not_ your responsibility to normalise the database - this is a job for
developers who have designed the database schema and who make use of your database server.

In addition, you will _not_ be required to implement the client-side features of the application.
A database client will be provided for you to help you test your server.

Note that your main class MUST be called `DBServer` and should provide a constructor with
a single parameter (the port number on which to listen). 
Don't change the name of the class or the signatures of any of the methods that already exist
(or we won't be able to test your code !).
We will be using automated marking scripts and if you server does not conform to the above,
we won't be able to run it !
  


# 
### Task 3: Persistent Storage
 <a href='03%20Persistent%20Storage/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='03%20Persistent%20Storage/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Any database system must be able to persistently store data
(otherwise it will lose everything each time it is restarted).
In this assignment, you will use your file system for this purpose.

Your database will consist of a number of tables, each containing a collection of rows
that store _records_ (aka _entities_) - see the table near the end of this section for an example.
The first column in each table will contain a _primary key_
(which should be called `id`). Relationships between entities in different tables should be
recorded using _foreign keys_. You may assume only single element keys are to be used
(i.e. you do not need to cope with "composite" keys).
Note that the ID of an entity should NOT change at any time during the operation of the system.

Each table should be stored in a separate file using TAB separated text.
A <a href="resources/contact-details.tab" target="_blank">sample data file</a>
has been provided for you to illustrate this approach.

In order to load and save files to the file system, you will need to make use of the Java File IO API.
View the slides and video at the start of this section to get an overview of these packages.
You may need to delve more deeply into the
<a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/package-summary.html" target="_blank">File IO API documentation</a> in order to implement your ideas.

Your first practical task is to create a method that reads in data from the filesystem.
Using the provided data file as a source of sample data, read in the rows using appropriate classes and methods from the Java File IO API. At this stage you need only print them out to the screen (in the following section you will store this data in a suitable data structure).
  


![](03%20Persistent%20Storage/images/table.jpg)

**Hints & Tips:**  
It is up to you if you want to store the element/column names in the top row of the data file (as illustrated in the sample data file) or separately in a special schema textfile.

Note that it is not necessary to implement a type system within the database - 
you can just store everything as text strings.  


# 
### Task 4: Java Data Structures


Once the data has been read in from the filesystem, you will need to store this in memory.
You will need to devise a suitable set of classes to represent this data inside your Java program.
Think carefully about the tabular nature of relational databases and then write a set of classes
that match this structure. You will need to consider a whole range of different elements of the
database, including: tables, rows, columns, keys, table names, column names, data values, ids
and relationships between entities.

Remember that this unit is about "programming" (not just "coding") and as such we are attempting
to develop your analysis and design skills. This exercise is more than just implementing a
pre-defined specification - it requires you to understand the domain, be able to deconstruct
the problem and make informed design decisions to achieve a successful solution. As such,
it is not easy - you are likely to make mistakes and will need to refactor your code at different
stages of this assignment.

Once you have written a collection of classes that you feel are appropriate to the problem,
use the file reading methods that you wrote in the previous section to load in data from a
set of sample data files and populate instances of your classes. At this stage you will need
to create your own sample data files, including multiple tables and relationships between those tables.

Once you have successfully stored the imported data in your classes, the next step is to write a
method to save these structures _back out_ to the filesystem again
(using appropriate features of the Java File API).

In order to fully test your program, you should alter the data _whilst it is in memory_
(i.e. before you write it back out to the file again). By changing the data, you can check to 
make sure that the file system files are actually being over-written and updated !  


# 
### Task 5: Communication


It is not the aim of this assignment to address the topic of network or socket programming.
For this reason, the networking aspects of the server have been provided for you
in <a href="resources/DBServer.java" target="_blank">this sample server</a>.
You should integrate the code provided in this sample into your own DBServer application.

When successfully implemented, your database server should listen on port
8888 and receive incoming messages. At this stage in the assignment, your DBServer should
not attempt to interpret the content of the incoming messages.
Rather it should just return the content of all of the tables currently in your database
(irrespective of what the incoming message contained).
You should attempt to make the response as human-reader friendly as possible.

To allow the client application to detect the end of a response, you should terminate
the entire message with an "End of Transmission" (EOT) sequence.
This consists of the EOT character (ASCII value 4) on a line on its own,
after the content of the response. The sample server illustrates how to implement this in code.

To help you ensure that your server conforms to the correct protocol, a 
<a href="resources/DBClient.java" target="_blank">command-line client</a>
has been provided for you. You should not change the code in the client,
but rather use it to check that your server is operating correctly.
During the marking process, this client will be discarded and replaced
by an automated testing component.

For the sake of simplicity, you may assume only a single client is connected at any one time.
(i.e. there is no need to handle parallel queries or deal with issues of contention).  


# 
### Task 6: Query Language


Now that you have a communication mechanism in place, we need something to transmit.
You should implement a database query language based on a simplified version of SQL.
This query language you should support the following keywords:

- USE: changes the database against which the following queries will be run
- CREATE: constructs a new database or table (depending on the provided parameters)
- INSERT: adds a new entity to an existing table
- SELECT: searches for entities that match the given condition
- UPDATE: changes the data contained within a table
- ALTER: changes the structure (rows) of an existing table
- DELETE: removes entities that match the given condition from an existing table
- DROP: removes a specified table from a database, or removes the entire database
- AND / OR: allows conditions to be combined (makes use of parentheses to define ordering) 
- LIKE: used for comparing partial substrings in conditions
- JOIN: performs an **inner** join on two tables (returning all permutations of all matching entities)

All of the above are reserved keywords and should NOT be used as names
for databases, tables or attributes. It is not your responsibility to check for this - if the user
chooses to use them for names, strange things may happen when they perform queries.

A BNF grammar that defines our simplified version of SQL is provided in 
<a href="resources/BNF.txt" target="_blank">this separate document</a>.
Note that your server should be able to correctly parse incoming commands irrespective of
the number of whitespace characters between tokens
(i.e. `name=='Clive'` and `name == 'Clive'` are equivalent and should have the same effect).

Your server should receive incoming messages, interrogate the data stored in the database
and finally return an appropriate response to the client. 
Your query interpreter should identify any errors in the construction of queries
(for example queries not conforming to the BNF or queries that include unknown identifiers).
When an error is detected, your sever should return an error message that provides the user
with information about the nature of the issue.

Note that because you are not required to maintain data type information for the attributes
in a table, it will not be possible for you to validate the type of incoming data.
It is therefore the responsibility of the user to ensure that only numerical data is stored in
numerical attributes and string data is stored in string attributes etc.

It is essential that the response returned from your server begins with either:
- a success tag `[OK]` for valid queries or...
- an error tag `[ERROR]` tag if the query is invalid (it does not conform to the query language BNF)
or the database / table / attribute to which it refer does not exist.

We have provided a <a href="resources/test-transcript.docx" target="_blank">
transcript</a> containing some sample queries and expected responses to illustrate the 
intended operation of the server. Note that these are not comprehensive - additional
and alternative test cases may be used during the marking process.  


# 
### Task 7: Submission


Your submission will be assessed on the success with which it implements the described query language,
as well as the flexibility and robustness with which it operates.
Your submission will also be assessed against the Code Quality metrics outlined earlier in the unit.

This assignment IS assessed: you should visit the "Assessment, submission and feedback"
section on this unit's blackboard page in order to submit your solution.
It is essential that you ensure your code compiles and runs before you submit it
(otherwise we will not be able to run it to mark it !)
You should submit all of the files you have written to complete the task.

Remember that your main class MUST be called `DBServer` and should provide a constructor with a single parameter (the port number on which to listen). Don't change the name of the class or the signatures of any of the methods that already exist (or we won't be able to test your code !). We will be using automated marking scripts and if you server does not conform to the above, we won't be able to run it !

You should neither change, nor submit the `DBClient` class - this is purely to allow you to manually test your server.  


# 
