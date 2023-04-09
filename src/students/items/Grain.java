package students.items;

public class Grain extends Food{
	
	private static int numberOfInstances = 0;
	private static final int grainCost = 1;
	
	public Grain(){
		super(2,6,2);
		Grain.numberOfInstances++;
		
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Grain)super.clone();
	}
		
	public static int getGenerationCount() {
		return Grain.numberOfInstances;
	}
	
	@Override
	public String toString() {
		if(this.age < this.maturationAge) 
		{
			return "g";
		}
		
		return "G";
		
	}
	
	public int getCost() {
		return grainCost;
	}
}
