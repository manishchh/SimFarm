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


	
	
	
	private void userInput() throws CloneNotSupportedException {
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

			 /**
			  * Processes user input that starts with "t " and performs the till operation on the specified coordinates.
			  *
			  * @param userInput The user input to process
			  * @param field The field object on which to perform the till operation
			  */
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
				
				
			/**
			* Parses user input to check if it starts with "h " and if it contains two numeric values.
			* If the input is invalid, it prints an error message.
			*/
			} else if (userInput.startsWith("h ")) {
				String[] inputs = userInput.split(" ");
				if (inputs.length != 3 || !isNumeric(inputs[1]) || !isNumeric(inputs[2])) {
				    System.out.println("Invalid Input");
				} else {
				    int x = Integer.parseInt(inputs[1]);
				    int y = Integer.parseInt(inputs[2]);
				    Object obj = field.get(x, y);
				    //Harvests food at the given coordinates if it is mature, adds its value to the bank balance,
				    // and removes it from the field. If the food is not mature, prints a message indicating so.
				    // If there is no food at the given coordinates, prints a message indicating so.
				     
				    if (obj instanceof Food) {
				        Food food = (Food) obj;
				        if (food.isMature()) {
				            bankBalance += food.getValue();
				            field.eliminateFood(x, y);
				            System.out.println("Harvested food at (" + x + "," + y + ") for $" + food.getValue());
				        } else {
				            System.out.println("Food at (" + x + "," + y + ") is not mature yet. Please wait.");
				        }
				    } else {
				        System.out.println("No food at (" + x + "," + y + ")");
				    }
				}
			}
			
			/**
			* Parses user input to check if it starts with "h " and if it contains two numeric values.
			* If the input is invalid, it prints an error message.
			*/
			else if (userInput.startsWith("p ")) {
				String[] inputs = userInput.split(" ");
			    if (inputs.length != 3 || !isNumeric(inputs[1]) || !isNumeric(inputs[2])) {
			        System.out.println("Invalid Input");
			    } else {
			        int x = Integer.parseInt(inputs[1]);
			        int y = Integer.parseInt(inputs[2]);
			        /**
			         * Allows the player to plant an item in the field if they have enough money to buy it.
			         * If the player enters 'a', an apple will be planted if they have enough money.
			         * If the player enters 'g', grain will be planted if they have enough money.
			         * If the player cannot afford to plant the item, they will be prompted to try again.
			         */
			        if (field.get(x, y) instanceof Soil) {
			            System.out.println("Enter 'a' to buy an apple for $ or 'g' to buy grain for $");
			            String itemInput = sc.nextLine();
			            if (itemInput.equals("a") && bankBalance >= Apples.getCost()) {
			                field.plant(x, y, new Apples());
			                bankBalance -= Apples.getCost();
			            } else if (itemInput.equals("g") && bankBalance >= Grain.getCost()) {
			                field.plant(x, y, new Grain());
			                bankBalance -= Grain.getCost();
			            } else {
			                System.out.println("You can't afford to plant that item. Please try again.");
			                continue;
			            }
			            System.out.println("Planted " + field.get(x, y)+ " at (" + x + "," + y + ")");
			        } else {
			            System.out.println("You can only plant items in Soil. Please try again.");
			        }
			    }

			}
			//Produce the summary of all the values and quantities of field
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
		
				
				

			
	public void run() throws CloneNotSupportedException {
		field = new Field(this.fieldHeight, this.fieldWidht);
		userInput();
	}
	
		
}

