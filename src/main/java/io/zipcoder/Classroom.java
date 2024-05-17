package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Classroom
{

    private Student[] students;
    public Classroom(int maxStudents)
    {
        students = new Student[maxStudents];
    }
    public Classroom(Student[] studentBody)
    {
        students = studentBody;
    }
    public Classroom()
    {
        students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }
    public void removeStudent(String firstName,String lastName)
    {
        for(int i=0;i< students.length;i++)
        {
            if  (firstName.equals(students[i].getFirstName())||lastName.equals(students[i].getLastName()))
            {
                System.out.println("Removing "+students[i].toString());
                students[i] = null;
                return;
            }
        }
        System.out.println("Student "+firstName+" "+lastName+" not found in this classroom.");
    }
    public void addStudent(Student theGuyWeAdding)
    {
        for (int i=0;i<students.length;i++)
        {
            Student currentStudent=students[i];
            if(currentStudent==null)
            {
                students[i]=theGuyWeAdding;
                System.out.println("Student "+theGuyWeAdding+" successfully added to classroom");
                return;
            }
        }
        System.out.println("Classroom full! Student not added.");
    }
    public double getAverageExamScore()
    {
        double scoreAverageTally=0;
        int emptyTally=0;
        for(Student currentStudent:students)
        {
            if (currentStudent==null) {
                emptyTally++;
                continue;
            }
            scoreAverageTally=scoreAverageTally+currentStudent.getAverageTestScore();
        }
        return scoreAverageTally/(students.length-emptyTally);
    }
    public double getAverageExamScore(int examNumber)
    {
        examNumber=examNumber-1;
        double scoreAverageTally=0;
        int emptyTally=0;
        for(Student currentStudent:students)
        {
            if ((currentStudent==null))
            {
                emptyTally++;
                continue;
            }
            Double[] studentTestScores = currentStudent.getTestArray();
            scoreAverageTally=scoreAverageTally+studentTestScores[examNumber];
        }
        return scoreAverageTally/(students.length-emptyTally);
    }
    public Student[] getStudentsByScore()
    {
        int emptyTally = 0;
        for (Student currentStudent:students)
        {
            if(currentStudent==null)
                emptyTally++;
        }
        Student[] studentsSorted = new Student[(students.length-emptyTally)];
        Student[] workList = students.clone();
        Student currentHighest = null;
        for(int classRank = 0;classRank<studentsSorted.length;classRank++)
        {
            int contenderIndex = 0;
            for (int j=0;j<workList.length;j++)
            {
                Student currentStudent = workList[j];
                if (currentStudent!=null) {
                    //System.out.println("Looking at: "+currentStudent);
                    if (currentStudent.getAverageTestScore()>(currentHighest!= null?currentHighest.getAverageTestScore():0))
                    {
                        //System.out.println("Current Highest: "+currentHighest);
                        //System.out.println("New Highest: "+currentStudent);
                        currentHighest = currentStudent;
                        contenderIndex=j;
                    }
                }
            }
            if ((currentHighest!=null))
            {
                //System.out.println("Class Rank " + (classRank + 1) + ":   " + currentHighest);
                studentsSorted[classRank] = currentHighest;
                workList[contenderIndex] = null;
                currentHighest = null;
            }
        }
        return studentsSorted;
    }
    public HashMap<Student, Character> getGradeBook()
    {
        Student[] studentsSorted = getStudentsByScore();
        HashMap<Student, Character> gradeMap = new HashMap<Student, Character>();
        for(int i = 0;i<studentsSorted.length;i++)
        {
            char letterGrade;
            double percentile = (double)(studentsSorted.length-i)/(studentsSorted.length)*100;
            if (percentile>=90.0)
            letterGrade='A';
            else if (percentile>=71.0)
            letterGrade='B';
            else if(percentile>=50)
            letterGrade='C';
            else if(percentile>=11)
            letterGrade='D';
            else
            letterGrade='F';
            gradeMap.put(studentsSorted[i],letterGrade);
        }
        return gradeMap;
    }
    public void giveATest()
    {
        for(Student current :students)
        {
            if (current==null)
                continue;
            current.takeATest();
        }
    }
    public void giveTests(int numberToGive)
    {
        for(int i =0;i<numberToGive;i++)
            giveATest();
    }
    @Override
    public String toString() {
        return "Classroom{" +
                "students=" + Arrays.toString(students) +
                '}';
    }
    public static void main(String[] args)
    {
        int emptySlots = 20;
        Student[] constructorList = new Student[100];
        for(int i=0;i< constructorList.length-emptySlots;i++)
        {
            constructorList[i]=new Student();
        }
        Classroom daClass = new Classroom(constructorList);

        System.out.println(daClass);
        int numberOfTests = 10;
        daClass.giveTests(numberOfTests);
        System.out.println(daClass.getAverageExamScore());
        System.out.println(daClass.getAverageExamScore(1));
        System.out.println(daClass.getAverageExamScore(4));

        System.out.println(daClass.getGradeBook().toString());
    }
}
