import javax.swing.JOptionPane;

public class Game {
	public static boolean again;
	public static boolean gameWon;
public static void main (String[]args) {
	while (true) {
	GameLogic game=new GameLogic();
	again=true; 
	gameWon=false;
	while(again) {
	System.out.println(game.number);
	String guess = JOptionPane.showInputDialog("Guess the number: ");
	if(game.checkInput(guess))//checks if the input is vaild, if it is will continue the game
	{
	String thisTry=game.checkGuess(guess);
	if(!gameWon) {
	int answer = JOptionPane.showOptionDialog(null, thisTry+ "\nNumber of guesses: "+ game.getNumOfGuesses()+ " " + game.allGuesses +"\n want to try again?", "Guessing game",   JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null , null , 0);
	if(answer!=0)
		return;//stops the game from running
	} 
	}
	
	else //if input was not valid 
		JOptionPane.showMessageDialog(null, "input is invalid", "Invalid Input", JOptionPane.ERROR_MESSAGE);
}
	}
}

}
