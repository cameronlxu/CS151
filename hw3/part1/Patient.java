package part1;

public class Patient implements Person {
	private String name;
	private String medicalCondition;
	private int roomNumber; 
	
	public Patient(String name, String medicalCondition, int roomNumber) {
		// Constructor that initializes the name and medicalCondition
	}
	
	// Fulfills interface method requirement
	public String getName() {
		// Getter for the name
		return name;
	}
	
	public String getMedicalCondition() {
		// Getter for the medicalCondition
		return medicalCondition;
	}
	
	public int getroomNumber() {
		// Getter for the roomNumber
		return roomNumber;
	}
	
}

