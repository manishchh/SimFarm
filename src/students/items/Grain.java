package students.items;

public class Grain extends Food{
	
	private static int numberOfInstances = 0;
	private static final int grainCost = 1;
	
	Grain(){
		super(2,6,2);
	}
	
	public int getGenerationCount() {
		return Grain.numberOfInstances;
	}

	public String toString() {
		if(this.age < this.maturationAge) 
		{
			return "g";
		}
		
		return "G";
	}
}
