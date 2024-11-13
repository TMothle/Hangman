import java.io.*;
import java.util.*;

public class ReadFile
{
	public static File file;
	public static Scanner scanner;
	
	public static void openFile(String filePath)
	{
		try
		{
			file = new File(filePath);
			scanner = new Scanner(file);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void closeFile()
	{
		try
		{
			scanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList populateArray()
	{
		ArrayList<String> list = new ArrayList<>();
		
		try
		{
			while(scanner.hasNextLine())
			{
				list.add((String)scanner.nextLine());
			}
			
			closeFile();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
}