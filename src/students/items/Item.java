package students.items;

/**
 * 
 * @author manish chhetri
 * Item is the base class of all farm items. 
 * Every item tracks its age, maturation age, death age, and montery value.
 * All items start at age 0, with the maturation age, death age, and monetary value set as part of its constructor. 
 */
public class Item {
	int age;
	int maturationAge;
	int deathAge;
	int monteryValue;
	
	Item(int maturationAge, int deathAge, int monteryValue){
		this.age = 0;
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
		this.monteryValue = monteryValue;
		
	}

	
	
	
}
