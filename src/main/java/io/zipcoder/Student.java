package io.zipcoder;

import java.util.ArrayList;

public class Student
{
    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;
    private static int sharedID=1;

    public Student(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        testScores = new ArrayList<Double>();
    }
    public Student()
    {
        this.firstName="student";
        this.lastName="#"+sharedID;
        testScores = new ArrayList<Double>();
        sharedID++;
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
    public String toString()
    {
        return firstName+" "+lastName;
    }
    public ArrayList<Double> getTestScores()
    {
        return testScores;
    }
    public Double[] getTestArray()
    {
        Double[] testScoresArray= new Double[testScores.size()];
        for(int i=0;i<testScoresArray.length;i++)
            testScoresArray[i] = testScores.get(i);
        return testScoresArray;
    }
    public int getNumberOfTests()
    {
        return testScores.size();
    }
    public void addTestScore(double dubble)
    {
        if (!(dubble<=100&&dubble>=0)) {
            System.out.println("Invalid test value.");
            return;
        }
        testScores.add(dubble);
    }
    public void setTestScore(int scoreIndex,double testScore)
    {
        testScores.set(scoreIndex,testScore);
    }
    public double getAverageTestScore()
    {
        if (testScores == null)
            return 0.0;
        double sum = 0;
        for(Double currentScore:testScores)
        {
            sum = sum+currentScore;
        }
        return sum/testScores.size();
    }
    public String toStringLong()
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
    public void takeATest()
    {
        double scoreOffSet = Math.random()*60;
        double score = scoreOffSet+40;
        //System.out.println("Score: "+score);
        testScores.add(score);
    }
    public static void main(String[] args)
    {
        Student jebby = new Student("Jebby","Dougat");
        jebby.addTestScore(100.00);
        jebby.addTestScore(92.0);
        jebby.addTestScore(99.0);
        jebby.addTestScore(70);
        System.out.println(jebby.getNumberOfTests());
        System.out.println(jebby.getTestScores());
        System.out.println(jebby.toStringLong());
    }
}
