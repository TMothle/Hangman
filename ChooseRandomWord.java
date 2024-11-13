import java.util.*;
import java.io.*;

public class ChooseRandomWord
{
	public String chooseWord()
	{
		ArrayList<String> list = new ArrayList<>();
		ReadFile file = new ReadFile();
		Random random = new Random();
		
		file.openFile("wordlist/WORDS");
		list = file.populateArray();
		
		int randInt = random.nextInt(list.size());
		
		String word = list.get(randInt);
		
		return word;
	}
}