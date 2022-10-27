import javax.swing.JOptionPane;

public class Game {
	private static boolean again;
	private static boolean gameWon;

	public static void main (String[]args) {
		JOptionPane.showMessageDialog(null,"Rules:\n The number is 4 digits long with each digit different then the others\n The number is only made up of digits between 0-9 \n Any other char, or repeating the same 0-9 digit more then once will result in an input error","Rules Of The Game- Bulls And Cows",JOptionPane.INFORMATION_MESSAGE);
		while (true) {
			GameLogic game=new GameLogic();//creates a new object of the class GameLogic
			again=true; //resets the values at a game start
			gameWon=false;//resets the values at a game start
			while(again) {//while the user still wants to play will continue to run the loop which is operating the game with the same number
				String guess = JOptionPane.showInputDialog("Guess the number: ");
				if(game.checkInput(guess))//checks if the input is vaild, if it is will continue the game
				{
					String thisTry=game.checkGuess(guess);//calls the gamelogic class checkguess method to check the guess
					if(!gameWon) {
						int answer = JOptionPane.showOptionDialog(null, thisTry+ "\nNumber of guesses: "+ game.getNumOfGuesses()+ " " + game.getAllGuesses() +"\n want to try again?", "Guessing game",   JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null , null , 0);
						if(answer!=0)
							return;//stops the game from running
					} 
				}

				else //if input was not valid 
					JOptionPane.showMessageDialog(null, "input is invalid", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public static void setGameWon(boolean choice) {//will be used to change gameWon by the GameLogic class
		gameWon=choice;
	}

	public static void setAgain(boolean choice) {//will be used to change Again by the GameLogic class
		again=choice;
	}



}
