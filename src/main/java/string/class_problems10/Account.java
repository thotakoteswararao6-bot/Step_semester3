package string.assignment_problems10;

import java.util.*;

abstract class Account {
    String id;
    int balance;
    public Account(String id,int initial){ this.id=id; this.balance=initial; }
    public abstract boolean withdraw(int amount);
}

class Savings extends Account {
    public Savings(String id,int initial){ super(id,initial); }
    public boolean withdraw(int amount){
        if(balance-amount < 1000){
            System.out.println(id+" rejected: minimum balance 1000");
            return false;
        }
        balance -= amount;
        System.out.println(id+" balance "+balance);
        return true;
    }
}

class Current extends Account {
    public Current(String id,int initial){ super(id,initial); }
    public boolean withdraw(int amount){
        if(balance-amount < -5000){
            System.out.println(id+" rejected: overdraft limit 5000");
            return false;
        }
        balance -= amount;
        System.out.println(id+" balance "+balance);
        return true;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Map<String,Account> accounts=new HashMap<>();
        accounts.put("S1",new Savings("S1",5000));
        accounts.get("S1").withdraw(4500);
        accounts.put("C1",new Current("C1",2000));
        accounts.get("C1").withdraw(6000);
        accounts.get("S1").withdraw(3000);
        accounts.get("C1").withdraw(2000);
    }
}
