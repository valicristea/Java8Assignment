package org.example;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input file name: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Target month: ");
        int targetMonth = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Output file name: ");
        String outputFileName = scanner.nextLine();

        MonthFilter.parse(inputFileName,targetMonth,outputFileName);
    }
}
