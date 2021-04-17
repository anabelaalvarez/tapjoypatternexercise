package com.tapjoy.patternexercise.model;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * Represent the output object to print.
 * @author anabelaalvarez
 *
 */
public class PatternProcessResult {

  private Long quantity;

  private  Collection<String> lines;
}
