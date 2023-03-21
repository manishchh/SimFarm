package students.items;

public class Apples extends Food {
	
	private static int numberOfInstances = 0;
	private static final int appleCost = 2;
	Apples(){
		super(3,5,3);
		
	}
	
	public int getGenerationCount() {
		return Apples.numberOfInstances;
	}
	public String toString() {
		if (this.age < this.maturationAge)
		{
			return "a";
			
		}
		return "A";
	}
	
	public int getCost() {
		return appleCost;
	}
}
