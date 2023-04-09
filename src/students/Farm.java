package students;

import java.util.Scanner;

import students.items.Apples;
import students.items.Food;
import students.items.Grain;
import students.items.Soil;

public class Farm {
	int fieldWidht;
	int fieldHeight;
	int startingFunds;
	int bankBalance;
	Field field;
	
	/**
	 *
	 * Initialized Constructor for Farm Class which takes 3 parameters(fieldWidth,fieldHeight,startingFunds)
	 */
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds){
		this.fieldWidht = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.startingFunds = startingFunds;
		this.bankBalance = startingFunds;
		field = new Field(this.fieldHeight, this.fieldWidht);
	}
	
	
	/**
	  * Determines whether a given string is numeric or not.
	  *
	  * @param str The string to check for numeric value
	  * @return true if the string is numeric, false otherwise
	  */
	public boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}


	
	
	
	private void userInput() {
		Scanner sc = new Scanner(System.in);
		String userInput;
		do {
			System.out.println(field.toString() + "\n");
			System.out.println("Bank balance: $" + startingFunds + "\n");
			System.out.println("Enter your next action:");
			System.out.println("t x y: till");
			System.out.println("h x y: harvest");
			System.out.println("p x y: plant");
			System.out.println("s: field summary");
			System.out.println("w: wait");
			System.out.println("q: quit");

			userInput = sc.nextLine();

			if (userInput.startsWith("t ")) {
				String[] inputs = userInput.split(" ");
				if (inputs.length != 3) {
					System.out.println("Invalid Input");
				}
				if (! isNumeric(inputs[1]) || ! isNumeric(inputs[2])) {
					System.out.println("Invalid Input");
					
				}
				int x = Integer.parseInt(inputs[1]);
				int y = Integer.parseInt(inputs[2]);
				if (x >= this.field.width || x < 0) {
					System.out.println("Invalid Input");

				}
				
				if (y >= this.field.height || y < 0) {
					System.out.println("Invalid Input");
				}	
				
				field.till(x, y);
				
				

			} else if (userInput.startsWith("h ")) {
			
			}

			else if (userInput.startsWith("p ")) {
		

			}

			else if (userInput.equals("s")) {
				System.out.println(field.getSummary());

			}

			else if (userInput.equals("w")) {

			} else if (userInput.equals("q")) {

			} else {
				System.out.println("Invalid Input");

			}

		
		} while (!userInput.equals("q"));

	
	}
		
				
				

			
	public void run() {
		field = new Field(this.fieldHeight, this.fieldWidht);
		userInput();
	}
	
		
}

