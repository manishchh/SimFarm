package students.items;

public  class UntilledSoil extends Item {
	
	public UntilledSoil(){
		super(0,0,-1);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (UntilledSoil)super.clone();
	}
	
	
	public String toString() {
		return "/";
	}


}
