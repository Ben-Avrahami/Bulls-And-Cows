import java.util.Random;

import javax.swing.JOptionPane;


public class GameLogic {
	public String number;//will be use to hold the generated random number as a string
	public String allGuesses="";//will be used to hold the user guess
	private int numberOfGuesses;//will be used to count the number of guesses 
	
	/**
	 * defult constructor
	 */
	public GameLogic() {
		number = getNum();
		String allGuesses;
	}
	public int getNumOfGuesses(){
		return numberOfGuesses;
	}
	/**
	 * this method generates a 4 digit number which every digit is different the the rest
	 * it generates a random 0-9 digit 4 times, checks that all the digits are different 
	 * and converts them all to a 4 digit long string
	 * @return a string containing a number between 0-9999 with different digits.
	 */
private String getNum() {
	Random random = new Random();
	int a =random.nextInt(10);//generates a num between 0-9
	int b =random.nextInt(10);//generates a num between 0-9
	while (b==a) {//to make sure the digits are different then the other digits in the number
		 b =random.nextInt(10);//generates a num between 0-9
	}
	int c =random.nextInt(10);//generates a num between 0-9
	while (c==a || c==b) {//to make sure the digits are different then the other digits in the number
		 c =random.nextInt(10);//generates a num between 0-9
	}
	int d =random.nextInt(10);//generates a num between 0-9
	while (d==a || d==b || d==c) {//to make sure the digits are different then the other digits in the number
		 d =random.nextInt(10);//generates a num between 0-9
	}
	String number=""+ a + b + c + d;//concates the different 4 numbers into a String
	return number; 
}
/**
 * this method will check if the input is valid.
 * @param userGuess a String containing the input given by the user.
 * @return true if input is valid, else returns false.
 */
public boolean checkInput(String userGuess) {
if (userGuess.length()!=4)//checks the length of the input
	return false;

return userGuess.matches("[0-9]+");//makes sure the input is only digits	
}
	



public String checkGuess(String userGuess) {
	numberOfGuesses++;
	allGuesses+= "\n" + userGuess +  "\t" ;
	int bool=0;
	int hit=0;
	int firstChar=number.indexOf(userGuess.charAt(0));
	int secondChar=number.indexOf(userGuess.charAt(1));
	int thirdChar=number.indexOf(userGuess.charAt(2));
	int forthChar=number.indexOf(userGuess.charAt(3));
	if(firstChar!=-1) {
		if (firstChar==0)
			bool++;
		else 
			hit++;
	}
	
	if(secondChar!=-1) {
		if (secondChar==1)
			bool++;
		else 
			hit++;
	}
	
	if(thirdChar!=-1) {
		if (thirdChar==2)
			bool++;
		else 
			hit++;
	}
	
	if(forthChar!=-1) {
		if (forthChar==3)
			bool++;
		else 
			hit++;
	}
	if (hit==4)
		gameWon();
	
	allGuesses += " - " + bool + " bool and "+ hit + " hits";
	return ("this time you had " + bool + " bool and "+ hit + " hits");
	
		 
}
private void gameWon() {
	 Game.gameWon=true;
	 allGuesses="";
	 int answer = JOptionPane.showOptionDialog(null, "You guessed correctly, it took you " + numberOfGuesses + " guesses, want to play another game?",   "Game Won",   JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null , null , 0);
	 numberOfGuesses=0;
	 if(answer==0)
		 Game.again=false;
	 else
		 System.exit(0);//stops the game from running
}

}
