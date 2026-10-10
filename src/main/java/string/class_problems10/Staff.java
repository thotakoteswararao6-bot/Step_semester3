package string.assignment_problems10;

import java.util.*;

abstract class Staff {
    String name,type;
    public Staff(String n,String t){ name=n; type=t; }
    public abstract int pay();
    public String payslip(){ return "Payslip[name="+name+", type="+type+", pay="+pay()+"]"; }
}

class FullTime extends Staff {
    int salary;
    public FullTime(String n,int s){ super(n,"FullTime"); salary=s; }
    public int pay(){ return salary; }
}
class PartTime extends Staff {
    int hours,rate;
    public PartTime(String n,int h,int r){ super(n,"PartTime"); hours=h; rate=r; }
    public int pay(){ return hours*rate; }
}
class Intern extends Staff {
    int stipend;
    public Intern(String n,int s){ super(n,"Intern"); stipend=s; }
    public int pay(){ return stipend; }
}

public class Payroll {
    public static void main(String[] args) {
        List<Staff> staff=new ArrayList<>();
        staff.add(new FullTime("Asha",50000));
        staff.add(new PartTime("Ravi",80,300));
        staff.add(new Intern("Neha",15000));
        int total=0; Staff topper=null;
        for(Staff s:staff){
            System.out.println(s.payslip());
            total+=s.pay();
            if(topper==null||s.pay()>topper.pay()) topper=s;
        }
        System.out.println("Total "+total);
        System.out.println("top earner "+topper.name);
    }
}
