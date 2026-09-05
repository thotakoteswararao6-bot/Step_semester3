class EmployeeStatic {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeStaticDemo {
    public static void main(String[] args) {
        EmployeeStatic e1 = new EmployeeStatic("Divya", 65000);
        EmployeeStatic e2 = new EmployeeStatic("Arjun", 0);
        EmployeeStatic e3 = new EmployeeStatic("Priya", 45000);

        EmployeeStatic.printCompanyInfo(); // called via class name
    }
}
