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

}
