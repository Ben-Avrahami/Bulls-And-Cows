import java.util.Random;

import javax.swing.JOptionPane;
/**
 * This Class holds the methods for the game logic.
 * for example methods to reset the game, game constructors, input validation and checking against the generated number
 * and more methods to run the game.
 * @author Ben Avrahami
 *
 */

public class GameLogic {
	private String number;//will be use to hold the generated random number as a string
	private String allGuesses="";//will be used to hold the user guess
	private int numberOfGuesses;//will be used to count the number of guesses 
	private final static int LENGTH_OF_NUMBER=4;
	/**
	 * Default constructor
	 */
	public GameLogic() {
		number = getNum();//generates a random 4 digit number
		numberOfGuesses=0;
	}
	/**
	 * this method restarts the game values so a new game can start without the need to create a new object, by resetting the current object value.
	 */
	public void restart() {
		number = getNum();//generates a random 4 digit number
		numberOfGuesses=0;
		allGuesses=""; 

	}
	/** 
	 *
	 * @return int representing numberOfGuesses variable value.
	 */
	public int getNumOfGuesses(){
		return numberOfGuesses;
	}

	/**
	 * 
	 * @return string representation of the random generated number the user is trying to guess playing the game.
	 */
	public String getNumber(){
		return number;
	}
	/**
	 * 
	 * @return string representation of the user guesses so far at the current game. 
	 */
	public String getAllGuesses(){
		return allGuesses;
	}


	/**
	 * this method generates a 4 digit number which every digit is different the the rest
	 * it generates a random 0-9 digit 4 times, checks that all the digits are different 
	 * and converts them all to a 4 digit long string
	 * @return a string containing a number between 0-9999 with different digits.
	 */
	private String getNum() {
		Random random = new Random();
		int a =random.nextInt(10);//random char between 0-9
		int b =random.nextInt(10);//random char between 0-9
		while (b==a) {//to make sure the digits are different then the other digits in the number
			b =random.nextInt(10);//random char between 0-9
		}
		int c =random.nextInt(10);//random char between 0-9
		while (c==a || c==b) {//to make sure the digits are different then the other digits in the number
			c =random.nextInt(10);//random char between 0-9
		}
		int d =random.nextInt(10);//random char between 0-9
		while (d==a || d==b || d==c) {//to make sure the digits are different then the other digits in the number
			d =random.nextInt(10);//random char between 0-9
		}
		String number=""+ a + b + c + d;//Connects the different 4 numbers into a String
		return number; 
	}
	/**
	 * this method will check if the input is valid.
	 * @param userGuess a String containing the input given by the user.
	 * @return true if input is valid, else returns false.
	 */
	public boolean checkInput(String userGuess) {
		if (userGuess.length()!=LENGTH_OF_NUMBER)//checks the length of the input
			return false;
		for(int i=0; i<LENGTH_OF_NUMBER ;i++) {
			for(int j=0; j<LENGTH_OF_NUMBER ;j++) {
				if(j!=i && userGuess.charAt(i)==userGuess.charAt(j)) //if 2 of the chars are the same
					return false;	
			}
		}
		return userGuess.matches("[0-9]+");//makes sure the input is only digits	
	}



	/**
	 * this method compares the user guess to the randomly generated number
	 * @param userGuess a string containing the user guess
	 * @return string representing how many bulls and cows the user guessed correctly
	 */

	public String checkGuess(String userGuess) {
		numberOfGuesses++;//adds one to number of guess counter
		allGuesses+= "\n" + userGuess +  "\t" ;//adds to the allGuesses string
		int bull=0;
		int cow=0;
		int firstChar=number.indexOf(userGuess.charAt(0));
		int secondChar=number.indexOf(userGuess.charAt(1));
		int thirdChar=number.indexOf(userGuess.charAt(2));
		int forthChar=number.indexOf(userGuess.charAt(3));
		//calculates how many bulls and cows the player got in his guess
		if(firstChar!=-1) {
			if (firstChar==0)
				bull++;
			else 
				cow++;
		}

		if(secondChar!=-1) {
			if (secondChar==1)
				bull++;
			else 
				cow++;
		}

		if(thirdChar!=-1) {
			if (thirdChar==2)
				bull++;
			else 
				cow++;
		}

		if(forthChar!=-1) {
			if (forthChar==3)
				bull++;
			else 
				cow++;
		}
		if (bull==LENGTH_OF_NUMBER)
			gameWon();
		//adds to the allGuesses and returns to the user a string in a correct format  
		if(bull>1 && cow>1) {
			allGuesses += " - " + bull + " bulls and "+ cow + " cows";
			return ("this time you had " + bull + " bulls and "+ cow + " cows");
		}

		else if(bull>1 && cow<=1) {
			allGuesses += " - " + bull + " bulls and "+ cow + " cow";
			return ("this time you had " + bull + " bulls and "+ cow + " cow");	
		}

		else if(bull<=1 && cow>1) {
			allGuesses += " - " + bull + " bull and "+ cow + " cows";
			return ("this time you had " + bull + " bull and "+ cow + " cows");
		}
		else if (bull<=1 && cow<=1) {
			allGuesses += " - " + bull + " bull and "+ cow + " cow";
			return ("this time you had " + bull + " bull and "+ cow + " cow");
		}
		return"";//will not reach this return because it will always enter one of the if statements 

	}
	/**
	 * this method is used when the player guessed the number correctly and lets him choose if he wants to play again or not
	 */
	private void gameWon() {
		Game.setGameWon(true);
		allGuesses="";
		int answer = JOptionPane.showOptionDialog(null, "You guessed correctly, it took you " + numberOfGuesses + " guesses, want to play another game?",   "Game Won",   JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null , null , 0);
		numberOfGuesses=0;
		if(answer==0)
			Game.setAgain(false);//will set the game to run again
		else
			System.exit(0);//stops the game from running
	}

}
