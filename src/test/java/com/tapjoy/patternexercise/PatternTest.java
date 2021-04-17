package com.tapjoy.patternexercise;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tapjoy.patternexercise.managers.MockPatternManager;
import com.tapjoy.patternexercise.managers.PatternManager;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * UNIT TEST OF THE PATTERN USING A SIMPLE LINE/STRING.
 * @author anabelaalvarez
 *
 */
class PatternTest {


  private PatternManager manager;

  @BeforeEach
  void setUp() {
    manager = new MockPatternManager();
  }

 
  
  @DisplayName("Test that verifies Pattern  in empty lines")
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "   ", "\t", "\n" })
  void test_Line_Is_Null(String line) {
    assertFalse(manager.match(line));
  }
  
  @DisplayName("Test that verifies Pattern  in unbalanced line")
  @ParameterizedTest
  @ValueSource(strings =
      {"poihkjnaviu[abwhergvbasiuhjgadbghwesfdvxcih[nwjkkjijkniubgqerqwuy]aehgkuyasgavs"})
  void test_Line_With_Unbalanced(String line) {
    assertFalse(manager.match(line));
  }
  
  @DisplayName("Test that verifies when the pattern is found inside the brackets ")
  @ParameterizedTest
  @ValueSource(strings = {"efgh[baab]ommo",
                 })
  void test_Line_With_Pattern_In_Brackets(String line) {
    assertFalse(manager.match(line));
  }
  
  @DisplayName("Test that verifies when the pattern is found and there are not patterns "
               + "inside the brackets")
  @ParameterizedTest
  @ValueSource(strings = {"rttr[mnop]qrst",
                  "irttrj[asdfgh]zxcvbn"})
  void test_Line_With_Pattern_But_Not_In_Brackets(String line) {
    assertTrue(manager.match(line));
  }
  
  @DisplayName("Test that verifies when the pattern if characters are same")
  @ParameterizedTest
  @ValueSource(strings = {"bbbb[qwer]ereq",
                  "zzzz"})
  void test_Line_With_Same_Characters(String line) {
    assertFalse(manager.match(line));
  }
  
}
