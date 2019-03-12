import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;



public class FileInput {

	public static ArrayList<String> readFile(String path) {
		
		String text = new String();
		
		try {
			FileInputStream fileIn = new FileInputStream(path);
			int tempChar;
			
			while( (tempChar = fileIn.read()) != -1) {
				text += String.valueOf((char)tempChar);
			}
			
		}catch (FileNotFoundException ex) 
	       {
	           System.out.println("File was not found: " + ex.getMessage());
	       }
	       catch (IOException ex) 
	       {
	           System.out.println("IOException occured: " + ex.getMessage());
	       }
		ArrayList<String> textArray = parseData(text);
		
		return textArray;
	}
	
	public static ArrayList<String> parseData(String text) {
		// Regex for Deutch,Estonina,English,French,Italian,Norwegian,Finnish,Swedish
		String regex = "[^A-Za-zåÅäÄöÖæÆøØÀàâÂçÇéÉèÈêÊëËìÌíÍîÎïÏòÒóÓôÔõÕšŠßœŒùÙúÚûÛüÜÿŸ ]";
		String tempText;
		tempText = text.replaceAll(regex, "");
		System.out.println(tempText);
		ArrayList<String> words = new ArrayList<>(Arrays.asList(tempText.split("\\s+")));
		return words;
	}
	
}
