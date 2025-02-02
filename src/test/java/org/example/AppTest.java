package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
@RunWith(JUnit4.class)
public class AppTest {
    private static final String TEST_INPUT = "testInput.txt";
    private static final String TEST_OUTPUT = "testOutput.txt";


    @Before
    public void setup() throws IOException {
        Files.write(Paths.get(TEST_INPUT), List.of(
                "Andrei,Popescu,1988-12-23",
                "Ivana,Rus,2002-10-17",
                "Mihai,Georgescu,1996-08-02",
                "Elena,Ceausescu,1948-08-15",
                "Nicolae,Ceausescu,1932-06-12",
                "Vlad,Tepes,1980-04-03"
        ));
    }

    @Test
    public void testMonthFilter() throws IOException {
        MonthFilter.parse(TEST_INPUT, 8, TEST_OUTPUT);
        List<String> actualResult = Files.readAllLines(Paths.get(TEST_OUTPUT));
        List<String> expectedResult = List.of("Elena,Ceausescu", "Mihai,Georgescu");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNoMatch() throws IOException {
        MonthFilter.parse(TEST_INPUT, 1, TEST_OUTPUT);
        List<String> actualResult = Files.readAllLines(Paths.get(TEST_OUTPUT));
        assertTrue(actualResult.isEmpty());
    }
}
