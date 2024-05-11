package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Boolean.logicalOr;

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
        for(Student currentStudent:students)
        {
            scoreAverageTally=scoreAverageTally+currentStudent.getAverageTestScore();
        }
        return scoreAverageTally/students.length;
    }
    public double getAverageExamScore(int examNumber)
    {
        examNumber=examNumber-1;
        double scoreAverageTally= (double) 0;
        for(Student currentStudent:students)
        {
            ArrayList<Double> studentTestScores = currentStudent.getTestScores();
            scoreAverageTally=scoreAverageTally+studentTestScores.get(examNumber);
        }
        return scoreAverageTally/students.length;
    }
    public Student[] getStudentsByScore()
    {
        Student[] studentsSorted = new Student[students.length];
        Student[] workList = students.clone();
        Student currentHighest = null;
        for(int classRank = 0;classRank<studentsSorted.length;classRank++)
        {
            int highestStudedntIndex = 0;
            for (int j=0;j<workList.length;j++)
            {
                Student currentStudent = workList[j];
                System.out.println("Looking at: "+currentStudent);
                if (currentStudent!=null) {
                    if (currentStudent.getAverageTestScore()>(currentHighest!= null?currentHighest.getAverageTestScore():0))
                    {
                        System.out.println("Current Highest: "+currentHighest);
                        System.out.println("New Highest: "+currentStudent);
                        currentHighest = currentStudent;
                        highestStudedntIndex=j;
                    }
                }
            }
            studentsSorted[classRank]=currentHighest;
            workList[highestStudedntIndex] = null;
            currentHighest=null;
        }
        return studentsSorted;
    }
    @Override
    public String toString() {
        return "Classroom{" +
                "students=" + Arrays.toString(students) +
                '}';
    }
    public static void main(String[] args)
    {
        Student jebby = new Student("Jebby","Dougat");
        Student debby = new Student("Debby","Shnuugat");
        Student rebby = new Student ("Rebecca","P Wtkterwgoehwrqwsadasfsdf");
        Student schlumbo = new Student ("Schlumbo","Withergraves");
        jebby.addTestScore(100.00);
        jebby.addTestScore(92.0);
        jebby.addTestScore(93.0);
        jebby.addTestScore(90.0);
        debby.addTestScore(100.0);
        debby.addTestScore(82);
        debby.addTestScore(88);
        debby.addTestScore(90.0);
        rebby.addTestScore(100);
        rebby.addTestScore(100);
        rebby.addTestScore(100);
        rebby.addTestScore(90.0);
        Student[] constructorList = new Student[]{jebby,debby,rebby};
        Classroom daClass = new Classroom(constructorList);
        Classroom daSecond = new Classroom(3);
        daSecond.addStudent(jebby);
        daSecond.addStudent(debby);
        daSecond.addStudent(rebby);
        daSecond.addStudent(schlumbo);
        System.out.println(daClass);
        System.out.println(daSecond);
        System.out.println(daClass.getAverageExamScore());
        System.out.println(daClass.getAverageExamScore(1));
        System.out.println(daClass.getAverageExamScore(4));
        System.out.println(Arrays.toString(daSecond.getStudentsByScore()));
        daSecond.removeStudent("Schlumbo","dumbo");
        daSecond.removeStudent("Rebecca","P Wtkterwgoehwrqwsadasfsdf");
    }

}
