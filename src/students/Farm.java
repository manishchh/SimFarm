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
			
			
			
			
			
			
			
		}
			
		
	}
	
}
