package edu.sveta.log.analizer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main application entry point
 */
public class Main {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("logs/production.log");
        Scanner scan = new Scanner(fr);
        long totalStringCounter = 1;
        int foundStringCounter = 1;

        while (scan.hasNextLine()) {
            String currentString;
            currentString = scan.nextLine();
            if (currentString.contains("Started GET")) {
                System.out.println(currentString);
                foundStringCounter++;
            }
            totalStringCounter++;
        }
        fr.close();

        System.out.println("Got " + foundStringCounter + " from " + totalStringCounter + " strings");
    }
}