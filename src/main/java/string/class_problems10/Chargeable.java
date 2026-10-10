package string.assignment_problems10;


import java.util.*;

interface Chargeable { void charge(String passNumber); }

abstract class Vehicle {
    String type, passNumber, owner;
    public Vehicle(String type,String pass,String owner){ this.type=type; this.passNumber=pass; this.owner=owner; }
    public abstract int fee();
}

class Bike extends Vehicle {
    public Bike(String pass,String owner){ super("Bike",pass,owner); }
    public int fee(){ return 300; }
}
class Car extends Vehicle {
    public Car(String pass,String owner){ super("Car",pass,owner); }
    public int fee(){ return 1000; }
}
class EBike extends Vehicle implements Chargeable {
    public EBike(String pass,String owner){ super("EBike",pass,owner); }
    public int fee(){ return 300; }
    public void charge(String passNumber){ System.out.println(passNumber+" charging bay allotted"); }
}
class ECar extends Vehicle implements Chargeable {
    public ECar(String pass,String owner){ super("ECar",pass,owner); }
    public int fee(){ return 1000; }
    public void charge(String passNumber){ System.out.println(passNumber+" charging bay allotted"); }
}

public class CampusPass {
    public static void main(String[] args) {
        Map<String,Vehicle> vehicles=new HashMap<>();
        vehicles.put("KA01",new Bike("KA01","Asha"));
        System.out.println("KA01 (Bike) pass fee "+vehicles.get("KA01").fee());
        vehicles.put("KA02",new ECar("KA02","Ravi"));
        System.out.println("KA02 (ECar) pass fee "+vehicles.get("KA02").fee());
        ((Chargeable)vehicles.get("KA02")).charge("KA02");
        if(vehicles.get("KA01") instanceof Chargeable) ((Chargeable)vehicles.get("KA01")).charge("KA01");
        else System.out.println("KA01 rejected: charging unsupported");
    }
}
