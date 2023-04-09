package students.items;

/**
 * 
 * @author manish chhetri
 * Item is the base class of all farm items. 
 * Every item tracks its age, maturation age, death age, and montery value.
 * All items start at age 0, with the maturation age, death age, and monetary value set as part of its constructor. 
 */

public abstract class Item implements Cloneable{
	int age;
	int maturationAge;
	int deathAge;
	int monetaryValue;
	
	/**
	 * Defining constructor of item class 
	 */
	Item(int maturationAge, int deathAge, int monetaryValue){
		this.age = 0;
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
		this.monetaryValue = monetaryValue;
		
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		try {
	        return (Item)super.clone();
	    } catch (CloneNotSupportedException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
			
			
		
	/**
	 * Age increases by 1
	 */
	public void tick() {
		this.age++;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
	/**
	 * to check whether item has died
	 * @return  true if age > deathAge else false
	 */
	public boolean died() {
		return this.age > this.deathAge;
		
	}
	
	
	/**
	 *  Value is returned if food item age is >= maturation age else 
	 *  return 0 if item is not matured 
	 */
	public int getValue() {
		if (this.age >= this.maturationAge) {
			return this.monetaryValue;
		}
		else {
			return 0;
		}
	}
	
	
	/**
	 * check if food items age is equal to other object.
	 * 
	 * @return true if object equal else false
	 *
	 */
	public boolean equals(Object obj) {
		Item other = (Item) obj;
		if(other == null) {
			return false;
		}
		if (this.age == other.age && this.deathAge == other.deathAge && this.maturationAge == other.maturationAge && this.monetaryValue == other.monetaryValue) {
			return true;
		}
			
		return false;
		
	}
	
	


	
	/*
	 * Implementation of abstract method to instantiate subclasses which returns string representation of item class
	 */
	public abstract String toString();

	
	
	

	
}	

