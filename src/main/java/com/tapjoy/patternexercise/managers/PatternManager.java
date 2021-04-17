package com.tapjoy.patternexercise.managers;

import com.tapjoy.patternexercise.model.PatternProcessResult;
import java.util.function.BooleanSupplier;

/**
 * 
 * @author anabelaalvarez
 *
 */
public interface PatternManager {

  BooleanSupplier match(String line);

  PatternProcessResult process(String path);

}
