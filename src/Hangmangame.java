//Author: Redwan Hossain
/* This is a hangman game. This program is going to ask the user to chose a letter for a randomly selected word from a file. If the user chose a right letter
 * it will ask user to chose next right letter. If the user fail to chose the right letter, it will give the user 5 options
 *  to chose the right letter. If the user make six mistakes the hangman will be hanged and the game
 * will be ended. After that the user will have options to start the game or end.  
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Hangmangame {
	//Keeping the words in a string for user to play the
	private static String[] words = {"Makkahmedina", "Wilmington", "Unitedstates", "Bangladesh", "Middleeast", "Southasian","RedwanHossain","Computerscience" };
	//The user will get random words to play from the string of words
	private static String word = words[(int) (Math.random() * words.length)];
	//Based on how many letters in the word the "-" will be replaced
	private static String asterisk = new String(new char[word.length()]).replace("\0", "-");

	private static int count = 0;



	public static void main(String[] args) throws FileNotFoundException {
		//Will let user to input
		Scanner sc = new Scanner(System.in);
		
		while (count < 6 && asterisk.contains("-")) {

			System.out.println("Guess a letter for this word");

			System.out.println(asterisk);

			String guess = sc.next();

			hang(guess);

		}


	}

	/*public static void readWords(String inputFile) throws FileNotFoundException {
		
		File readFile = new File(inputFile);
		Scanner scanFile = new Scanner(readFile);
		while(scanFile.hasNext()) {
			String line = scanFile.nextLine();
			words=line.split(",");
		}
		System.out.println(words[0]);
		scanFile.close();
	}*/

//Will provide user to guess letter 
	public static void hang(String guess) {

		String newasterisk = "";

		for (int i = 0; i < word.length(); i++) {

			if (word.charAt(i) == guess.charAt(0)) {

				newasterisk += guess.charAt(0);
				System.out.println("Great! You have guessed right letter");

			} else if (asterisk.charAt(i) != '-') {

				newasterisk += word.charAt(i);

			} else {

				newasterisk += "-";

			}

		}



		if (asterisk.equals(newasterisk)) {

			count++;

			hangmanImage();

		} else {

			asterisk = newasterisk;

		}

		if (asterisk.equals(word)) {

			System.out.println("You guessed the word correctly! The word was " + word);
			System.out.println("Do you like to play again?");

		}

	}

//Will draw hangman image based on the mistakes user make

	public static void hangmanImage() {
//This will be the first hangman image if user chose wrong letter 
		if (count == 1) {

			System.out.println("Wrong guess(1), try again");

			System.out.println(" |---------");

			System.out.println("(0)");
		}
		//This will be the second hangman image if user chose second wrong letter 
		if (count == 2) {

			System.out.println("Wrong guess(2), try again");

			System.out.println(" |---------");

			System.out.println("(0)");

			System.out.println(" |");

		}
		//This will be the third hangman image if user chose third wrong letter 

		if (count == 3) {

			System.out.println("Wrong guess(3), try again");

			System.out.println(" |---------");

			System.out.println("(0)");

			System.out.println("/|");

		}
		//This will be the forth hangman image if user chose forth wrong letter 
		if (count == 4) {

			System.out.println("Wrong guess(4), try again");

			System.out.println(" |---------");

			System.out.println("(0)");

			System.out.println("/|\\");


		}
	//This will be the fifth hangman image if user chose fifth wrong letter 
		if (count == 5) {

			System.out.println("Wrong guess(5), try again");

			System.out.println(" |---------");

			System.out.println("(0)");

			System.out.println("/|\\");

			System.out.println("/ ");

		}
		//The hangman will be hanged if user chose sixth wrong letter 
		if (count == 6) {

			System.out.println("Wrong guess(6) and your GAME OVER!");

			System.out.println(" |---------");

			System.out.println("(0)");

			System.out.println("/|\\");

			System.out.println("/\\");


			System.out.println("GAME OVER! The word was " + word);

		}

	}
}
/*Output:
 
**********************First game: When the user guess the correct word**************************


	Guess a letter for this word
	----------
	a
	Great! You have guessed right letter
	Guess a letter for this word
	-------a--
	f
	Wrong guess(1), try again
	 |---------
	(0)
	Guess a letter for this word
	-------a--
	e
	Great! You have guessed right letter
	Great! You have guessed right letter
	Guess a letter for this word
	-----eea--
	M
	Great! You have guessed right letter
	Guess a letter for this word
	M----eea--
	i
	Great! You have guessed right letter
	Guess a letter for this word
	Mi---eea--
	d
	Great! You have guessed right letter
	Great! You have guessed right letter
	Guess a letter for this word
	Midd-eea--
	l
	Great! You have guessed right letter
	Guess a letter for this word
	Middleea--
	s
	Great! You have guessed right letter
	Guess a letter for this word
	Middleeas-
	t
	Great! You have guessed right letter
	You guessed the word correctly! The word was Middleeast
	Do you like to play again?
	
	
	
	
	
*****************	"Second Game: When the user fail to choose the right word" ****************
	
	
	
	Guess a letter for this word
----------
b
Wrong guess(1), try again
 |---------
(0)
Guess a letter for this word
----------
s
Great! You have guessed right letter
Guess a letter for this word
--------s-
e
Great! You have guessed right letter
Guess a letter for this word
-------es-
d
Great! You have guessed right letter
Guess a letter for this word
------des-
e
Great! You have guessed right letter
Wrong guess(2), try again
 |---------
(0)
 |
Guess a letter for this word
------des-
w
Wrong guess(3), try again
 |---------
(0)
/|
Guess a letter for this word
------des-
q
Wrong guess(4), try again
 |---------
(0)
/|\
Guess a letter for this word
------des-
h
Great! You have guessed right letter
Guess a letter for this word
------desh
b
Wrong guess(5), try again
 |---------
(0)
/|\
/ 
Guess a letter for this word
------desh
a
Great! You have guessed right letter
Great! You have guessed right letter
Guess a letter for this word
-a---adesh
f
Wrong guess(6) and your GAME OVER!
 |---------
(0)
/|\
/\
GAME OVER! The word was Bangladesh


*/