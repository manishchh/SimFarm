package students.items;

public class Soil extends Item {
	 public Soil(){
		super(0,0,0);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {									
		return (Soil)super.clone(); 
	}
	
	 
	public String toString() {
		return ".";
	}

}
