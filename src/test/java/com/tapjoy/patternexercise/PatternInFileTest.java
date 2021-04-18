package com.tapjoy.patternexercise;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import com.tapjoy.patternexercise.managers.PatternManagerImplementation;
import com.tapjoy.patternexercise.managers.PatternManagerInterface;
import com.tapjoy.patternexercise.model.PatternProcessResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * UNIT TEST OF THE PATTERN USING FILES.
 * IT IS FOCUSSED IN COUNTING LINES. 
 * FOR SIMPLE LINES SEE: com.tapjoy.patternexercise.PatternTest
 * @author anabelaalvarez
 *
 */
public class PatternInFileTest {

  private PatternManagerInterface manager;

  @BeforeEach
  void setUp() {
    manager = new PatternManagerImplementation();
  }
  
  @DisplayName("Test sample provided for tapjoy")
  @ParameterizedTest
  @ValueSource(strings = {"src/test/resources/001_tapjoy_provided.txt", })
  void test_Input_Provided(String path) throws IOException {
	File file = new File(path);
	String absolutePath = file.getAbsolutePath();
    PatternProcessResult result = manager.process(absolutePath);
    assertTrue(result.getQuantity() == 2);
  }
  
  @DisplayName("Test for file not found")
  @ParameterizedTest
  @ValueSource(strings = {"src/test/resources/001_tapjoy_provided_ZZZ.txt", })
  void test_File_Not_Found(String path) {
    try {
    	File file = new File(path);
    	String absolutePath = file.getAbsolutePath();
		manager.process(absolutePath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    Assertions.fail("File not found.");
  } 
  
}
