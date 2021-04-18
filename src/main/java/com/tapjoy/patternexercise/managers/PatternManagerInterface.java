package com.tapjoy.patternexercise.managers;

import com.tapjoy.patternexercise.model.PatternProcessResult;
import java.io.IOException;

/**
 * Manager for process a line and or file
 * and find if it matchs with the pattern.
 * @author anabelaalvarez
 *
 */
public interface PatternManagerInterface {

  Boolean match(String line);

  PatternProcessResult process(String path) throws IOException;

  static PatternManagerInterface getInstance() {
	  return  PatternManagerImplementation.getInstance();
  }

}
