package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MonthFilter {
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

