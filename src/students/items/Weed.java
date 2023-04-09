package students.items;

public class Weed extends Item {
	public Weed(){
		super(0,0,-1);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Weed)super.clone();
	}
	
	
	public String toString() {
		return "#";
	}
}
	
	


