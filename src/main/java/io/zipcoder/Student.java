package io.zipcoder;

import java.util.ArrayList;

public class Student
{
    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;

    public Student(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        testScores = new ArrayList<Double>();
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public ArrayList<Double> getTestScores()
    {
        return testScores;
    }
    public int getNumberOfTests()
    {
        return testScores.size();
    }
    public void addTestScore(double dubble)
    {
        testScores.add(dubble);
    }
    public void setTestScore(int scoreIndex,double testScore)
    {
        testScores.set(scoreIndex,testScore);
    }
    public double getAverageTestScore()
    {
        double sum = 0;
        for(Double currentScore:testScores)
        {
            sum = sum+currentScore;
        }
        return sum/testScores.size();
    }
    public String toString()
    {
        StringBuilder studentRecordString = new StringBuilder("Student Name:   ");
        studentRecordString.append(firstName).append(" ").append(lastName).append("\n")
                .append("Average Exam Score:   ").append(this.getAverageTestScore())
                .append("\n");
        int i = 0;
        for(double currentScore:testScores)
        {
            i++;
            studentRecordString.append("Exam ").append(i).append(":   ")
                    .append(currentScore).append("\n");
        }
        return studentRecordString.toString();
    }
}
