package com.tapjoy.patternexercise.managers;

import java.io.IOException;

import com.tapjoy.patternexercise.model.PatternProcessResult;

/**
 * Manager for process a line and or file
 * and find if it matchs with the pattern.
 * @author anabelaalvarez
 *
 */
public interface PatternManagerInterface {

  Boolean match(String line);

  PatternProcessResult process(String path) throws IOException;

}
