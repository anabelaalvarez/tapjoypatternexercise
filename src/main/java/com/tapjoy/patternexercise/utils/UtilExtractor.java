package com.tapjoy.patternexercise.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UtilExtractor has the logic to extract 
 * a string list from brackets.
 * @author anabelaalvarez
 *
 */
public class UtilExtractor {

  private static String insidebracketspattern = "\\[(.*?)\\]";

  
  /**
   * Return in stringinsidebrackets parameter a list of strings within square brackets 
   * and in stringoutsidebrackets a list of string ouside of the brackets.
   * @param line
   * @return
   */
  public static void getstringsinbrackets(String line,  List<String> stringinsidebrackets,
                                          List<String> stringoutsidebrackets) {
    
    String outputstr = line;
    //Create a pattern object
    Pattern pattern = Pattern.compile(insidebracketspattern);
    //Match the compiled pattern in the String
    Matcher matcher = pattern.matcher(line);
    
    //Create lists of strings to return
    List<String> listinsidebrackets = new ArrayList<String>();
    //using the same regexpression I can obtain the string ouside the brackets
    String[] ouside = line.split(insidebracketspattern);
    List<String> listoutsidebrackets = new ArrayList<String>(Arrays.asList(ouside));
   
    //Iterate over all elements to add it into the list
    while (matcher.find()) {
      String content = matcher.group();
      //Verify obtained string is balanced
      Boolean balance = content.codePoints().filter(ch -> ch == '[').count() == 1;
      if (balance) {
        //Add the string like this if string is balanced
        listinsidebrackets.add(matcher.group().replaceAll("\\[", "").replaceAll("\\]", ""));
        outputstr = outputstr.replace(matcher.group(), "");
      } else {
        //if unbalanced:
        //   add string before second occurrence of [ to outside list  
        //   add string inside brackets to inside list
        int endsubstring = content.substring(1, content.length()).indexOf("[");
        String outsidestr = content.substring(0, endsubstring + 1);
        listoutsidebrackets.add(outsidestr);
        content =  content.substring(1, content.length());
        Matcher matcherinside = pattern.matcher(content); 
        if (matcherinside.find()) {
          listinsidebrackets.add(matcherinside.group().replaceAll("\\[", "").replaceAll("\\]", ""));
          outputstr = outputstr.replace(matcherinside.group(), "");
        }
      }
    }
    stringoutsidebrackets.addAll(listoutsidebrackets);
    stringinsidebrackets.addAll(listinsidebrackets);
  }

}
