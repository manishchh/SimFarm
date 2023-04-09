package students;

import java.util.Random;

import students.items.Apples;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;

public class Field {
	Item[][] fieldArray;
	int height;
	int width;
	
	/**
	 * Initializing constructor for Field Class (height, width) 
	 * Creates 2D array of Item object called fieldArray with dimension (height, width) 	
	 */
	public Field(int height, int width) {
		this.height = height;
		this.width = width;
		fieldArray = new Item[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				fieldArray[i][j] = new Soil();
			}
		}	
	}
	
	
	/**
	 *tick() method increases age of item object when it is called
	 *isDead() method replace died item object with new UntilledSoil object in fieldArray
	 *Random is implemented to replace 20% chance of weed in fieldArray if Item object is Soil which is (< 0.2)
	 *tick() method has been implemented in all classes which implements Item interface 
	 */
	public void tick() {
		Random random = new Random();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Item item = fieldArray[i][j];
				//increase age
				item.tick();
				//if item dies
				if (item.isDead()) {
					fieldArray[i][j]= new UntilledSoil();
				}
				else if (item instanceof Soil) {
					//chance of turning to Weed
					if (random.nextDouble() < 0.2) {
						fieldArray[i][j] = new Weed();
					}
				}
			
			}
				
		}
	
	}
	
	/**
	 * @return string representation of Field Object
	 */
	public String toString() {
		String str = " ";
		for (int i = 0; i < width; i++) {
			str += String.format("%-3s", i + 1);
		}
		for (int i = 0; i < height; i++) {
			str += "\n";
			str += String.format("%-3s", (i + 1));
			for (int j = 0; j < width; j++) {
				str += String.format("%-3s", fieldArray[i][j].toString());
			}
		}
		return str;
		
	}
	
	/**
	 * 
	 * @param x position of soil to be tilled
	 * @param y position of soil to be tilled
	 */
	public void till(int x, int y) {
		fieldArray[x][y] = new Soil();
	}
	
	/**
	 * @return clone of item object at specified position
	 * @throws CloneNotSupportedException clone() or cloneable not implemented in Item object or sublcasses
	 */
	public Object get(int x, int y) throws CloneNotSupportedException {
		Object cloned = fieldArray[x][y].clone();
	    return cloned;
	}
	/**
	 * 
	 * @param x position of x - coordinate in farm field  
	 * @param y position of y - coordinate in farm field
	 * @param item object of Item class
	 */
	public void plant(int x, int y, Item item) {
		fieldArray[x][y] = item;
		
	}
	/**
	 * 
	 * @return total monetary Value of all items on field as integer
	 * loop each element on the field Array to find item object in that location which adds to monetaryValue var
	 */
	public int getValue() {
		int monetaryValue = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Item item = fieldArray[i][j];
				monetaryValue += item.getValue();
			}
		}
		return monetaryValue;
	}
	
	/**
	 * returns summary of current state of field 
	 * Counts number of each items
	 * Counts total number of apple grain objects in the farm
	 * calculates monetary value of Apple and Grain
	 * return strings representation of quantities and overall values of the field using StringBuilder object formatted with String.format()
	 */
	public String getSummary() {
		
		int appleCount = 0;
		int grainCount = 0;
		int soilCount = 0;
		int untilledSoilCount = 0;
		int weedCount = 0;
		int total_appleCount =  Apples.getGenerationCount();
		int total_grainCount = Grain.getGenerationCount();
		int monetaryValue = getValue();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Item item = fieldArray[i][j];
				if (item instanceof Apples) {
					appleCount++;
					monetaryValue += item.getValue();
				}
				else if (item instanceof Grain) {
					grainCount++;
					monetaryValue += item.getValue();
				}
				else if (item instanceof Soil) {
					soilCount++;
				}
				else if (item instanceof UntilledSoil) {
					untilledSoilCount++;
				}
				else if (item instanceof Weed) {
					weedCount++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Apples:        %d\n", appleCount));
		sb.append(String.format("Grain:         %d\n", grainCount));
		sb.append(String.format("Soil:          %d\n", soilCount));
		sb.append(String.format("Untilled:      %d\n", untilledSoilCount));
		sb.append(String.format("Weed:          %d\n", weedCount));
		sb.append(String.format("For a total of $%d\n", monetaryValue));
		sb.append(String.format("Total apples created: %d\n", total_appleCount));
		sb.append(String.format("Total grain created: %d\n", total_grainCount));
	
		return sb.toString();
	}
	
}