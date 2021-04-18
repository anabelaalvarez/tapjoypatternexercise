# tapjoypatternexercise


<h2>About</h2>
Technical Test for tapjoy : Routine that to count and print lines which have the following pattern. 
Pattern: Any 4 char sequence which has a pair of two different characters followed by the reverse of that pair and the string is not considered valid if the pattern above exists in square brackets.


Solution @Author: Anabela Vanesa Alvarez Email: anabelaalvarez@gmail.com

This is a solution using: Java 11.09 Maven 3.6.3 JUnit 5 Lombok 1.18.6 

Main class com.tapjoy.patternexercise.PatternApplication is used for run the app.

PatternApplication starts a ConsoleClient to input file paths or finish the app.

ConsoleClient calls to the manager implementation that identifies and count lines that matchs with the pattern.


Unit tests are  in /patternexercise/src/test/java/com/tapjoy/patternexercise
 using different cases for lines and files.


<h2>Follow these steps to install and run the application</h2>

Follow these steps to install and run the application
clone source code from https://github.com/anabelaalvarez/tapjoypatternexercise.git

build the application mvn clean install

run the app mvn exec:java -Dexec.mainClass="com.tapjoy.patternexercise.PatternApplication"

the app will be waiting to enter a filepath to process. There is a file with lines provided in the exercise 001_tapjoy_provided.txt (in src/test/resources).
You can move to our favourite path and then use it into the app or create a new one.
![FilePath](https://user-images.githubusercontent.com/60371390/115160462-20259200-a090-11eb-9530-3709c148d0ca.JPG)


IMPORTANT NOTE:

exit command finishes the console and the application.


<h2>Assumptions</h2>
 * the pattern is canse-sensitive  ex: rtTr is invalid
 
