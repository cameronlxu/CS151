package part1;

public class Doctor extends Employee {
	private String[] patients;
	
	// Construtor for the Doctor object, initializes the parameters given
	public Doctor(String name, int id, double salary, String[] patients) {
		// calls the superclass Employee class constructor to initialize the name, employeeID, and salary
		super(name,id,salary);
		
		// Initializes other variables not in superclass
		this.patients = patients;
	}
	
	public String[] getPatients() {
		return patients;
	}
	
}
