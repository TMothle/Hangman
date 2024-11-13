import java.util.*;

public class GamePlay
{	
	ArrayList<String> guessedWord = new ArrayList<>();
	String userWord;
	int tries = 7;

	public void userInput()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a letter or word: ");
		userWord = input.nextLine();
		userWord = userWord.toUpperCase();
	}
	
	public void gamePlay()
	{
		ChooseRandomWord genRandomWord = new ChooseRandomWord();
		String randomWord = genRandomWord.chooseWord();
		ArrayList<String> word = new ArrayList<>();
		
		randomWord = randomWord.toUpperCase();
		
		for(int i = 0; i < randomWord.length(); i++)
		{
			word.add(String.valueOf(randomWord.charAt(i)));
			guessedWord.add("_");
		}
		
		System.out.println("\nGuessed word: " + guessedWord.toString());
				
		userInput();
		
		if(userWord.length() > 0 && userWord.length() < 6)
		{
			while(tries != 0)
			{	
				if(userWord.length() == 1)
				{
					if(guessedWord.contains("_"))
					{
						for(int i = 0; i < word.size(); i++)
						{
							if(((Comparable)word.get(i)).compareTo(userWord) == 0)
							{
								guessedWord.set(i, userWord);
							}
						}
						
						if(!word.contains(userWord))
						{
							System.out.println("Incorrect guess.");
							tries--;
						}
					}
					else
					{
						tries = 0;
					}
				}
				
				if(userWord.length() == 5)
				{
					if(randomWord.equals(userWord))
					{
						System.out.println("Correct.");
						for(int i = 0; i < userWord.length(); i++)
						{
							guessedWord.set(i, String.valueOf(userWord.charAt(i)));
						}
							
						tries = 0;
					}
					else
					{
						System.out.println("Incorrect guess.");
						tries--;
					}
				}
				
				if(tries != 0 && guessedWord.contains("_"))
				{
					System.out.println("\nGuessed word: " + guessedWord.toString());
					userInput();
				}
				else
				{
					System.out.println("\nGuessed word: " + guessedWord.toString());
				}
			}
		}
	}
}