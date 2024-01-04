import java.util.ArrayList;

abstract class Employee
{
    private String name;
    private int id;

    // constructor
    public Employee(String name , int id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString()
    {
        return "Employee[name="+name+" , id="+id+" , salary="+calculateSalary()+"]"; 
    }

}

class FullTimeEmployee extends Employee
{
    private double monthlySalary;

    // Constructor 
    public FullTimeEmployee(String name , int id , double monthlySalary )
    {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    // override abstract method parent class
    @Override
    public double calculateSalary()
    {
        return monthlySalary;
    }

}

class PartTimeEmployee extends Employee
{
    private int hoursWorked;
    private double hourlyRate;

    // constructor
    public PartTimeEmployee(String name , int id , int hoursWorked , double hourlyRate)
    {
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // override abstract method parent class
    @Override
    public double calculateSalary()
    {
        return hoursWorked * hourlyRate;
    }
}

class PayRollSystem
{
    private ArrayList<Employee> employeeList;

    // Constructor allocate memory of ArrayList
    public PayRollSystem()
    {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }

    // we have an id of employee we can traverse through arraylist and can remove an employee who have that id 
    public void removeEmployee(int id)
    {
        Employee employeeToRemove = null;
        for(Employee employee : employeeList)
        {
            if(employee.getId() == id)
            {
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null)
        {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees()
    {
        for(Employee employee : employeeList)
        {
            System.out.println(employee);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");  
        
        PayRollSystem payRollSystem = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("vikas", 1, 70000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("alexander", 2, 4, 100.0);

        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details: ");
        payRollSystem.displayEmployees();

        System.out.println("Removing Employees");
        payRollSystem.removeEmployee(2);
        
        System.out.println("Remaining Emplyees Details:");
        payRollSystem.displayEmployees();
    }
}