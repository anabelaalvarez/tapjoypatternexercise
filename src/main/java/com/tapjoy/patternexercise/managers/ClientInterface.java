package com.tapjoy.patternexercise.managers;

/**
 * Simple User Interface to specify a path.
 * @author anabelaalvarez
 *
 */
public interface ClientInterface {

  public void run();

  public static ClientInterface getInstance() {
    return  ConsoleClient.getInstance();
  }

}
