package string.assignment_problems10;

import java.util.*;

class Student {
    String roll,name;
    public Student(String roll,String name){ this.roll=roll; this.name=name; }
    @Override public boolean equals(Object o){ return (o instanceof Student) && ((Student)o).roll.equals(this.roll); }
    @Override public int hashCode(){ return roll.hashCode(); }
}

public class Club {
    public static void main(String[] args) {
        Set<Student> members=new HashSet<>();
        Student s1=new Student("21CS01","Asha");
        System.out.println(members.add(s1)?"Added":"duplicate rejected");
        System.out.println(members.add(new Student("21CS01","Asha"))?"Added":"duplicate rejected");
        System.out.println(members.add(new Student("21CS02","Ravi"))?"Added":"duplicate rejected");
        System.out.println("member count "+members.size());
        System.out.println("contains: "+members.contains(new Student("21CS02","Ravi")));
        System.out.println("contains: "+members.contains(new Student("21CS03","Priya")));
    }
}
