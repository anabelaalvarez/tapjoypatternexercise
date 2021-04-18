package com.tapjoy.patternexercise.managers;

import com.tapjoy.patternexercise.model.PatternProcessResult;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Implementation for user interface
 * @author anabelalvarez
 *
 */
public class ConsoleClient implements ClientInterface {

  private static PatternManagerInterface manager;
  
  private static InputStream systeminput = System.in;
  
  private static final ConsoleClient instance = new ConsoleClient();
  
  private ConsoleClient() {
    super();
    manager = PatternManagerInterface.getInstance();
  }
  
  @Override
  public void run() {
	System.out.println("Welcome to tapjoy pattern solution. Please enter filepath to process or exit to stop the application");
    System.out.print("> ");
    Scanner scannner = new Scanner(systeminput);
    String path = scannner.nextLine();
     
    while (!"exit".equalsIgnoreCase(path)) {
      try {
        PatternProcessResult result = manager.process(path);
        System.out.println(result.getMessage());
        System.out.println("Total lines that match with the pattern: " + result.getQuantity());
        System.out.println("Lines:");
        result.getLines().forEach(System.out::println);
        System.out.println();
        System.out.println();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println("Please enter filepath to process or exit to stop the application");
      System.out.print("> ");
      path = scannner.nextLine();
      
    }
    System.out.println("Good bye!");
    scannner.close();

  }


  public static ClientInterface getInstance() {
    return instance;
  }

}
