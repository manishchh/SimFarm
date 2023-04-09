package students;

import students.items.Apples;

public class Farm {
	int fieldWidht;
	int fileHeight;
	int startingFunds;
	Field field;
	
	/**
	 *
	 * Initialized Constructor for Farm Class which takes 3 parameters(fieldWidth,fieldHeight,startingFunds)
	 */
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds){
		this.fieldWidht = fieldWidth;
		this.fileHeight = fieldHeight;
		this.startingFunds = startingFunds;
	}
	
	public void run(){
		
		field = new Field(this.fileHeight, this.fieldWidht);
		field.plant(2, 4, new Apples());
	}
	
}
