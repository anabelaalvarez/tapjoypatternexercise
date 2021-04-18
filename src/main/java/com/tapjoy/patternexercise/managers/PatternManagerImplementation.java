package com.tapjoy.patternexercise.managers;

import com.tapjoy.patternexercise.model.PatternProcessResult;
import com.tapjoy.patternexercise.utils.UtilExtractor;
import com.tapjoy.patternexercise.utils.UtilValidator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


/**
 * IMPLEMENTATION OF PatternManagerInterface.
 * @author anabelaalvarez
 *
 */
public class PatternManagerImplementation implements PatternManagerInterface{

  private static final PatternManagerInterface instance = new PatternManagerImplementation();
	 
  @Override
  /**
   * PatternManagerImplementation.match() is the main routine provided for this manager
   * to identify if the line match or does not match with the pattern.
   * PATTERN DEFINITION:
   * Any 4 char sequence which has a pair of two different characters followed by
   * the reverse of that pair, e.g xaax or raar. 
   * (See specific implementation in UtilValidator.matchPattern(String portion)
   * The string is not considered valid if the pattern above exists in square brackets. 
   * For this reason, 
   * I've splitted the groups of string to analyse: inside or outside the brackets
   * I used regular expression for obtain them. 
   * (See implementation in UtilExtractor.getstringsinbrackets)
   * 
   */
  public Boolean match(String line) {
    // SPLIT IN 2 GROUPS OF STRINGS: 
	// ONE STRINGS WITHIN SQUARE BRACKETS
	// OTHER IS STRING OUSIDE BRACKETS
    Boolean match = false;
    List<String> stringsinbrackets = new ArrayList<String>();
    List<String> stringoutsidebrackets = new ArrayList<String>();
    
    if (line != null) {
      UtilExtractor.getstringsinbrackets(line, stringsinbrackets, stringoutsidebrackets);
      //System.out.println("Inside: ");
      //stringsinbrackets.stream().forEach(System.out::println);

      //System.out.println("Outside: ");
      //stringoutsidebrackets.stream().forEach(System.out::println);
    
      Boolean inbrackets = UtilValidator.matchLine(stringsinbrackets);
      if (!inbrackets) {
        match = UtilValidator.matchLine(stringoutsidebrackets);
      } 
    }
    return match;
  }

  
  /**
   * Process lines from a file,
   * filters lines that not match the predicate/pattern
   * print lines that match with the pattern.
   */
  @Override
  public PatternProcessResult process(String filePath)  {
    PatternProcessResult result = new PatternProcessResult(); 
    Path path = Paths.get(filePath);
   
    
    Predicate<String> linepredicate = line -> match(line);
    result.setQuantity(Long.valueOf(0));
    Consumer<String> printaction = line -> result.getLines().add(line);
    
    //check file data
    try {
		if (Files.exists(path) 
		    && Files.size(path) / 1024 <= 1000  
		    && Files.probeContentType(path).equalsIgnoreCase("text/plain")) {

		  try (Stream<String> streamOfLines = Files.lines(path)) {
		    result.setQuantity(streamOfLines.filter(linepredicate)
		                                    .peek(s -> printaction.accept(s))
		                                    .count());
		    result.setMessage("FINISH OK");
		  } catch (IOException e) {
		    e.printStackTrace();
		    result.setMessage("ERROR OPENNING FILE");
		  }
		} else {
		  result.setMessage("ERROR: FILE NOT FOUND - MAXIMUM SIZE EXCEEDED (10MB) " 
		                    + "- FILE TYPE NOT ALLOWED (ONLY TXT)");
		}
	} catch (IOException e) {
		 result.setMessage("ERROR: INVALID PATH");
	}
    return result;
  }


  public static PatternManagerInterface getInstance() {
    return instance;
  }
  

}
