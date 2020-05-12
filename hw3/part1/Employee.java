package part1;

public class Employee implements Person {
	private String name;
	private int employeeID;
	private double salary;
	
	public Employee(String name, int id, double salary) {
		// Constructor that initializes name, employeeID, and salary given the parameters
		this.name = name;
		employeeID = id;
		this.salary = salary;
	}
	
	// Fulfills interface method requirement
	public String getName() {
		// Getter for the name
		return name;
	}
	
	public int getEmployeeID() {
		// Getter for the employeeID
		return employeeID;
	}
	
	public double getSalary() {
		// Getter for the salary
		return salary;
	}
}
