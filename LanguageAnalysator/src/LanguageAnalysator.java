import java.util.Arrays;

public class LanguageAnalysator {

	public static void main (String[]args){
		String msg = FileInput.readFile("Italiano.txt");
		//System.out.println(msg);
		// Regex for Deutch,Estonina,English,French,Italian,Norwegian,Finnish,Swedish
		String parsedMsg = FileInput.regexTest(msg);
		System.out.println(parsedMsg);
		String[] split = parsedMsg.split(" ");
		System.out.println(Arrays.asList(split));
		System.out.println(split[0]);
	}
	
}
