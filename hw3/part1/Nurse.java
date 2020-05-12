package part1;

public class Nurse extends Employee {
	private int[] rooms;
	
	// Construtor for the Nurse object, initializes the parameters given
	public Nurse(String name, int id, double salary, int[] rooms) {
		// Overrides the Employee superclass constructor 
		super(name,id,salary);
		
		// Initializes other variables not in superclass
		this.rooms = rooms;
	}
	
	public int[] getRooms() {
		return rooms;
	}
	
}