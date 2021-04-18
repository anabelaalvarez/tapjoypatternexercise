package com.tapjoy.patternexercise.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represent the output object to print.
 * @author anabelaalvarez
 *
 */
@Getter
@Setter
@ToString
public class PatternProcessResult {
	

  public PatternProcessResult() {
		super();
		lines = new ArrayList<String>();
	}

  private Long quantity;

  private  List<String> lines;
  
  private String message;
}
