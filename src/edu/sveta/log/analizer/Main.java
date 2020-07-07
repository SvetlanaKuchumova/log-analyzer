package edu.sveta.log.analizer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main application entry point
 */
public class Main {
  public static void main(String[] args) throws IOException {
    perform();
//    String line = "I, [2020-05-25T16:45:05.726602 #24782]  INFO -- : [1346ba3a-05bb-4719-a8d7-1666e8c2c380] Started GET \"/orders/autocomplete_company_name?term=recent-trucking-companies\" for 92.100.49.186 at 2020-05-25 16:45:05 +0300";
//
//    line = parseLine(line);
//
//    System.out.println(line);
  }

  private static String parseLine(String line) {
    String[] parts = line.split("\"");
    String part2 = parts[1]; //
    return part2;
  }


  private static void perform() throws IOException {
    FileReader fr = new FileReader("logs/production.log");
    Scanner scan = new Scanner(fr);
    FileWriter fw = new FileWriter("logs/sample1.txt");

    long totalStringCounter = 0;
    int foundStringCounter = 0;

    while (scan.hasNextLine()) {
      String currentString;
      currentString = scan.nextLine();
      if (currentString.contains("Started GET")) {
        //   System.out.println(currentString);
        fw.write(parseLine(currentString) + "\n");
        foundStringCounter++;
      }
      totalStringCounter++;
    }
    fr.close();
    fw.close();
    System.out.println("Got " + foundStringCounter + " from " + totalStringCounter + " strings");
  }
}