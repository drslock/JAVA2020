## Code Quality
### <a href='https://web.microsoftstream.com/group/ae5b71e8-e396-438f-9f02-49f2682d64e6' target='_blank'> Weekly Briefing ![](../../resources/icons/briefing.png) </a>
### Task 1: Introduction
 <a href='01%20Introduction/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='01%20Introduction/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Writing good code is not just about correct operation - code may compile and pass all of the tests, but may still be _badly_ written ! The aim of this week's workbook is to give you an appreciation of code _quality_ both in terms of how to assess it and how to improve it. View the slides and audio narration above to gain an understanding of this general area. Then proceed with the tasks in this workbook in order to explore these areas in more detail.

There are no explicit practical tasks for you to complete in this week's workbook. Rather, you should use the knowledge that you have gained from the material in each section to reflect upon your own Java programming practice. You should consider how you might improve the "quality" of your code as you progress into future assignments.

  


# 
### Task 2: Complexity
 <a href='02%20Complexity/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='02%20Complexity/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

View the slides and audio narration above to gain an understanding of the nature and impact of code complexity. With this knowledge in mind, consider the code fragment shown below. The sample code loops through a folder of images and loads each in turn into a 2D array of pixels. The code then scans through all the pixels in this 2D array and replaces the colours found using a look-up table (consisting of a pair of arrays). 

``` java

String[] folderContent;      // Initialised elsewhere
Colour[] originalColours;    // Initialised elsewhere
Colour[] replacementColours; // Initialised elsewhere

for (String filename: folderContent) {
    if((filename.endswith(".jpg")) || (filename.endswith(".JPG")) || (filename.endswith(".png")) || (filename.endswith(".PNG"))) {
        Colour[][] pixelData = loadPixelData(filename);
        for(int x=0; x<pixelData.length ;x++) {
            for(int y=0; y<pixelData[0].length ;y++) {
                for(int i=0; i<originalColours.length ;i++) {
                    if(pixelData[x][y] == originalColours[i]) {
                        pixelData[x][y] = replacementColours[i];
                    }
                }
            }
        }
        savePixelData(pixelData, filename);
    }
}

```

Even though the code is fairly short, a method containing this code would have a Cyclomatic Complexity of 10 and a Depth-of-Nesting of 6 (both very high values). Think about how you might refactor this code to make this particular method less complex and therefore more readable. Hover your mouse over the <img src="answer.jpg" style="vertical-align:bottom" /> buttons below if you get stuck coming up with ideas !

Possible improvements: 
<img src="answer.jpg" title="You could put the tests for image file extensions into a method called &quot;isImageFile&quot; ?" style="vertical-align:bottom" />
<img src="answer.jpg" title="What if you wrote a method called &quot;replaceAllPixels&quot; that took the 2D pixelData array as a parameter and did all of the looping ?" style="vertical-align:bottom" />
<img src="answer.jpg" title="You could write a method called &quot;replaceSinglePixel&quot; that searched through the original colour array and then did a single replacement using the relevant colour from the replacement array" style="vertical-align:bottom" />
<img src="answer.jpg" title="Using the pair of arrays for colour replacement is fairly ugly - you could use a better lookup table (such as a hash map)" style="vertical-align:bottom" />
  


# 
### Task 3: Good Naming
 <a href='03%20Good%20Naming/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='03%20Good%20Naming/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Something as simple as choosing the right names for things can help greatly with the understandability of code. View the slides and audio narration above in order to see a discussion on the nature of naming. With this discussion in mind, take a look at the following list of method names and consider whether or not they are _good_ names. Hover your mouse over the <img src="answer.jpg" style="vertical-align:bottom" /> buttons to find out what we think of them !

- clone <img src="answer.jpg" title="This is OK - it's a bit short and only one word, but has a specific meaning within the Java language (so everyone should understand it)" style="vertical-align:bottom" />
- sort <img src="answer.jpg" title="This isn't very good - sort what ? sort by which order ?" style="vertical-align:bottom" />
- search <img src="answer.jpg" title="Borderline - the parameter name might hint at what attribute is being used for the search, but a longer method name would definitely help !" style="vertical-align:bottom" />
- getArray <img src="answer.jpg" title="This is bad - which array ? what does it contain ?" style="vertical-align:bottom" />
- readData <img src="answer.jpg" title="Again, not very good - what data is this ?" style="vertical-align:bottom" />
- getLatestAdditionToResourceList <img src="answer.jpg" title="Perhaps a little too long - you can go too far !" style="vertical-align:bottom" />
- doTheThing <img src="answer.jpg" title="Could this BE any vaguer ??? Both noun and verb are non-specific !!!" style="vertical-align:bottom" />
- calcNumDist <img src="answer.jpg" title="Abbreviations can lead to ambiguity - would whole words really have hurt that much ? What is this - C ?" style="vertical-align:bottom" />
- getpixeldata <img src="answer.jpg" title="No capitalisation ! Can make the name hard to read - and it breaks the Java style guidelines" style="vertical-align:bottom" />
- sort_by_date <img src="answer.jpg" title="Underscores have no place in Java names (this isn't python !)" style="vertical-align:bottom" />



  


# 
### Task 4: Replication
 <a href='04%20Replication/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='04%20Replication/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Replication is a big issue for the maintainability of code - view the slides and audio narration above to find out why. With the benefit of the knowledge you have gained from this, consider this <a href="code/NaiveCalculator/NaiveCalculator.java" target="_blank">naive implementation</a> of a command line calculator. It contains a lot of replication and inelegant code - see if you can identify various ways you might be able to factor out the replication. Once you have some ideas, take a look at this <a href="code/RefinedCalculator/RefinedCalculator.java" target="_blank" onclick="alert('You did at least *try* to come up with some improvements - right ? I mean, you didnt just click on this link to see the solution straight way ?\n\nNo, of course not - what WAS I thinking !\n\n\nP.S. You might need to enable pop-ups for this page to view the solution');">more refined solution</a>.
  


# 
### Task 5: Structural Quality
 <a href='05%20Structural%20Quality/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='05%20Structural%20Quality/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

Take a look at the slides and audio narrative linked to above relating to structural code quality. With the knowledge gained, review the last significant piece of code that you wrote. Issues of cohesion, coupling, dependency and global referencing are relevant to all types of programming (not just object oriented). You might, for example, wish to revisit one of your submissions for one of the previous programming units - to see how your appreciation of structure has changed.  


# 
### Task 6: Code Decay
 <a href='06%20Code%20Decay/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='06%20Code%20Decay/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

View the slides and audio narration relating to code decay. It is hard to come up with a hands-on exercise for this task (since it addresses longer-term issues than can be covered in a compact activity). Issues of code decay may become directly relevant to your work later on in this unit - you may like to revisit this section at that point for advice on refactoring.  


# 
### Task 7: Why you should care
 <a href='07%20Why%20you%20should%20care/slides/segment-1.pdf' target='_blank'> ![](../../resources/icons/slides.png) </a> <a href='07%20Why%20you%20should%20care/video/segment-1.mp4' target='_blank'> ![](../../resources/icons/video.png) </a>

You might be wondering why we are so keen to impress on you the importance of code quality. View the slides and audio narration to find out why !

Although you won't be expected to apply these principles in the current assignment (OXO), you should be sure to use all of the concepts and constructs covered in this week's workbook in all of your future development work (both on this unit and beyond !)  


# 
