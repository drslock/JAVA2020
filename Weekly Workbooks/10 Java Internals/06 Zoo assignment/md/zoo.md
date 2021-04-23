# Zoo

This is a formative task, no submission is required, it should take no longer than 2 hours to
complete. Use the lab sessions/one-on-one support tab in Teams to ask questions and get feedback.

This tiny project will introduce you to the JUnit testing frameword and give you a first experience in using
inheritance, overloading, overriding, polymorphism and multiple dynamic dispatch.

We have provided a tiny skeleton project for you to work with. The project includes a set of .java
files and a testing suite, which you can use to make sure your project does what it is meant to -
you can check your coursework this way continuously whilst developing and find out where things need
fixing and when you have arrived at a fully working solution!

You can download the
skeleton [here](https://www.ole.bris.ac.uk/bbcswebdav/courses/COMSM0086_2020_TB-2/code_snippets/zoo.zip)

You should unzip the contents of that file into a newly prepared local directory and turn that
directory into a private git repository, accessible by both members of your pair programming team to
work on.

**You might not want to use IntelliJ for this project; compile programs directly from the
terminal<sup>[1](#no-ij)</sup>**.

<a name="no-ij">1</a>: You can use IntelliJ, but you wont get the full JUnit experience! 

---

## Compiling and Running the Skeleton Project

We start by compiling our project. We do this by moving into the src directory and running
the `javac`
command on `Zoo.java`. Consider using the `-Xlint:all` flag with `javac` to enable further warnings.
This will compile `Zoo.java` to a new file, `Zoo.class`, which contains the Java bytecode used by
the Java interpreter to run your program. You will notice that it also compiles all dependent files
such as `Animal.java` and `Food.java`. Now we can run the program using the java command on `Zoo`.
This tells the interpreter to look for the .class file which contains the bytecode of `Zoo.java`.

**TODO**: Compile `Zoo.java` and run `Zoo.class` by running these commands from inside the directory
you just downloaded , you should get a friendly message when you run the program:

```shell
cd src 
javac Zoo.java -Xlint:all 
java Zoo
```

## Testing

Before we start properly, we need to take a segway into a testing framework called *JUnit*. We use
tests when writing our program to highlight mistakes and verify that our code is functioning
correctly. This may seem trivial, but it can be very helpful, particularly in large projects where
changing one thing can have unintended side effects.

JUnit tests are contained in normal classes, the difference is that we use special annotations and
methods to let JUnit know what to run. Lets look at test1 in `test/Tests.java`:
<!-- @formatter:off -->
```java
@Test
public void test1() {
  Zoo zoo = new Zoo();
  Animal animal = new Animal();
  Food food = new Food();

  String output = zoo.feed(animal, food);

  assertEquals("Feeding Food to an Animal:", "animal eats food", output);
}
```
<!-- @formatter:on -->

The `@Test` annotation before the method lets JUnit know that this method is in fact a test and that
it should be run as such. We can of course have helper methods (and classes!) that are not tests,
and it wouldn't make sense for JUnit to run them directly.

We set up this test by creating some new objects, a `Zoo`, `Animal` and `Food`. We then call the
`feed` method in the `Zoo` object which returns a `String`.

The last line of the method uses a static method called `assertEquals`. This takes three arguments,
a message to tell us about the test, the value that we expect, and the value that we are actually
receiving. If the latter two values we pass in are not equal then JUnit informs us that we are
failing the test.

For more information on JUnit go
to [their official documentation](https://github.com/junit-team/junit4/wiki/Getting-started).

To use the tests you must compile and run `TestRunner.java`. The commands to do this look slightly
different to those we have been using, but do not fear! The only difference is that we are now
compiling files from a number of locations and as such we must let javac know where these locations
are. The `-cp` flag (which stands for Classpath) does exactly this, we provide it with all the
folders that the compiler should look in when compiling our code. For our project we include:

* `src`: Contains all the classes we will be using with `Zoo.java`.
* `test`: Contains all the tests we will be running.
* `lib/junit-4.7.jar`: Contains the JUnit library for running the tests.

We also want to recompile the files in `src` when we run the test so that any changes we have made
are applied in the tests. To do this we add `src/*.java` to the list of source files.

**TODO**: Move back to the root directory and compile the tests using the extended `javac` commands:

```shell
# at project root (i.e you can see the src and test directory)
# For Linux/macOS only:
javac -cp src:test:lib/junit-4.7.jar test/TestRunner.java src/*.java -Xlint:all
# For Windows only:
javac -cp "src;test;lib/junit-4.7.jar" test/TestRunner.java src/*.java -Xlint:all
```

To run `TestRunner` we must again specify our classpath. Notice that when compiling we specify the
source files (including their relative location), but when running we just specify the class name.

**TODO**: Run the tests using the command:

```shell
# at project root (i.e you can see the src and test directory)
# For Linux/macOS only:
java -cp src:test:lib/junit-4.7.jar TestRunner
# For Windows only:
java -cp "src;test;lib/junit-4.7.jar" TestRunner
```

---

## The Project

The `Zoo` class that we were compiling earlier contains a `feed` method, which the provided tests
call. There are also a number of other classes in the `src` folder which `Zoo` makes use of. Some of
these classes are incomplete, and it will be your task to complete them so that the project passes
the tests.

### Part 1

Let's begin by looking at the output that running the tests produces:

```
test1(Tests):
Feeding Food to an Animal: expected:<animal eats food> but was:<null>
test2(Tests):
Feeding Food to a Dog: expected:<dog eats food> but was:<null>
test3(Tests):
Feeding Foods to Animals: expected:<animal eats food> but was:<null>
```

We are currently failing all the tests. When an `assertEquals` fails, JUnit gives us the name of the
test that failed and then tells us the value it expected, and the value it has received. Note that
the tests are not run in any particular order, so your output may be slightly different.

Test 1 expects the output `animal eats food`, but it is currently getting `null`. Let's look at the
test again:

<!-- @formatter:off -->
```java
Zoo zoo = new Zoo();
Animal animal = new Animal();
Food food = new Food();

String output = zoo.feed(animal, food);
assertEquals("Feeding Food to an Animal:", "animal eats food", output);
```
<!-- @formatter:on -->

You can see that this test calls the method `feed` with an instance of `Animal` and `Food`. Take a
look at the `Animal` and `Food` classes and modify the definition of `feed` so that your code passes
this test. Make sure that you use each of the methods in the `Food` and `Animal` classes to do this.

Hint: you will need to implement the `feed` method in `Zoo`, probably using only one line.

**TODO**: Using the methods in `Animal` and `Food`, modify the feed method in `Zoo.java` so that the
first test passes. You will need to recompile each time you make a change.

### Part 2

<!-- @formatter:off -->
```java
Zoo zoo = new Zoo();
Dog scooby = new Dog();
Food food = new Food();

String output = zoo.feed(scooby, food);

assertEquals("Feeding Food to a Dog:", "dog eats food", output);
```
<!-- @formatter:on -->

The second test is very similar to the Test 1, but instead of calling `feed` with a generic `Animal`
it instead calls `feed` with an instance of `Dog`. But hang on, `feed` takes an `Animal` and
a `Food`, how can we call it with an instance of `Dog`?

To understand what’s happening here we need to look at a core idea in Java called inheritance. If we
move out of Java land for a moment and think about real world animals, there are certain attributes
that all animals have such as a species, and certain things they can do such as make a noise or eat.
Specific animals inherit these attributes simply by being animals, but they also have certain things
that they might not share with all animals. A dog, for example, can bark but an eel probably
couldn't.

We can represent this in Java by having a hierarchy of classes, those lower down inherit all the
attributes and methods from the ones above. Our project has two hierarchies.

We can see that our `Dog` class inherits from `Animal` and indeed, if we look inside `Dog`, after
the class declaration there is a short statement, `extends Animal` which tells the compiler that
this relationship exists.

<!-- @formatter:off -->
```java
public class Dog extends Animal {
    //TODO
}
```
<!-- @formatter:on -->

As well as inheriting all the attributes and methods declared in `Animal`, this means we can treat
it as if it were an animal (which of course it is) and pass it into `feed` no problem!

So we have passed an instance of `Dog` into `feed` but if you look at the result of test 2 it
expects the output `dog eats food`, and we are currently printing `animal eats food`. This is
because the `eat` method is being called in `Animal` (which `Dog` inherits from remember). We can
stop this from happening by having a method inside `Dog`, which has the exact same signature as the
one in `Animal`:

<!-- @formatter:off -->
```java
@Override
public String eat(Food food) {
    return food.eaten(this);
}
```
<!-- @formatter:on -->

This is known as overriding, the program sees that the animal we are calling the method eat on is of
type `Dog` and that `Dog` does indeed have a method that matches eat. The program then makes sure to
call the method in `Dog` rather than the one in `Animal`. Notice the `@Override`, this is not
required, but it tells the compiler that we are intending to override a method and that it should
give us an error if we do this incorrectly - for example if we don't match the method signature
exactly.

**TODO**: Override `Animal`'s eat method in `Dog`. Now the eat method is being called in `Dog` but
once again, we are calling the eaten method in `Food`, producing the output animal eats food. We
still don’t pass the test. The difference now is that the `Animal` passed into the eaten method is
of type `Dog`, we can use this fact by implementing another method in Food:

<!-- @formatter:off -->
```java
public String eaten(Dog dog) {
    return "dog eats food";
}
```
<!-- @formatter:on -->

This looks suspiciously like the existing eaten method, but instead of taking an argument of type
`Animal` (or something that inherits from `Animal`), it only takes an argument of type `Dog`. But
hold on, `Dog` inherits from `Animal` so which method is called? They both have the same name, and
they both accept a single argument of type `Dog`. This is a big topic we called dynamic dispatch in
the lectures -- essentially the method that takes `Dog` is called as it is closest in the hierarchy
to the argument we are passing in. Having multiple methods named the same that take different
arguments is known as overloading.

**TODO**: Overload the eaten method in `Food` with one that takes a `Dog`. Your code should now pass
the second test.

### Part 3

The final test feeds every type of food to every type of animal. Look at what output the test
expects. Using overloading and overriding, make sure that your code passes this test.

**TODO**: Make changes to your code so that its passes the final test.

We have actually been implementing something we called multiple dynamic dispatch in the lectures to
make sure that the methods are being called in the correct places depending on the classes of
objects that receive messages! Compare your solution with the `DispatchWorld` example in the
lectures and discuss the similarities and differences.
