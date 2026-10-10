package string.assignment_problems10;

import java.util.*;

class StudentMarks {
    String name; int[] marks;
    public StudentMarks(String n,int[] m){ name=n; marks=m; }
    public int total(){ return Arrays.stream(marks).sum(); }
}

public class MarksAnalysis {
    public static void main(String[] args) {
        List<StudentMarks> students=new ArrayList<>();
        students.add(new StudentMarks("Asha",new int[]{78,85,90}));
        students.add(new StudentMarks("Ravi",new int[]{88,92,79}));
        students.add(new StudentMarks("Neha",new int[]{65,70,95}));
        int subjects=3; int[] subjectTotals=new int[subjects];
        StudentMarks topper=null;
        for(StudentMarks s:students){
            int t=s.total();
            System.out.println("Totals "+s.name+" "+t);
            if(topper==null||t>topper.total()) topper=s;
            for(int i=0;i<subjects;i++) subjectTotals[i]+=s.marks[i];
        }
        System.out.print("averages ");
        for(int i=0;i<subjects;i++){
            double avg=(double)subjectTotals[i]/students.size();
            System.out.printf("%.2f%s",avg,(i<subjects-1?", ":"\n"));
        }
        System.out.println("topper "+topper.name+" ("+topper.total()+")");
    }
}
