package students;

import java.util.Scanner;

import students.items.Apples;

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
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		String player_input;
		while(true){
			
			//display the current balance and field state
			System.out.println(field.toString() + "\n");
			System.out.println("Bank balance: $" + startingFunds + "\n");
			System.out.println("Enter your next action:");
			System.out.println("t x y: till");
			System.out.println("h x y: harvest");
			System.out.println("p x y: plant");
			System.out.println("s: field summary");
			System.out.println("w: wait");
			System.out.println("q: quit");
			
			//ask user choice of input
			player_input = sc.nextLine().trim();
			String[] inputs = player_input.split("\\s+");
			
			/**
			 * check the length of player input is equal to 0 
			 * if 0 ask player to enter the choice again
			 */
			
			if(inputs.length == 0) {
				System.out.println("Invalid input. Try again.");
				continue;
				
			}
			
			
			/**
			 * Attempts to parse the second and third elements of the inputs array as integers representing coordinates.
			 * If successful, assigns the values to x and y variables.
			 * If unsuccessful due to a NumberFormatException, prints an error message and continues the loop.
			 * If unsuccessful due to an ArrayIndexOutOfBoundsException, prints an error message and continues the loop.
			 *
			 * @param inputs An array of strings representing user input
			 * @param x An integer variable to store the x coordinate
			 * @param y An integer variable to store the y coordinate
			 */
			try {
                int x = Integer.parseInt(inputs[1]);
                int y = Integer.parseInt(inputs[2]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input");
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid Input");
                continue;
            }
			
			
			
			
			
			
		}
			
		
	}
	
}
