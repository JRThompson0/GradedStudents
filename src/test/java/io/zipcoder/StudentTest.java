package io.zipcoder;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class StudentTest
{
    private static Student debby;

    @BeforeAll
    public static void studentSetup()
    {
        debby = new Student("Debby","Weiner");
        debby.addTestScore(90.0);
        debby.addTestScore(91.0);
        debby.addTestScore(92.0);
    }
    @Test
    public void addTestNegativeTest()
    {
        debby.addTestScore(0.0);
        debby.addTestScore(101);
        assertEquals(3,debby.getNumberOfTests());
    }
    @Test
    public void testGetNames()
    {
        assertEquals("Debby",debby.getFirstName());
        assertEquals("Weiner",debby.getLastName());
        assertEquals("Debby Weiner",debby.toString());
    }
    @Test
    public void testFunctionTest()
    {
        ArrayList<Double> trouble = new ArrayList<Double>();
        trouble.add(90.0);trouble.add(91.0);trouble.add(92.0);
        assertEquals(trouble,debby.getTestScores());
        assertEquals(trouble.size(),debby.getNumberOfTests());
        double averageScoah=debby.getAverageTestScore();
        boolean actual=averageScoah==91.0;
        assertEquals(true,actual);
    }
}