package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MonthFilter {
    /**
     * This method parses the input file and creates a new file with the names of the persons with the given target month sorted alphabetically.
     * @param inputFileName the name of the input file
     * @param targetMonth the month to be filtered by
     * @param outputFileName the name of the output file
     * @throws IOException if the file does not exist
     */
    public static void parse(String inputFileName, int targetMonth, String outputFileName) throws IOException {
        List<String> results = Files.lines(Paths.get(inputFileName))
                .map(line -> line.split(","))
                .filter(elements -> {
                    LocalDate date = LocalDate.parse(elements[2]);
                    return date.getMonthValue() == targetMonth;
                })
                .map(elements -> elements[0] + "," + elements[1])
                .sorted()
                .collect(Collectors.toList());
        Files.write(Paths.get(outputFileName), results);
    }
}

