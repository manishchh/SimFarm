package students;

import java.util.Random;
import students.items.Item;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;

public class Field {
	Item[][] fieldArray;
	int height;
	int width;
	
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
}