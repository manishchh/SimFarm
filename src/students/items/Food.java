package students.items;

/**
 * 
 * @author manish chhetri
 * Food class is abstract because it cannot be instantiated
 * Food class is an item for which it extends from item class
 */
public abstract class Food extends Item{
	// constructor of food class
	Food(int maturationAge, int deathAge, int monetaryValue){
		super(maturationAge, deathAge, monetaryValue);
		
	}
	
	/**
	   * Determines if an object is mature based on its age and maturation age.
	   *
	   * @return true if the object is mature, false otherwise
	   */
	public boolean isMature() {
	    return this.age >= this.maturationAge;
	}
}
