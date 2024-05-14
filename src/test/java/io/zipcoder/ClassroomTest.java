package io.zipcoder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassroomTest
{
    static Student jebby;
    static Student debby;
    static Student rebby;
    static Student[] constructorList;
    static Classroom daClass;
    @BeforeAll
    public static void setup()
    {
        jebby = new Student("Jebby","Dougat");
        debby = new Student("Debby","Shnuugat");
        rebby = new Student ("Rebecca","P Wtkterwgoehwrqwsadasfsdf");
        jebby.addTestScore(100.00);
        jebby.addTestScore(90.0);
        debby.addTestScore(90.0);
        debby.addTestScore( 80.0);
        rebby.addTestScore(80.0);
        rebby.addTestScore(100);
        Student[] constructorList = new Student[3];
        constructorList[0]=jebby;
        constructorList[1]=debby;
        constructorList[2]=rebby;
        daClass = new Classroom(constructorList);

    }
@Test
    public void testGetAverageExamScore()
{
        double averageExam = daClass.getAverageExamScore();
        assertEquals(85.0,debby.getAverageTestScore());
        assertEquals(95.0,jebby.getAverageTestScore());
        assertEquals(90,rebby.getAverageTestScore());
        assertEquals(90.0,averageExam);
    }
    public void testGetStudentsByScore() {
    }
    public void testGetGradeBook() {
    }
}
