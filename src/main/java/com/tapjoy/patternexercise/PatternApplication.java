package com.tapjoy.patternexercise;

import com.tapjoy.patternexercise.managers.ClientInterface;

/**
 * Start application.
 * @author anabelaalvarez
 *
 */
public class PatternApplication {

	public static void main(String[] args) {
      ClientInterface clientInterface = ClientInterface.getInstance();
      clientInterface.run();

	}

}
