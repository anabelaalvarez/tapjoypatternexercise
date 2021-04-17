package com.tapjoy.patternexercise;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.tapjoy.patternexercise.managers.MockPatternManager;
import com.tapjoy.patternexercise.managers.PatternManager;
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

  private PatternManager manager;

  @BeforeEach
  void setUp() {
    manager = new MockPatternManager();
  }
  
  @DisplayName("Test sample provided for tapjoy")
  @ParameterizedTest
  @ValueSource(strings = {"src/test/resources/001_tapjoy_provided.txt", })
  void test_Input_Provided(String path) {
    PatternProcessResult result = manager.process(path);
    assertFalse(result.getQuantity() == 1);
  }
  
  @DisplayName("Test sample provided for tapjoy")
  @ParameterizedTest
  @ValueSource(strings = {"src/test/resources/001_tapjoy_provided_ZZZ.txt", })
  void test_File_Not_Found(String path) {
    manager.process(path);
    Assertions.fail("File not found.");
  } 
  
}
