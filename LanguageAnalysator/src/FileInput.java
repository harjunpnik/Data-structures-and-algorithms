import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput {

	public static String readFile(String path) {
		
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
		
		return text;
	}
	
}
