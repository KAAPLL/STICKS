import java.lang.Math;
import java.util.Scanner;
public class sticks {
	static int computerMove(int numSticks) {
		int choice = 0;
		if (numSticks % 4 == 0) {
			choice = (int)(1 + Math.random() * 3);
		}
		else {
			choice = numSticks % 4;
		}
		return choice;
	}
	
	static int playerMove(int numSticks, Scanner sc) {
		int choice = 0;
		boolean validMove = false;
		while (validMove == false) {
		System.out.println("How many sticks do you want to remove? 1, 2, or 3: \n");
		choice = sc.nextInt();
		if (choice >= 1 && choice <= 3 && choice <= numSticks) {
			validMove = true;
		}
		else {
			System.out.println("You entered an invalid input. \n");
		}
	}
		return choice;
	}

public static void main(String[] args) {
	//random number of sticks between 21-30
	int numSticks = 21 + (int)(Math.random() * 10);
	System.out.println("You start with " + numSticks + " sticks.");
	int sticksTaken = 0;
	boolean playerTurn = true;
	Scanner sc = new Scanner(System.in);
	boolean validAnswer = false;
	while (validAnswer = false) {
	System.out.println("Do you want to go first? Yes or No: \n");
	String firstTurn = sc.next();
	firstTurn = firstTurn.toLowerCase();
	if (firstTurn.equals("yes")) {
		playerTurn = true;
		validAnswer = true;
	}
	else if(firstTurn.equals("no")) {
		playerTurn = false;
		validAnswer = true;
	}
	else {
		System.out.println("Not a valid response. \n");	
	}
}
	
	while (numSticks > 0) {
		if (playerTurn == true) {
			sticksTaken = playerMove(numSticks, sc);
			numSticks -= sticksTaken;
			playerTurn = false;
			System.out.println("You have taken " + sticksTaken + " sticks. There are " + numSticks + " sticks left. \n");
		}
		else {
			sticksTaken = computerMove(numSticks);
			numSticks -= sticksTaken;
			playerTurn = true;
			System.out.println("The computer has taken " + sticksTaken + " sticks. There are " + numSticks + " sticks left. \n");
		}
		
		if (numSticks == 0) {
			sc.close();
			if (playerTurn == true) {
				System.out.println("The computer wins!");
				break;
			}
			else {
				System.out.println("You win!");
				break;
			}
		}
	}
}
}