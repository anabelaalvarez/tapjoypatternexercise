package com.tapjoy.patternexercise.utils;

import java.util.List;
import java.util.function.Predicate;

/**
 * UtilValidator helps to verify conditions for a input string.
 * @author anabelaalvarez.
 *
 */
public class UtilValidator {

  private static int WORD_LENGHT = 4; 
  
  /**
   * Verifies that string parameter
   * matchs with defined pattern: it has 4 characters 
   * and since the middle two characters are different.
   * ASSUMPTION: the pattern is canse-sensitive 
   * trRt is not valid
   * @param portion
   * @return
   */
  private static Boolean matchPattern(String portion) {
    Boolean match = false;
    //Verify string to analize the pattern
    if (portion.length() == WORD_LENGHT) {
      //Split the string in 2 parts
      String first = portion.substring(0, 2);
      String second = portion.substring(2, 4);
      StringBuilder secondstrbuilder = new StringBuilder();
      secondstrbuilder.append(second);
      //return true if first part <> second part and second part is simetric to first part
      String reversed = secondstrbuilder.reverse().toString();
      return (!first.equals(second) && first.equals(reversed));
    }
    return match;
  }

  
  /**
   * Return true if in some string match with the pattern,
   * it receives the list of strings(inside string list / ouside string list).
   * @param portionlines
   * @return
   */
  public static Boolean matchLine(List<String> portionlines) { 
    boolean match = false;
    Predicate<String> predicate = portion -> portionMatchPattern(portion);
    match = portionlines.parallelStream().anyMatch(predicate);
    return match;
  }

  /**
   * Detect if pattern is in a string
   * Iterates sequentialy over string to find the pattern.
   * @param portion
   * @return
   */
  private static Boolean portionMatchPattern(String portion) {
    int i = 0;
    Boolean patternfound = false;
    
    while (!patternfound && i <= portion.length() - WORD_LENGHT) {
      Predicate<String> predicate = str -> matchPattern(str);
      patternfound = predicate.test(portion.substring(i, i + WORD_LENGHT));
      i += 1;
    }
    return patternfound;
  }
  

}
