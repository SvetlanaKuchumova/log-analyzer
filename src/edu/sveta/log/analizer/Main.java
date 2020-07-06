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

        FileReader fr = new FileReader("logs/production.log");
        Scanner scan = new Scanner(fr);
        FileWriter fw = new FileWriter( "logs/sample1.txt" );

        long totalStringCounter = 0;
        int foundStringCounter = 0;

        while (scan.hasNextLine()) {
            String currentString;
            currentString = scan.nextLine();
            if (currentString.contains("Started GET")) {
             //   System.out.println(currentString);
                fw.write(currentString + "\n");
                foundStringCounter++;
            }
            totalStringCounter++;
        }
        fr.close();
        fw.close();
        System.out.println("Got " + foundStringCounter + " from " + totalStringCounter + " strings");
    }
}